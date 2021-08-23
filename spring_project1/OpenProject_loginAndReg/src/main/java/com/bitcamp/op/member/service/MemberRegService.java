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
import com.bitcamp.op.jdbc.JdbcUtil;
import com.bitcamp.op.member.dao.MemberDao;
import com.bitcamp.op.member.domain.Member;
import com.bitcamp.op.member.domain.MemberRegRequest;

@Service
public class MemberRegService {

	final String UPLOAD_URI = "/uploadfile";

	@Autowired
	private MemberDao dao;

	public int memberReg(MemberRegRequest regRequest, HttpServletRequest request) {

		int resultCnt = 0;
		Connection conn = null;
		File newFile = null;

		try {
			// 1. 파일 저장

			// Member 객체 생성 해주고, 저장된 파일의 이름을 set하도록 한다.(RegRequest의 toMember 메소드는 파일 이름을 원래
			// 이름 그대로 저장하려고 하기 때문에 여기서 파일 이름을 바꿔주는 처리를 해주어야 한다.)
			Member member = regRequest.toMember();

			// 파일 저장
			if (regRequest.getPhoto() != null && !regRequest.getPhoto().isEmpty()) {

				// 시스템 경로
				String path = request.getSession().getServletContext().getRealPath(UPLOAD_URI);
				// 새로운 저장 폴더 : File
				File newDir = new File(path);

				// 폴더가 존재하지 않으면 폴더 생성
				if (!newDir.exists()) {
					newDir.mkdir();
					System.out.println("저장 폴더를 생성했습니다.");
				}
				// 회원 간에 저장되는 파일 이름이 같으면 덮어쓴다 -> 새로운 회원별 고유한 파일 이름을 만들자!!(회원 아이디를 이용할 예정), 새로운
				// 파일이름에 확장자 추가
				String newFileName = regRequest.getMemberid() // 회원 아이디 가져오기
						+ System.currentTimeMillis() // <- 이 메소드가 반환하는 것이 long 타입의 정수형이긴 해도 앞에서 더할 값인
														// regRequest.getMemberid()가 문자열이기 때문에 결과적으로 문자열간의 결합이 되게 된다.
						+ "." + chkFileType(regRequest.getPhoto());
				// cool123128936798123987

				// 파일 저장하기 - 그러기 위해서는 새로운 File 객체 필요
				newFile = new File(newDir, newFileName); // 파일을 업로드 해서 DB에 저장할 때 DB와 연결하는 과정에서 예외가 발생할 떄 newFile이 존재하는지
															// 여부를 체크한 다음 있다면 지워주는 작업을 해주면 된다. 그래서 newFile에 대한 객체를 위에다
															// 선언함.
				regRequest.getPhoto().transferTo(newFile);
				member.setMemberphoto(newFileName); // 파일 업로드 하면서 새롭게 지은 파일 이름을 db에 저장할 때 적용시키기
				
				// 파일 저장하기
				if (regRequest.getPhoto() != null && !regRequest.getPhoto().isEmpty()) {
					regRequest.getPhoto().transferTo(newFile);
				}
				// member.setMemberphoto(newFileName);
			} else {
				member.setMemberphoto("photo.png");
			}

			// 2. dao 저장
			conn = ConnectionProvider.getConnection(); // db와 연결 과정에서 예외 발생할 수 있음.

			resultCnt = dao.insertMember(conn, member);

			System.out.println("새롭게 등록된 idx => " + member.getIdx());

			// idx 값은 자식 테이블의 insert 시 외래키로 사용

			// 자식테이블 insert 구문....

		} catch (IllegalStateException | IOException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			// DB 예외 발생 시 -> 저장된 파일을 삭제 ( DB와 연결하는 과정에서 예외가 발생할 떄 newFile이 존재하는지 확인하고 , 있다면
			// 파일을 지워주고 없던일처럼 만들기)
			if (newFile != null && newFile.exists()) {
				newFile.delete();
			}
			e.printStackTrace();
		} catch (Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		} finally {
			JdbcUtil.close(conn);
		}

		return resultCnt;
	}

	// 파일의 ContentType 과 파일 확장자를 체크
	private String chkFileType(MultipartFile file) throws Exception {
		String extension = "";

		// 업로드 파일의 contentType
		String contentType = file.getContentType();
		if (!(contentType.equals("image/jpg") || contentType.equals("image/png") || contentType.equals("image/gif"))) {
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
