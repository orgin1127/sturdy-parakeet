<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>[ 포메팅 라이브러리 ]</h1>
<p>${date}</p>
<p>${num1}</p>
<p>${num2}</p>
<p>${num3}</p>


<h2>날짜, 시간 포메팅</h2>
<p><fmt:formatDate value="${date}" type="date" /></p>
<p><fmt:formatDate value="${date}" type="time" /></p>
<p><fmt:formatDate value="${date}" type="date" pattern="yyyy년 MM월 dd일 E요일" /></p>
<p><fmt:formatDate value="${date}" type="time" pattern="hh시 mm분 ss초" /></p>
<p><fmt:formatDate value="${date}" type="date" pattern="d일 E요일" /></p>
<p><fmt:formatDate value="${date}" type="time" pattern="hh시 mm분 ss초" /></p>

<h2>숫자 포메팅</h2>
<p><fmt:formatNumber value="${num1}" pattern="#,###.#" /></p>
<p><fmt:formatNumber value="${num2}" pattern="#,##0.00" /></p>
<p><fmt:formatNumber value="${num3}" pattern="0.0 %" /></p>
</body>
</html>