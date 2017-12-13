<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Raccoon is always right</title>
<style>
	.headimg {
		margin: auto;
		width: 300px;
		padding-top: 50px;
	}
	body {
		background-color: #607D8B;
		
	}
	
	.regiInfo {
		font-size: 8px;
		color: salmon;
		width: 205px;
	}
	.joinForm {
		border: 3px dotted lightgrey;
		margin: auto;
		width: 360px;
		background-color: #ECEFF1;
		margin-top: 40px
	}
	
	#joinForm {
		border-radius: 40px;
	}
	
	.tableLeft {
		text-align: center;
		width: 120px;
	}
	
	.submitandreset {
		height: 30px;
		text-align: center;
		margin: auto;
		padding-top: 5px;	
	}
	.tdfoot {
		margin: auto;
	}
	
	td {
		padding-top: 10px;
		width: 200px;
	}
	
</style>

<script>
function checkValid() {
	var checkPWs = /^[A-Za-z0-9]{5,10}/;
	var checkName = /^[A-Za-z0-9가-힣]{1,6}/;
	
	var pw = document.getElementById('password1');
	if (!(checkPWs.test(pw.value))) {
		alert('비밀번호는 영문 또는 숫자로 5~10자로 입력하여 주세요');
		pw.focus();
		pw.select();
		return false;
	}

	var pw2 = document.getElementById('password2');
	if ((pw2.value == '') || pw.value != pw2.value) {
		alert('비밀번호를 바르게 재 입력하여 주세요.');
		pw2.focus();
		pw2.select();
		return false;
	}
	
	var name = document.getElementById('userName');
	if (!(checkName.test(name.value))) {
		alert('이름을 올바르게 입력하세요');
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

function IDcheck() {
	/*alert('dsada');
	var id = document.getElementById('userid');
	if ((id.value.length < 4 || id.value.length > 8) || id.value == '') {
		alert('ID는 3~8자로 입력하여 주세요');
		id.focus();
		id.select();
		return false;
	}
	
	location.href = ("member?action=idcheck&userid="+id.value);*/
	window.open("member?action=idCheck", "ID중복체크", "top=200,left=300,width=450,height=250,resizable=no");
}

</script>
</head>
<body>
<div class="headimg"><img src="./image/raccoon.png" width="300" height="300" ></div>
<form action="member" method="post" onsubmit="return checkValid()">
<input type="hidden" name="action" value="join">
	<table class="joinForm" id="joinForm">
		<tr>
			<td class="tableLeft" rowspan="2">
				아이디(id) : 
			</td>
			<td>
				<input type="text" placeholder="ID 중복확인을 눌러주세요" id="userid"  name="userid" readonly="readonly">
				<br>
				<div class="regiInfo">* 아이디는 4자 이상 8이하입니다.</div>
			</td>
		</tr>
		<tr>
			<td class="idCheckButton" colspan="2">
				<div class="idCheckButtonDiv"><input type="button" value="ID 중복검사" onclick="IDcheck()"></div>
			</td>
		</tr>
		<tr>
			<td class="tableLeft">
				비밀번호(pw) :
			</td>
			<td>
				<input type="password" placeholder="비밀번호를 입력하여 주세요" id="password1" name="password1"><br>
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
				<input type="text" id="userName" name="userName">
			</td>
		</tr>
		<tr>
			<td class="tableLeft">
				전화번호 :
			</td>
			<td>
				<input type="text" id="userPhone" name="userPhone">
			</td>
		</tr>
				<tr>
			<td class="tableLeft">
				주소 :
			</td>
			<td>
				<input type="text" id="userAddress" name="userAddress">
			</td>
		</tr>
		<tr>
			<td class="tdfoot" colspan="2"><div class="submitandreset"><input type="submit"><input type="reset"></div></td>
		</tr>
	</table>
</form>

</body>
</html>