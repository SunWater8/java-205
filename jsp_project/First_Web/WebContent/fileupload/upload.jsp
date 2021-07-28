<%@page import="java.util.Iterator"%>
<%@page import="org.apache.commons.fileupload.FileItem"%>
<%@page import="java.util.List"%>
<%@page import="org.apache.commons.fileupload.disk.DiskFileItemFactory"%>
<%@page import="org.apache.commons.fileupload.servlet.ServletFileUpload"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%/* 
	사용자가 전송한 데이터와 파일을 저장 
	-> 그다음 view페이지 쪽으로 파일의 경로를 전달하면 
	-> 지정된 경로의 이미지를 출력해본다.  */
	
	//사용자 폼 데이터 받기
	String title = null;
	//서버에 저장된 파일의 이름
	String newFile = null; 
	
	//파일 업로드를 처리하기 
	// 1. multipart 여부 확인하기
	boolean isMultipart = ServletFileUpload.isMultipartContent(request);
	
	if(isMultipart){ 
		//multipart 가 맞다고 하면 파일을 받을 준비를 하기
		//2. 파일을 저장할 Factory 객체를 생성하기
		DiskFileItemFactory factory = new DiskFileItemFactory(); 
		//3. 요청 처리를 위해서 ServletFileUpload를 생성하기. 요청처리란 form 안에 있는 input 들을 분리하는 것을 말한다. 
		// - 입력해야는 폼들 (input 태그들 관련) 분리해서 각각을 객체로 저장하기
		ServletFileUpload upload = new ServletFileUpload(factory);
		//4. 사용자 요청을 파싱(분리:원하는 형태로 분리 -> 각각의 input들을 FileItem 객체로 만들어 준다.)
		// FileItem 은 Input 에 데이터를 저장하고 있는 객체를 의미한다. input이 가지는 type, name, value 등등의 내용을 담는다.
		List<FileItem> items = upload.parseRequest(request);
		//컬렉션 프레임워크에서 리스트(열거형으로 된 것)를 순서 없이 줄세우기
		Iterator<FileItem> itr = items.iterator();
		
		//순서 없이 줄세운거 가지고 다음의 요소가 있는지 확인하는 것이 hasNext 메소드이다.
		while(itr.hasNext()){
			//하나의 파일 아이템을 iterator에 있는 next 메소드를 통해서 처리를 하기
			FileItem item = itr.next(); //text, checkbox, hidden, password, file등등이 올 수 있다.모두 문자열로 반환할 수 있다. 근데 file만 또다른 바이너리 데이터를 받아서 처리하고 있다.
			//따라서 파일이나 파일 이외의 것이냐로 구분을 한다. file이 아닌 것을 formfield라고 한다. formfield는 문자열만 가져오면 되고 file은 파일이름, size, 쓰기를 해야한다.
			
			//item이 file이나 formfield이냐를 구분하기
			if(item.isFormField()){
				//일반 input type 처리 (formfield 일 때)
				
				//form의 parameter 이름, 해당form의 데이터(문자열 String)을 구해오기
				String paramName = item.getFieldName();
				
				if(paramName.equals("title")){
					String paramValue = item.getString("utf-8"); 
					title = paramValue;	
					
					//데이터 출력하기
					out.println("title : "+title+"<br>");
				}else if(paramName.equals("title2")){
					//..
				}
				
			}else{
				//type=file 일 때 처리
				
				String paramName = item.getFieldName();
				if(paramName.equals("photo")){
					String userFileName = item.getName(); //파일의 이름 가져오기
					String contentType = item.getContentType(); //content Type을 가져오기
					long fileSize = item.getSize(); //바이트 사이즈 가져오기
					
					//출력해보기
					out.println("fileName : "+userFileName+"<br>");
					out.println("contentType : "+contentType+"<br>");
					out.println("file size : "+fileSize+"<br>");
				}else if(paramName.equals("file")){
					//..
				}
						
						
			}
			
		}
		
		
		
		
		
	}
%>

<%-- <jsp:forward page="upload_view.jsp"></jsp:forward> --%>