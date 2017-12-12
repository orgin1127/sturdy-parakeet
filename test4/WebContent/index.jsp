<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<style>
	.login {
		text-align: right;
	}
</style>
<title>JSP 5</title>
</head>
<body>

<h1>[ JSTL / EL 연습]</h1>

<c:choose>
	<c:when test="${id != null}">
		<p class="login">${id}님 환영합니다.</p>
	</c:when>
	<c:when test="${id == null}">
		<p class="login">로그인 해주세요.</p>
	</c:when>
</c:choose>

<h2>EL / JSTL 예제</h2>
<p><a href="eltest?param1=parameter1&param2=22">EL TEST</a></p>
<p><a href="jstltest1">JSTL 연습 1 - 코어 라이브러리</a></p>
<p><a href="jstltest2">JSTL 연습 2 - 포매팅 라이브러리</a></p>
<p><a href="jstltest3">JSTL 연습 3 - 함수 라이브러리</a></p>
<br>
<h2>Session 예제</h2>
<p><a href="sessionSet">세션에 값 저장</a></p>
<p><a href="sessionRemove">세션의 값 지우기</a></p>
</body>
</html>