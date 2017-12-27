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
	Hello world!  
</h1>

<P>  The time on the server is ${serverTime}. </P>

<h1>[ web3 예제 - Mybatis 사용 ]</h1>

<p><a href="./join">회원가입 예제 (DB연동)</a><p>
<p><a href="./showPersonList">전체 회원 목록</a></p>

<p>이름 검색</p>
<form action="searchPerson" method="post">
검색할 이름 <input type="text" name="name">
			<input type="submit" value="검색">
</form>

<p>삭제</p>
<form action="deletePerson" method="post">
삭제할 이름 <input type="text" name="name">
			<input type="submit" value="삭제">
</form>

<c:if test="${searchList != null}">
	<p>
		<c:forEach var="p" items="${searchList}">
			${p}<br>
		</c:forEach>
	</p>
</c:if>
<c:if test="${personList != null}">
	<p>
		<c:forEach var="p" items="${personList}">
			${p}<br>
		</c:forEach>
	</p>
</c:if>

</body>
</html>
