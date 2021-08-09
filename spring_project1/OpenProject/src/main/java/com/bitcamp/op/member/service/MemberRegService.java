package com.bitcamp.op.member.service;

import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.bitcamp.op.jdbc.ConnectionProvider;
import com.bitcamp.op.member.dao.MemberDao;
import com.bitcamp.op.member.domain.Member;
import com.bitcamp.op.member.domain.RegRequest;

@Service
public class MemberRegService {

	@Autowired
	MemberDao dao;
	
	final String UPLOAD_URI = "/uploadfile";
	
	public int reg(RegRequest regRequest, HttpServletRequest request) {
		int resultCnt = 0;
		Connection conn = null;
		File newFile = null;
		Member member = null;
		try {
			conn=ConnectionProvider.getConnection();
			
			member.setMemberid(regRequest.getMemberid());
			member.setPassword(regRequest.getPassword());
			member.setMembername(regRequest.getMembername());
			
			if(regRequest.getMemberphoto() != null) {
				
				member.setMemberphoto(regRequest.getMemberphoto().getOriginalFilename());
				newFile = saveFile(request, regRequest.getMemberphoto());
				
			}else {
				member.setMemberphoto("");
			}
			resultCnt = dao.insertMember(conn, member);
			//아이디 중복 체크 하기
			//int cnt = dao.selectById(conn, id);
	
			
			
		} catch (SQLException | IllegalStateException | IOException e) {
			e.printStackTrace();
			if(newFile != null & newFile.exists()) {
				newFile.delete();
				System.out.println("파일 삭제");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return resultCnt;
	}
	private File saveFile(
			HttpServletRequest request, 
			MultipartFile file
			) throws IllegalStateException, IOException {
		String saveDir = request.getSession().getServletContext().getRealPath(UPLOAD_URI);
		File newFile = new File(saveDir, file.getOriginalFilename());
		file.transferTo(newFile);
		return newFile;
	}
}
