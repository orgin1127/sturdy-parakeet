<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!-- 페이지 지시자  -->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<!-- body 바로 밑에 자바스크립트를 쓰면 페이지가 열리자마자 JS가 써진다 -->
<script>
alert('<body> 바로 밑의 자바스크립트 자동실행');
</script>
<h1>JSTL 1번 TEST</h1>
<p>문자 : ${requestScope.str}</p>
<p>숫자 : ${requestScope.num}</p>
<p>배열 : ${requestScope.array}</p>
<p>객체 : ${requestScope.person}</p>
<p>리스트 : ${requestScope.list}</p>

<!-- JSTL If문 사용 예 -->
<c:if test="${requestScope.num >= 0}">
	${num} 은 0 보다 크다.
</c:if>
<c:if test="${requestScope.num < 0}">
	${num} 은 0 보다 작다.
</c:if>

<!-- 현재 페이지에서만 유효한 변수 값 설정법 -->
<p>num : ${num}</p> <!-- 여기에서는 서버에서 받아온 값 그대로 1 출력 -->
<%-- <c:set var="num" value="2" /> <!-- 이름이 같은 변수 num을 선언하고 2로 초기화함-->--%>
<p>num : ${requestScope.num}</p> <!-- 이럴때에는 영역을 정확히 지정해준다. 출력은 그대로 1 --> 
<!-- el은 가장 좁은 범위인 page부터 거슬러 올라간다는 것을 생각-->
<p>num : ${pageScope.num }</p><!-- 출력값은 위에서 선언&초기화 한 대로 2 -->

<!-- 변수 삭제하기 -->
<!-- 이 경우 pageScope에 num이 걸려서 그걸 삭제한다. requestScope는 아직 잘 살아있음 -->
<%-- <c:remove var="pageScope.num"/>--%>

<!-- choose를 이용한분기처리 -->
<c:choose>
	<c:when test="${requestScope.num == 0 }">
		<!--<script>locatin.href = 'http://naver.com/';</script>
		  <p><a href="http://naver.com/">네이버로 이동</a></p> -->
	</c:when>
	<c:when test="${requestScope.num == 1 }">
		<!--<script>location.href = 'https://google.com/';</script>
		  <p><a href="https://google.com/">구글로 이동</a></p> -->
	</c:when>
	<c:when test="${requestScope.num == 2 }">
		<!--<script>location.href = 'http://nate.com/';</script>
		  <p><a href="http://nate.com/">네이트로 이동</a></p> -->
	</c:when>
	<c:otherwise>
		<p>갈곳이 없네</p>
	</c:otherwise>
</c:choose>

<!-- 반복문 -->
<h2> 반복문 </h2>
<!-- 배열의 처음부터 끝까지 출력할때 -->
<!-- 
items="출력할 배열명"
var="배열을 꺼내기 위한 변수명"
 -->
<p>
<c:forEach var="s" items="${requestScope.array}">
	${s}
</c:forEach>
</p>
<!-- 원하는 위치만 배열출력 -->
<p>
	<c:forEach var="s" items="${requestScope.array}" begin="3" end="3">
		${s}
	</c:forEach>
</p>
<!-- 짝수인덱스만 출력 -->
<p>
	<c:forEach var="s" items="${requestScope.array}" step="2">
		${s}
	</c:forEach>
</p>
<!--  -->
<p>
	<c:forEach var="s" begin="0" end="2" step="1" >
		<p>${s} : ${array[s]}</p>
	</c:forEach>
</p>
<!-- 객체 전체 출력 -->
<p>
	<c:forEach var="p" items="${list}">
		<p>번호:${p.num} 이름:${p.name} 전화:${p.phone}</p>
	</c:forEach>
</p>
<h2>el과 out 태그의 차이</h2>
<p>${requestScope.data}</p>
<p><c:out value="${data}" /></p>
</body>
</html>