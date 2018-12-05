<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<%
	//자바코드를 작성하는 부분
	//session객체를 사용하고 있다.
	//서블릿에서는 session객체를 사용하기 위해서는?
	//HttpSession session = request.getSession()과 같이 수동으로 생성해 주어야 하지만...
	//jsp에서는 세션객체를 자동으로 생성해 주기 때문에 생성하는 코드 부분이 없이 바로 사용이 가능하다. 
/*
서블릿에서 로그인이 성공해서 세션영역에 id값이 저장되어 있다면 저장되어 있는 id가 반환되고
id가 저장되어 있지 않으면 즉!! 로그인이 되어 있지 않은 상태라면 null
*/
	
	String id=(String)session.getAttribute("id");

%>
<body>

<%
	//서블릿에 세션값을 저장하지 않았으면(로그인이 되어 있지 않아 null값이 반환되면)
	if(id == null){
		
	

%>
	<!-- 서블릿에 세션값을 저장하지 않았으므로 로그인 메뉴가 출력 되게 하기 -->
	<a href="login.jsp" target="rightFrame">로그인</a>
<%
}else{//서블릿에 세션 id를 저장한 값이 있다면?
%>
	<%=id %>님 환영 합니다.
<%
	}
%>



메뉴 페이지
</body>
</html>