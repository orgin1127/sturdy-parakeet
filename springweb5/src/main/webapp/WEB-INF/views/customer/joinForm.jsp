<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>[ 회원가입 ]</title>
<script type="text/javascript" src="../resources/js/joinScript.js"></script>
</head>
<body>
<h1>[ 회 원 가 입 ]</h1>
<form action="joinForm" method="post" onsubmit="return check()">
	<table>
		<tr>
			<td>
				ID : 
			</td>
			<td>
				<input type="text" id="userID" name="custid" placeholder="ID 중복확인을 클릭해 주세요" readonly="readonly">
				<input type="button" id="idValidCheck" onclick="idCheck()" value="ID 중복확인">
			</td>
		</tr>
		<tr rowspan="2">
			<td>
				비밀번호 : 
			</td>
			<td>
				<input type="password" id="password" name="password" placeholder="비밀번호 입력"><BR>
				<input type="password" id="passwordValid" placeholder="비밀번호 재입력">
			</td>
		</tr>
		<tr>
			<td>
				이름 : 
			</td>
			<td>
				<input type="text" id="name" name="name" placeholder="이름을 입력하여 주세요">
			</td>
		</tr>
		<tr>
			<td>
				이메일 : 
			</td>
			<td>
				<input type="hidden" id="email" name="email">
				<input type="text" id="emailHead">@
				<select name="emailFoot" id="emailFoot">
					<option value="blank" selected="selected">=주소를 선택하여 주세요=</option>
					<option>gmail.com</option>
					<option>naver.com</option>
					<option>daum.net</option>
					<option>scmaster.com</option>
				</select>
			</td>
		</tr>
		<tr>
			<td>
				고객구분 : 
			</td>
			<td>
				<input type="radio" id="division" name="division" value="personal">개인
				<input type="radio" id="division" name="division" value="company">기업
			</td>
		</tr>
		<tr>
			<td>
				식별번호 : 
			</td>
			<td>
				<input type="text" id="idno" name="idno" placeholder="주민번호 혹은 사업자 번호를 입력하세요">
			</td>
		</tr>
		<tr>
			<td>
				주소 : 
			</td>
			<td>
				<input type="text" id="address" name="address" placeholder="주소 입력">
			</td>
		</tr>
		<tr>
			<td colspan="2">
				<input type="submit" value="가입">
				<input type="reset" value="다시 쓰기">
			</td>
		</tr>
	</table>
</form>
</body>
</html>