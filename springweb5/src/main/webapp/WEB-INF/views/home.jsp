<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
<head>
	<title>Home</title>
<script>
	function check() {
		
	}
</script>
</head>
<body>
<h1>
	Hello world!  This is Spring Web Practice 5 Home
</h1>

<P>  The time on the server is ${serverTime}. </P>
<c:if test="${sessionScope.CustomerID !=null}">
	<p>	환영합니다 ${sessionScope.CustomerID}님</p>
</c:if>
<c:if test="${sessionScope.CustomerID !=null && sessionScope.CustomerID == 'aaa'}">
<script>
	alert('안녕하세요 선생님');
</script>
</c:if>
<ul>
	<c:if test="${sessionScope.CustomerID == null }">
		<li><a href="cust/joinForm">회원가입</a></li>
		<li><a href="login">로그인</a></li>
	</c:if>
	<c:if test="${sessionScope.CustomerID != null}">
		<li><a href="logout">로그아웃</a></li>
		<li><a href="customerInfoEdit">개인정보 수정</a></li>
	</c:if>
	<li><a href="board/viewBoard">게시판</a></li>
</ul>
</body>
</html>
