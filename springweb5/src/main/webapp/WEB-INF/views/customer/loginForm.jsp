<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
<head>
<title>L O G I N</title>
<link href="resources/css/joinForm.css" rel="stylesheet" type="text/css">
</head>
<body>
<h1> [ L O G - I N ] </h1>
<form action="login" method="post">
	<table>
		<tr>
			<td>
				ID : 
			</td>
			<td>
				<input type="text" id="custid" name="custid" placeholder="ID를 입력하여 주세요.">
				<c:if test="${loginResultID !=null}">
					<br><div id="loginResult">${loginResultID}</div>
				</c:if>
			</td>
		</tr>
		<tr>
			<td>
				PASSWORD : 
			</td>
			<td>
				<input type="password" id="password" name="password" placeholder="비밀번호를 입력하여 주세요.">
				<c:if test="${loginResultPW !=null}">
					<br><div id="loginResult">${loginResultPW}</div>
				</c:if>
			</td>
		</tr>
		<tr>
			<td colspan="2">
				<input type="submit" value="login">
			</td>
		</tr>
	</table>
</form>
</body>
</html>