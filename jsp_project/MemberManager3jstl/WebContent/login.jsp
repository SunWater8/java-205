<%@page import="java.sql.SQLException"%>
<%@page import="util.ConnectionProvider"%>
<%@page import="dao.MemberDao"%>
<%@page import="java.sql.Connection"%>
<%@page import="domain.Member"%>
<%@page import="util.CookieBox"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <% 
    //1. 사용자가 전달한 데이터를 받고 
    //2. DB에서 확인
    //3. DB에서 정보를 확인하고 로그인 처리 - Session 객체에 사용자 정보를 저장
    //	 로그인 상태로 유지해야 하는 다른 페이지에 세션이 있는지 없는지 확인하고 
    //	 없으면 loginForm.jsp 로 보내서 로그인 하도록 유도한다.		
    //4. reid 확인 하고 값을 받아오면 쿠키 설정
    
    //1. 변수 초기화
    String memberId = request.getParameter("memberid");
    String password = request.getParameter("password");
    String reid = request.getParameter("reid");
    
    //5. DB에서 데이터 연결할 준비
    Connection conn = null;
    MemberDao dao = null;
    
    //4. 로그인 체크하기
    boolean loginChk = false; 
    //true가 되기 위해서는 memberId와 password 를 db에서 받아와야 한다.
    //db에 갔다오기 전 입력된 값이 어떤지에 따른 기준을 다음과 같이 먼저 정해주어야 한다.
    if(memberId != null && password != null && memberId.trim().length()>2 && password.trim().length()>3){
    	//아이디와 비밀번호가 입력되지 않으면 이 조건식에 들어올 수 없다.
    	//그리고 입력된 문자열이 아이디는 3자 이상, 비밀번호는 4자 이상이 되어야만 이 조건식을 들어올 수 있다.
    	
    // 5. Member 객체에 아이디와 비밀번호 받아오기
    	try{
    		conn = ConnectionProvider.getConnection();
    		dao = MemberDao.getInstance();
    		//DB 가서 Member 객체 불러오기
    		//selectByIdPw 메소드는 아직 만들어 지지 않았기에 지금 만들면 됨.
    		Member member = dao.selectByIdPw(conn, memberId, password);
    		
    		//사용자가 입력한 데이터가 DB에 있는 데이터와 일치를 했을 경우의 조건식
    		
    		if(member != null){
    			// 일치한다면 회원의 정보를 Session  객체에 저장하기
    			// session.setAttribute("member", member); // LoginIfo 클래스 생성 이후에 수정하기 위해 주석처리.
    			session.setAttribute("loginInfo", member.toLoginInfo());
    			//loginChk는 false 에서 true 로 바뀌도록 하기.
    			loginChk = true;
    		} 
    		
    		
    		 
    	}catch(SQLException e){
    		e.printStackTrace();
    	}
    }
    
    //2. 쿠키 설정
    //id 저장을 위한 쿠키 설정
    // reid 값의 유무 체크
    if(reid != null && reid.equals("on")){ //두개의 조건을 둔 이유는 혹여 다른 곳에서 체크할 수 있기 때문
		//체크를 했다면 쿠키를 만들어 사용자의 id 저장하기
		response.addCookie(CookieBox.makeCookie("reid", memberId, "/", 60*60*24*30));
    }else{
    	//체크를 해제했다면 쿠키 값을 저장하지 않는다.
		response.addCookie(CookieBox.makeCookie("reid", memberId, "/", 0));
    }
    
    //6.로그인에 성공하면 로그인 되었다고 알려주는 것이 아니라 메인 페이지로 바로 이동하게 하기
    if(loginChk){
    	response.sendRedirect("index.jsp");
    }else{ //로그인 안되면 이전 페이지로 이동.
    %>
    <script>
    	alert('아이디 또는 비밀번호가 일치하지 않습니다.');
		history.go(-1);
    </script>
    <%	
    }
    %>
