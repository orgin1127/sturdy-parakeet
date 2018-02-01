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
		var writename = document.getElementById('userID');
		if (writename.value == '' || writename.value.length > 9 || writename.value.length < 1) {
			alert('아이디를 올바르게 입력하여 주세요');
			writename.focus();
			writename.select();
			return false;
		}
		var writepassword = document.getElementById('userPassword');
		if (writepassword.value == '' || writepassword.value.length > 12 || writepassword.value.length < 4) {
			alert('비밀번호를 올바르게 입력하여 주세요');
			writepassword.focus();
			writepassword.select();
			return false;
		}
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
				<input type="password" id="userPassword" name="userPassword" placeholder="Password를 입력하여 주세요">
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