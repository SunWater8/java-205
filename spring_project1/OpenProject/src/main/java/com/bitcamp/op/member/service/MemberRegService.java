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
	private MemberDao dao;

	final String UPLOAD_URI = "/uploadfile";

	public boolean memberReg(RegRequest regRequest, HttpServletRequest request) {

		boolean result = false;

		Connection conn = null;
		File newFile = null;
		Member member = null;

		try {
			member = regRequest.toMember();

			if (regRequest.getPhoto() != null && !regRequest.getPhoto().isEmpty()) {

				// member.setMemberphoto(regRequest.getPhoto().getOriginalFilename());
				File newDir = new File(request.getSession().getServletContext().getRealPath(UPLOAD_URI));

				if (!newDir.exists()) {
					newDir.mkdir();
					System.out.println("저장 폴더를 생성했습니다.");
				}
				// 파일 저장시에 파일 이름이 같으면 덮어쓴다 -> 회원별 고유한 파일 이름을 만들자!!, 새로운 파일이름에 확장자 추가
				String newFileName = regRequest.getMemberid() + System.currentTimeMillis()
						+ chkFileType(regRequest.getPhoto());
				// cool123128936798123987

				// 새로운 File 객체
				newFile = new File(newDir, newFileName);

				regRequest.getPhoto().transferTo(newFile);
				member.setMemberphoto(newFileName);
			} else {
				member.setMemberphoto("photo.png");
			}
			conn = ConnectionProvider.getConnection();
			int count = dao.insertMember(conn, member);
			if (count > 0) {
				result = true;
			}

		} catch (IllegalStateException | IOException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			// DB 예외 발생 시 -> 저장된 파일을 삭제
			if (newFile != null && newFile.exists()) {
				newFile.delete();
			}
			e.printStackTrace();
		} catch (Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
		return result;
	}

	// 파일의 ContentType 과 파일 확장자를 체크
	private String chkFileType(MultipartFile file) throws Exception {
		String extension = "";

		// 업로드 파일의 contentType
		String contentType = file.getContentType();
		if (!(contentType.equals("image/jpeg") || contentType.equals("image/jpg") || contentType.equals("image/png")
				|| contentType.equals("image/gif"))) {
			throw new Exception("허용하지 않는 파일 타입 : " + contentType);
		}

		// 파일 확장자 구하기
		String fileName = file.getOriginalFilename();

		// String[] java.lang.String.split(String regex)
		// : 정규식의 패턴 문자열을 전달해야하기 때문에 \\. 으로 처리
		String[] nameTokens = fileName.split("\\."); /// tet.mini2.jpg PNG png

		// 토큰의 마지막 index의 문자열을 가져옴 : 배열의 개수-1
		extension = nameTokens[nameTokens.length - 1].toLowerCase();

		// 이미지 파일 이외의 파일 업로드 금지
		// 파일 확장자 체크
		if (!(extension.equals("jpg") || extension.equals("png") || extension.equals("gif"))) {
			throw new Exception("허용하지 않는 파일 확장자 타입 : " + contentType);
		}

		return extension;
	}
}
