<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
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
<p><img src="./resources/image/kawai.GIF"></p>
<p><img src="resources/image/raccoon.jpg"></p>
<a href="res">Resource 사용</a>
<a href="test/res2">Resource사용2</a>
<a href="param?num=1">GET method로 parameter 전달</a>
<a href="param2">POST method로 parameter 전달</a>
</body>
</html>
