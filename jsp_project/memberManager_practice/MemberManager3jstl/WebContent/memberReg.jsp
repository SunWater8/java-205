<%@page import="util.ConnectionProvider"%>
<%@page import="dao.MemberDao"%>
<%@page import="domain.Member"%>
<%@page import="java.sql.SQLException"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("utf-8");
%>
<!-- usebean 으로 domain 안의 Member를 인스턴스 하기 -->
<jsp:useBean id="member" class="domain.Member" />

<!-- Member 객체를 참조하는 member의 모든 property(변수)들을 매핑해주기
	 즉, regForm.jsp 에 있는 name에 해당하는 값들(memberid, password, membername)을
	 Member객체에 저장해 주는 것을 말함.
-->
<jsp:setProperty property="*" name="member" />
<!-- *컴포넌트 역할 수행
	 - jsp 컨테이너(톰캣)는 useBean을 이용하여  parameter의 값들을 가지고 Member 클래스의 객체를 만들고,
	 setProperty로 Member 클래스의 set~메소드 인자값에 regForm의 name 속성 넣어 연결 시켜 줌. 
	 - 원래는 request.getParameter 메소드를 사용했어야 했음. 하지만 이 방식은 Spring 가서 사용하지 않음.
	 - 이런 작업이 되려면 member의 변수와 regForm의 name 속성 값이 같은 이름으로 되어 있어야 한다. -->


<%
	out.println(member);

	int result = 0;
	Connection conn = null;
	MemberDao dao = null;

	try {
		conn = ConnectionProvider.getConnection();
		dao = MemberDao.getInstance();

		result = dao.insertMember(conn, member);

	} catch (SQLException e) {
		e.printStackTrace();
	}

	//out.println(result);

	if (result > 0) {
%>
<script>
	alert('등록되었습니다.');
	location.href = '<%= request.getContextPath()%>/index.jsp';
</script>
<%
	} else {
%>
<script>
	alert('오류 발생으로 등록되지 않았습니다.\n입력페이지로 다시 이동합니다.');
	//location.href = 'dept_regForm.jsp';
	window.history.go(-1);
</script>
<%
	}
%>



