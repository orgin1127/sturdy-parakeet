<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
<head>
	<title>[JS, jQuery, Ajax 연습]</title>
</head>
<body>
<h1>
	Hello world!  
</h1>

<P>  The time on the server is ${serverTime}. </P>

<ol>
	<li>Java Script</li>
		<ul>
			<li><a href="js1">기본 문법</a></li>
			<li><a href="js2">함수 정의</a></li>
			<li><a href="js3">객체, 배열 반복문</a></li>
			<li><a href="js4">브라우저 객체 모델</a></li>
			<li>문서 객체 모델</li>
			<li>이벤트 처리</li>
		</ul>
	<li>jQuery</li>
		<ul>
			<li><a href="jQuery1">jQuery1 (기본 문법)</a></li>
			<li><a href="jQuery2">jQuery2 (객체, 배열 반복문)</a></li>
			<li><a href="jQuery3">jQuery3 (이벤트 처리)</a></li>
		</ul>
	<li>Ajax</li>
		<ul>
			<li><a href="Ajax1">Ajax1</a></li>
			<li><a href="Ajax2">Ajax2</a></li>
			<li><a href="reply">Ajax3 - Reply</a></li>
		</ul>
</ol>
</body>
</html>
