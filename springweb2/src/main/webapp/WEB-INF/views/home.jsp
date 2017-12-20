<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
<head>
	<title>[ Spring test 2 Home ]</title>
</head>
<body>
<h1>
	Hello world!  
</h1>

<P>  The time on the server is ${serverTime}. </P>

<h2>Spring 예제 2번의 HOME 입니다.</h2>
<p><img src="<c:url value="/resources/image/kawai.GIF" />"></p>
<p><img src="<c:url value="/resources/image/raccoon.jpg" />"></p>
<a href="<c:url value="/res" />">Resource 사용</a>
<a href="<c:url value="/test/res2" />">Resource사용2</a><br>
<a href="<c:url value="/param?num=1" />">GET method로 parameter 전달</a><br>
<a href="<c:url value="/param2" />">POST method로 parameter 전달</a><br>
<p><a href="<c:url value="/test/ex1" />">연습 1</a></p>
<p><a href="<c:url value="/test/ex2" />">연습 2</a></p>
<p><a href="<c:url value="/test/ex3" />">연습 3</a></p>
</body>
</html>
