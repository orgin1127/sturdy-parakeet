<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>jstl3.jsp</title>
</head>
<body>
<h1>[ 함수 라이브러리 ]</h1>
<p>원본 : ${str}</p>
<p>대문자로 : ${fn:toUpperCase(str) }</p>
<p>소문자로 :${fn:toLowerCase(str) }</p>
<p>부분 문자열 : ${fn:substring(str, 2, 5)}</p>
<p>길이 : ${fn:length(str) }</p>
<p>문자열 나누기 : <br>
	<c:forEach var="s" items="${fn:split(str, ' ')}">
		${s}<br>
	</c:forEach></p>
</body>
</html>