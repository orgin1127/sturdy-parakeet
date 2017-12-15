<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<html>
<head>
	<title>Home</title>
	
<script>

	function check() {
		var check = /^[\w]/g;
		
	}

</script>
</head>
<body>
<h1>
	Hello world!  
</h1>
<p> 여기는 Spring web project study 1의 메인입니다.</p>
<P>  The time on the server is ${serverTime}. </P>
<h1> 어서오시오 여행자여 </h1>

<p><a href="output">Model을 이용한 출력</a></p>
<p><a href="input">사용자 입력 테이터 받기</a></p>
<p><a href="calc">실습</a></p>

<form method="post" action="">
	<table>
		<tr>
			<td>닉네임 : </td>
			<td><input type="text" id="username" name="username"></td>
		</tr>
		<tr>
			<td>글 내용 : </td>
			<td><textarea rows="25" cols="40"></textarea></td>
		</tr>
		<tr>
		<td colspan="2"><input type="submit" onclick="return check()"></td>
		</tr>
	</table>
</form>
</body>
</html>
