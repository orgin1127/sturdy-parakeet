<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>[ EX 1 ]</title>
<script>

	function test() {
		var a = '${num}';
		alert(a);
	}

</script>
</head>
<body onload="test()">

<H1>EX 1의 연습 JSP입니다.</H1>

<%--  <img src="resources/image/img${num}.png">--%>
<c:choose>
	<c:when test="${num ==1 }">
		<img src="<c:url value="/resources/image/img1.png" />">
	</c:when>
	<c:when test="${num ==2 }">
		<img src="<c:url value="/resources/image/img2.png" />">
	</c:when>
	<c:when test="${num ==3 }">
		<img src="<c:url value="/resources/image/img3.png" />">
	</c:when>
	<c:when test="${num ==4 }">
		<img src="<c:url value="/resources/image/img4.png" />">
	</c:when>
	<c:when test="${num ==5 }">
		<img src="<c:url value="/resources/image/img5.png" />">
	</c:when>
	<c:otherwise>
		ㅇ
	</c:otherwise>
</c:choose>
</body>
</html>