<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="shortcut icon" href="/favicon.ico">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>MY BBS</title>

<style>

</style>
</head>
<body>

<c:if test="${sessionScope.id != null }"><script> alert('로그인 성공')</script></c:if>

<!--
	로그인 중일 경우  
	<p>이름 (id)님 로그인 중</p>
-->
<c:if test="${sessionScope.id != null }"><div class="logInfo">
${sessionScope.userName } 님 (${sessionScope.id}) 로그인 중
</div></c:if>
<ul>
	<!-- 로그인 안한 상태에만 보여야 할 메뉴-->
	<c:if test="${sessionScope.id == null }">
		<li><a href="member?action=viewJoinForm">회원가입</a></li>
		<li><a href="member?action=viewLoginForm">로그인</a></li>
	</c:if>	 
	 <!-- 로그인 한 상태에서만 보여야 할 메뉴 -->
	 <c:if test="${sessionScope.id != null}">
		<li><a href="member?action=logout">로그아웃</a></li>
		<li><a href="member?action=viewUpdateForm">개인정보 수정</a></li>
	</c:if>
	 <!-- 로그인 여부 상관없이 항상 보일 메뉴 -->
	<li><a href="board?action=list">게시판</a></li>
</ul>
</body>
</html>