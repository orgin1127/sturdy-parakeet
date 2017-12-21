<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>[ Cart Page ]</title>
</head>
<body>
<form action="add" method="post">
	
	<select name="name">
		<option value="아메리카노">아메리카노</option>
		<option value="카페라떼">카페라떼</option>
		<option value="자바칩 프라푸치노">자바칩 프라푸치노</option>
		<option value="콜드브루">콜드브루</option>
		<option value="핸드드립">핸드드립</option>
	</select>
	<input type="text" name="cnt">
	
	<input type="submit" value="submit">
</form>
<br>
<c:forEach var="vo" items="${sessionScope.cartList}">
	${vo}<br>
</c:forEach>
<br>
<p><a href="<c:url value="/" />">메인으로 가기</a></p>
</body>
</html>