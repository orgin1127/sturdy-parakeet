<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
<head>
	<title>Home</title>
</head>
<body>
<h1>
	Hello world! This is Spring Web 4 Practice Home
</h1>

<P>  The time on the server is ${serverTime}. </P>

<c:if test="${afterLogin == null }">
	<p><a href="regi"> [ REGISTRATION ] </a></p>
	<P><a href="login"> [ LOG - IN ] </a></P>
</c:if>
<c:if test="${afterLogin != null }">
	<p><a href="logout"> [ LOG - OUT ]</a></p>
</c:if>

<p><a href="./goBbs"> [ GO TO BBS ] </a>
</body>
</html>
