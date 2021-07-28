package service;

import java.io.File;
import java.io.UnsupportedEncodingException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import dao.MemberDao;
import domain.Member;
import util.ConnectionProvider;

public class MemberRegService {
	// 싱글톤 패턴
	private MemberRegService() {}
	private static MemberRegService service = new MemberRegService();
	public static MemberRegService getInstance() {
		return service;
	}

	// upload 파일의 사용자 요청을 모두 request로 되어 있기 땜누에 request를 메소드 매개변수로 넣기
	public int regMember(HttpServletRequest request) throws FileUploadException {
		int resultCnt = 0;
		Member member = new Member();
		Connection conn = null;
		MemberDao dao = null;
		File newFile = null;
		
		try {
		// upload.jsp 파일에서 일부 복제하기
		//1. multipart 여부 확인
		boolean isMultipart = ServletFileUpload.isMultipartContent(request);

		if (isMultipart) {
			DiskFileItemFactory factory = new DiskFileItemFactory();
			ServletFileUpload upload = new ServletFileUpload(factory);
			List<FileItem> items = upload.parseRequest(request);
			
			Iterator<FileItem> itr = items.iterator();

			while (itr.hasNext()) {

				FileItem item = itr.next();

				if (item.isFormField()) {
					//회원 아이디, 회원 이름, 비밀번호를 사용자로부터 받으면 set에 저장
					String paramName = item.getFieldName();
					if(paramName.equals("memberid")){
						member.setMemberid(item.getString("utf-8"));
					}else if(paramName.equals("password")){
						member.setPassword(item.getString("utf-8"));
				    }else if(paramName.equals("password")){
				    	member.setMembername(item.getString("utf-8"));
				    }
				} else {
					//사진 데이터 처리
					
					//경로 만들기
					String uploadUri = "upload";
					//시스템의 경로 가져오기
					String dir = request.getSession().getServletContext().getRealPath(uploadUri);
					
					File saveDir = new File(dir);
					
					//파일 디렉토리가 존재하지 않으면 saveDir를 
					//따로 폴더를 만들지 않아도 자동으로 만들어게 됨.
					//-> 그러면 우리가 그 경로를 받아다가 쓸 수가 있다.
					if(saveDir.exists()) {
						
					}
						
						//paramName 은 아이템의 필드네임에서 가져온다.
						String paramName = item. getFieldName();
					//paramName 이 photo라면 파일이름과 사이즈를 구해서 
						if(paramName.equals("photo")) {
							//파일 이름을 갖고 있고, 사이즈가 0보다 크다면 파일을 저장한다.
							if(item.getName() != null && item.getSize()>0) {
								//저장 - 만들어놓은 경로 saveDir 에다가 저장을 하기.
								newFile = new File(saveDir, item.getName());
								item.write(newFile);//예외처리 하기
								//저장이 되었다면 DB에도 파일이름을 통해 저장하기.
								member.setMemberphoto(item.getName());
							}
						}
						
				}
				
			} 
		}else {
			throw new Exception("multipart 타입이 아닙니다.");

		}
		////////////////////////////////////////
		//DB insert
		//Connection, MemberDao 필요
		 conn = ConnectionProvider.getConnection();
		 dao = MemberDao.getInstance();
		 
		 resultCnt = dao.insertMember(conn, member);
		
		
		}catch(SQLException e) {
			//ㅇㅖ외 발생하면 파일의 위치를 가지고 파일을 지워주기. 그러려면 파일의 위치를 알아야 함. ->  파일 위치를 ㄹ위한 newFile 변수 만들기
			// DB 입력시 오류가 발생하면 파일을 삭제해 주어야 한다. 삭제하지 않으면 쓰레기 파일이 쌓이게 될 것이다.
			if(newFile != null && newFile.exists()) {
				//newFile 이 존재하면 파일을 삭제
				newFile.delete();
			}
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}catch(Exception e) {
			e.printStackTrace();
		}
		request.setAttribute("result", resultCnt);
		return resultCnt;
	}
}
