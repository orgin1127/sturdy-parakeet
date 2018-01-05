<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Web 5 게시판</title>
</head>
<body>
<h1> [ 게 시 판 ] </h1>
<c:if test="${sessionScope.CustomerID != null}">
<p><a href="writeCustomerBoard"><input type="button" value="글쓰기"></a></p>
</c:if>


</body>
</html>