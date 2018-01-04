<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>정보수정</title>
<script>
	function emailFusion() {
		var inputEmail = document.getElementById('emailHead');
		var selectEmail = document.getElementById('emailFoot')
		var obt = document.getElementById('email');
		obt.value = inputEmail.value + '@' + selectEmail.value;
	}
	
	
	var msg = '${errorMsg}';
	if (msg != '') {
		alert(msg);
	}
	
	window.onload = function emailInput() {		
		var emailcu = '${cu.email}'.split('@');
		var eHead = emailcu[0];
		var inputE = document.getElementById('emailHead');
		inputE.value = eHead;
	}
	
</script>
</head>
<body>
<h1>회원정보 수정</h1>
<form action="customerInfoEdit" method="post">
	<table>
		<tr>
			<td>
				ID : 
			</td>
			<td>
				<input type="text" id="userID" name="custid" readonly="readonly" value="${cu.custid}">
			</td>
		</tr>
		<tr>
			<td>
				비밀번호 : 
			</td>
			<td>
				<input type="password" id="password" name="password" placeholder="비밀번호 입력" value="${cu.password}"><BR>
				<input type="password" id="passwordValid" name="passwordValid" placeholder="비밀번호 재입력" value="${passwordValid}">
			</td>
		</tr>
		<tr>
			<td>
				이름 : 
			</td>
			<td>
				<input type="text" id="name" name="name" placeholder="이름을 입력하여 주세요" value="${cu.name}">
			</td>
		</tr>
		<tr>
			<td>
				이메일 : 
			</td>
			<td>
				<input type="hidden" id="email" name="email">
				<input type="text" id="emailHead">@
				<select name="emailFoot" id="emailFoot" onchange="emailFusion()">
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
				<c:if test="${cu.division == 'personal' }">
					<input type="radio" name="division" value="personal" checked="checked">개인
					<input type="radio" name="division" value="company">기업
				</c:if>
				<c:if test="${cu.division == 'company' }">
					<input type="radio" name="division" value="personal">개인
					<input type="radio" name="division" value="company" checked="checked">기업
				</c:if>
			</td>
		</tr>
		<tr>
			<td>
				식별번호 : 
			</td>
			<td>
				<c:if test="${cu.division == 'personal'}">
					<input type="text" id="idno" name="idno" value="${cu.idno}" readonly="readonly">
				</c:if>
				<c:if test="${cu.division == 'company'}">
				<input type="text" id="idno" name="idno" value="${cu.idno}">
				</c:if>
			</td>
		</tr>
		<tr>
			<td>
				주소 : 
			</td>
			<td>
				<input type="text" id="address" name="address" placeholder="주소 입력" value="${cu.address}">
			</td>
		</tr>
		<tr>
			<td colspan="2">
				<input type="submit" value="정보수정">
				<input type="reset" value="다시 쓰기">
			</td>
		</tr>
	</table>
</form>
</body>
</html>