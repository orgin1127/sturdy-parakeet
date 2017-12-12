<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title> L O G I N </title>

<script>

function checkLogin() {
	var id = document.getElementById('loginid');
	var pw = document.getElementById('password1');
	var checkIDs = /^[A-Za-z0-9]{4,8}/;
	var checkPWs = /^[A-Za-z0-9]{5,10}/;

	
	if (!(checkIDs.test(id.value))) {
		alert('아이디는 영문 혹은 숫자로 4자리 이상 8자리 이하여야 합니다.');
		id.focus();
		id.select();
		return false;
	}
	
	
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
<c:if test="${param.logResult == 0 }"><script> alert('아이디 혹은 비밀번호가 틀립니다.')</script></c:if>
<p><h2> [ L O G - I N ] </h2></p>

<form action="member" method="post" onsubmit="return checkLogin()">
	<input type="hidden" name="action" value="login">
	<input type="hidden" name="logResult" value="0">
	<table border="1">
		<tr>
			<td>
				아이디(ID) : 
			</td>
			<td>
				<input type="text" name="loginID" id="loginid"><br>
				* 아이디는 대소문자를 구분하며 영문 또는 숫자로 4자 이상 8이하입니다.
			</td>
		</tr>
		<tr>
			<td>
				비밀번호(PW) :
			</td>
			<td>
				<input type="password" placeholder="비밀번호를 입력하여 주세요" id="password1" name="password1"><br>
				* 비밀번호는 대소문자를 구분하며 영문 또는 숫자로 5글자 이상 10글자 이하입니다.
			</td>
		</tr>
		<tr>
			<td colspan="2">
				<div><input type="submit" value="로그인"></div>
			</td>
		</tr>		
	</table>
</form>

</body>
</html>