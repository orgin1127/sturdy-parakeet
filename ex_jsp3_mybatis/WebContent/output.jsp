<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="test.jsp3.vo.Person"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>output.jsp</title>
</head>
<body>
<h1>[ 서버로부터 전달된 데이터 출력 ]</h1>

<%
	//요청 정보에 저장된 객체 읽기
	ArrayList<Person> list = (ArrayList<Person>) request.getAttribute("list");
	if (list == null) {
%>
		<p>등록된 데이터가 없습니다.</p>
<%
		return;
	}
%>
<table border="1">
	<tr>
		<th>번호</th>
		<th>이름</th>
		<th>나이</th>
		<th>전화번호</th>
		<th>주소</th>
	</tr>

<%
	for (Person p : list) {
%>
	<tr>
		<td><%=p.getNum() %></td>
		<td><%=p.getName() %></td>
		<td><%=p.getAge() %></td>
		<td><%=p.getPhone() %></td>
		<td><%=p.getAddress() %></td>
	</tr>
<%
	}
%>
</table>
</body>
</html>
