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
	function check() {
		var rex = /[^0-9]/g;
		var num11 = document.getElementById('num1');
		var num22 = document.getElementById('num2');
		
		if (rex.test(num11) || rex.test(num22)) {
			alert('숫자만 입력하세요 좀');
			return false;
		}
		
	}
	
	function formsubmit() {
		
		document.getElementById('calcForm2').submit();
	}
</script>
</head>
<body>
<h1>Calc Test</h1>
<!-- select 값 변경시 서버 폼 전송 
<select name="op" onchange="formsubmit()">
	<option value="">계산 타입을 골라주세요</option>
	<option value="+">+</option>
	<option value="+">+</option>
	<option value="+">+</option>
	<option value="+">+</option>
</select>
-->
<h1>계산기 1번</h1><br>
<form action="calc" method="post" onsubmit="return check()" id = "calcForm">
	<table>
		<tr>
			<td><input type="text" name="num1" id="num1" value="${num1}"></td>
			<td>
				<select name="cal">
					<option value="+">+</option>
					<option value="-">-</option>
					<option value="*">*</option>
					<option value="/">/</option>
				</select>
			</td>
			<td><input type="text" name="num2" id="num2" value="${num2}"></td>
			<td><input type="submit" value="계산"></td>
		</tr>
	</table>
</form>
결과 : <input type="text" value="${total}">
<br><br>
<h1>계산기 2번</h1><br>
<form action="calc2" method="post" id = "calcForm2">
	<table>
		<tr>
			<td><input type="text" name="calnum" id="calnum" value="${num1}">cm</td>
			<td>
				<select name="cal2" onchange="formsubmit()">
					<option value="blank" selected="selected">선택해 주세요</option>
					<option value="mm">밀리미터(mm)</option>
					<option value="m">미터(m)</option>
					<option value="km">킬로미터(km)</option>
					<option value="in">인치(inch)</option>
					<option value="ft">피트(ft)</option>
					<option value="yd">야드(yd)</option>
					<option value="za">자(尺)</option>
					<option value="gan">간(間)</option>
					<option value="jeong">정(町)</option>
					<option value="li">리(里)</option>
				</select>
			</td>
			<td>결과 : <input type="text" value="${result}"></td>
		</tr>
	</table>
</form>
</body>
</html>