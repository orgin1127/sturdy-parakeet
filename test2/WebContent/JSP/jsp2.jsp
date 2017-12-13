<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>12월 1일</title>
<style>
body {
	background-image: url("../image/itsmondaybutimfree.gif");
	background-position: right top;
	background-repeat: no-repeat;
	margin-right: 200px;
}
</style>
</head>
<body>
<h1>[ FORM의 입력 데이터를 POST method로 전송 ]</h1>

<form method="post" action="../TestServlet">
문자열 	<input type="text" name="str"><br>
정수	<input type="text" name="num"><br>
라디오	<input type="radio" name="ra" value="SKT">SKT
		<input type="radio" name="ra" value="KT">KT
		<input type="radio" name="ra" value="LG">LG<br>
체크박스 <input type="checkbox" name="ch" value="선택1">선택1
		<input type="checkbox" name="ch" value="선택2">선택2
		<input type="checkbox" name="ch" value="선택3">선택3
		<input type="checkbox" name="ch" value="선택4">선택4
		<input type="checkbox" name="ch" value="선택5">선택5
		<br>
		<input type="submit" value="전송"><br>
		<br><br><br>
<a href="../image/cheers.gif">눌러보세요</a><br>

</form>

</body>
</html>