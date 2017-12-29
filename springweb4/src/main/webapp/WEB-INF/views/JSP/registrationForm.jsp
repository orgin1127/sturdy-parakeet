<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Registration</title>

<script>
	function idVaildCheck() {
		window.open("idcheck", "ID 중복체크","top=200,left=300,width=450,height=250,resizable=no");
	}
	
	function check() {
		var checkPWs = /^[A-Za-z0-9]{5,10}/;
		var pw = document.getElementById('userPassword');
		if (!(checkPWs.test(pw.value))) {
			alert('비밀번호는 영문 또는 숫자로 5~10자로 입력하여 주세요');
			pw.focus();
			pw.select();
			return false;
		}
	}
</script>
</head>
<body>
<h1>[ 회 원 가 입 ]</h1>
<form action="regi" method="post" onsubmit="return check()">
	<table>
		<tr>
			<td>
				ID 
			</td>
			<td>
				<input type="text" name="userID" id="userID" readonly="readonly" placeholder="ID 중복확인을 눌러주세요">
			</td>
		</tr>
		<tr>
			<td colspan="2">
				<input type="button" value="ID 중복검사" onclick="idVaildCheck()">
			</td>
		</tr>
		<tr>
			<td>
				Password
			</td>
			<td>
				<input type="password" name="userPassword" id="userPassword">
			</td>
		</tr>
		<tr>
			<td colspan="2">
				<input type="submit" value="회원가입">
			</td>
		</tr>
	</table>
</form>
</body>
</html>