<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>[ L O G I N ]</title>
<script>
	function check() {
		
	}
</script>
</head>
<body>
<form action="login" method="post" onsubmit="return check()">
	<table>
		<tr>
			<td>
				ID : 
			</td>
			<td>
				<input type="text" id="userID" name="userID" placeholder="id를 입력하여 주세요">
			</td>
		</tr>
		<tr>
			<td>
				PASSWORD : 
			</td>
			<td>
				<input type="password" id="userPassword" name="userPassword" place="Password를 입력하여 주세요">
			</td>
		</tr>
		<tr>
			<td colspan="2">
				<input type="submit" value="LOG IN">
			</td>
		</tr>
	</table>
</form>
</body>
</html>