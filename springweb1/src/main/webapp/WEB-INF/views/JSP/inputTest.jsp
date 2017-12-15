<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>input JSP</h1>

<form action="save" method="post">
	<table>
		<tr>
			<td>이름 : </td> 
			<td><input type="text" name="name" id="name" placeholder="이름을 입력하여 주세요"></td>
		</tr>
		<tr>
			<td>전화번호 : </td>
			<td><input type="text" name="phone" id="phone" placeholder="전화번호를 입력하여 주세요"></td>
		</tr>
		<tr>
			<td>주소 : </td>
			<td><input type="text" name="address" id="address" placeholder="주소를 입력하여 주세요"></td>
		</tr>
		<tr>
			<td colspan="2"><input type="submit" value="전송"></td>
		</tr>
	</table>
</form>
</body>
</html>