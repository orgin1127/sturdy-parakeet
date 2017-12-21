<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
<head>
	<title>[ Spring test 2 Home ]</title>
</head>
<body>
<h1>
	Hello world!  
</h1>

<P>  The time on the server is ${serverTime}. </P>
<c:if test="${sessionScope.id != null}">
	환영합니다. ${sessionScope.name}님(${sessionScope.id})
</c:if>
<p></p>
<h2>Spring 예제 2번의 HOME 입니다.</h2>
<p><img src="<c:url value="/resources/image/kawai.GIF" />"></p>
<p><img src="<c:url value="/resources/image/raccoon.jpg" />"></p>
<a href="<c:url value="/res" />">Resource 사용</a>
<a href="<c:url value="/test/res2" />">Resource사용2</a><br>
<a href="<c:url value="/param?num=1" />">GET method로 parameter 전달</a><br>
<a href="<c:url value="/param2" />">POST method로 parameter 전달</a><br>
<p><a href="<c:url value="/test/ex1" />">연습 1</a></p>
<p><a href="<c:url value="/test/ex2" />">연습 2</a></p>
<p><a href="<c:url value="/test/ex3" />">연습 3</a></p>

<h2>* 세션 사용</h2>
<p><a href="./session1">세션 사용 연습 (세션과 모델의 차이 알아보기)</a></p>
<p><a href="./session2">세션 사용 연습2 (세션과 모델의 차이 알아보기)</a></p>
<p><a href="./session3">세션 사용 연습3 (세션 정보 삭제)</a></p>

<h2>* 로그인 연습</h2>
<p><a href="./login">로그인</a></p>
<p><a href="./logout">로그아웃</a></p>

<h2>* 장바구니 연습</h2>
<p><a href="./goCart">장바구니에 상품 담기</a></p>
<p><a href="./cart">장바구니 보기</a></p>
</body>
</html>
