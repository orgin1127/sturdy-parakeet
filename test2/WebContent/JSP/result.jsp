<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>[ Redirect와 forward ]</h1>

<%
	//request의 attribute 읽기
	String s = (String) request.getAttribute("str");
	Integer n = (Integer) request.getAttribute("num");
	String a[] = null;
	if ( request.getAttribute("ar") != null) {
		 a = (String[]) request.getAttribute("ar");
	}
	//request의 parameter 읽기
	String p = request.getParameter("param");
%>
	<p>str : <%=s %></p>
	<p>num : <%=n %></p>
	<p>ar : 
	<%if (a != null) { %>
		<%for(int i=0; i<a.length; i++){ %>
			<%if (a == null) { %>
				<%="" %>
			<% } else { %>
				<%=a[i] %>
			<% } %>
		<% } %></p>
	<%} %>
	<p>param : <%=p %></p>
	
	<div><b><h4>↑이 루트를 거쳐 왔지만 주소에는 맨 처음 get방식 요청 주소가 남는다. 
	forward 방식은 실제 값이 보여지는 페이지와 주소창에 남아있는 주소가 다른것을 명심</h4></b></div>
	<!-- forward방식은 result.jsp라는 페이지가 열려도 주소창에는 그 전 페이지(get방식으로 요청할때 쓴 목적지 주소)가
		주소창에 남아있다-->
</body>
</html>