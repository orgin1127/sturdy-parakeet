<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>EL Result</title>
</head>
<body>

<h1>[ EL 연습 ]</h1>

<p>STR : ${str}</p>
<p>STR : ${requestScope.str}</p>
<p>NUM : ${num}</p>
<p>NUM : ${requestScope.num}</p>
<p>PERSON : ${p}</p>
<p>PERSON : ${requestScope.p}</p>
<p>PERSON NUM : ${p.num}</p>
<p>PERSON NUM : ${requestScope.num}</p>
<p>PERSON NAME : ${p.name}</p>
<p>PERSON NAME : ${requestScope.p.name}</p>
<p>PERSON AGE : ${p.age}</p>
<p>PERSON AGE : ${requestScope.p.age}</p>
<p>PERSON PHONE : ${p.phone}</p>
<p>PERSON PHONE : ${requestScope.p.phone}</p>
<p>PERSON ADDRESS : ${p.address}</p>
<p>PERSON ADDRESS : ${requestScope.p.address}</p>

<!-- el을 사용해 넘겨받은 request 객체에 담겨있는 자료 호출 ${requestScope.str} 도 똑같음
단지 앞의 내장 객체 명을 생략하면 pageScope부터 applicationScope까지 전체 검색하는것-->

<p>PARAM : ${param.param1}</p>
<p>PARAM : ${param.param2}</p>
<p>PARAM : ${param}</p>
<!-- request forwarding으로 전달된 parameter 읽기 -->

<p><h2> 연산자 </h2></p>
<p>EL 산술연산자 * : ${requestScope.num * 2}</p>
<p>EL 산술연산자 + : ${requestScope.num + 100}</p>
<p>EL 산술연산자 - : ${requestScope.num - 100}</p>
<p>EL 산술연산자 / : ${requestScope.num / 2 }</p>
<p>EL 산술연산자 % : ${requestScope.num % 2 }</p>
<p>========================================</p>
<p>EL 비교연산자 == EQ : ${requestScope.num == 123 }</p>
<p>EL 비교연산자 == EQ : ${requestScope.num == 200 }</p>
<p>EL 비교연산자 != NE : ${requestScope.num != 123 }</p>
<p>EL 비교연산자 != NE : ${requestScope.num != 200 }</p>
<p>EL 비교연산자 < IT  : ${requestScope.num > 124 }</p>
<p>EL 비교연산자 > GT  : ${requestScope.num > 122 }</p>
<p>=========================================</p>
<p>EL 논리연산자 && AND : ${requestScope.num >= 123 && requestScope.num <= 120 }</p>
<p>EL 논리연산자 || OR : ${requestScope.num >= 123 || requestScope.num <= 120 }</p>
<p>=========================================</p>
<p>EL 기본 연산자 X? A:B : ${requestScope.num - 123 == 0 ? 0 : 1 }</p>
<!-- 연산자  -->


</body>
</html>