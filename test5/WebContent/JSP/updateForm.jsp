<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script>

function checkValid() {
	var checkPWs = /[\w]{5,10}/;
	var checkName = /[\[\]{}()<>?|`~!@#$%^&*-_+=,.;:\"\\\'\\]/g;
	
	var pw = document.getElementById('password1');
	var pw2 = document.getElementById('password2');
	
	if (pw.value != '') {
		if (!(checkPWs.test(pw.value))) {
			alert('비밀번호는 영문 또는 숫자로 5~10자로 입력하여 주세요');
			pw.focus();
			pw.select();
			return false;
		}
		if ((pw2.value == '') || pw.value != pw2.value) {
			alert('비밀번호를 바르게 재 입력하여 주세요.');
			pw2.focus();
			pw2.select();
			return false;
		}
	}
	
	
	var name = document.getElementById('userName');
	if (checkName.test(name.value)) {
		alert('이름에 특수문자를 사용할수 없습니다.');
		name.focus();
		name.select();
		return false;
	}
	
	if (name.value == '') {
		alert('이름을 입력하여 주세요');
		name.focus();
		name.select();
		return false;
	}
}

</script>

<style>

	.updateForm {
		border: 1px solid black;
	}
	tr {
		border: 1px solid black;
	}
	td {
		border: 1px solid black;
	}
</style>

</head>
<body>
<c:if test="${member.id == null}">
	<script>
		alert('잘못된 접근입니다. 로그인 후 이용해 주세요');
		location.href="../";
	</script>
</c:if>
<form action="member" method="post" onsubmit="return checkValid()">
<input type="hidden" name="action" value="updateInfo">
	<table class="updateForm" id="updateForm">
		<tr>
			<td class="tableLeft" >
				아이디(id) : 
			</td>
			<td>
				<input type="text" id="userid"  name="userid" value="${member.id}" readonly="readonly"><br>
				(아이디는 수정불가입니다.)
				<br>
			</td>
		</tr>
		<tr>
			<td class="tableLeft">
				비밀번호(pw) :
			</td>
			<td>
				<input type="password" id="password1" name="password1"><br>
				<div class="regiInfo">* 비밀번호는 5글자 이상 10글자 이하입니다.</div>
			</td>
		</tr>
		<tr>
			<td class="tableLeft">
				비밀번호 확인 : 
			</td>
			<td>
				<input type="password" id="password2">
			</td>
		</tr>
		<tr>
			<td class="tableLeft">
				이름 :
			</td>
			<td>
				<input type="text" id="userName" name="userName" value="${member.name}">
			</td>
		</tr>
		<tr>
			<td class="tableLeft">
				전화번호 :
			</td>
			<td>
				<input type="text" id="userPhone" name="userPhone" value="${member.phone}">
			</td>
		</tr>
				<tr>
			<td class="tableLeft">
				주소 :
			</td>
			<td>
				<input type="text" id="userAddress" name="userAddress" value="${member.address}">
			</td>
		</tr>
		<tr>
			<td class="tdfoot" colspan="2"><div class="submitandreset"><input type="submit"><input type="reset"></div></td>
		</tr>
	</table>
</form>
</body>
</html>