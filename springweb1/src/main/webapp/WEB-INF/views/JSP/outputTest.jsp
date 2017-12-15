<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>outputTest 출력의 결과입니다.</h1>

<p>str : ${str}</p>
<p>str2 : ${str2} </p> 
<!-- Spring에서는 값이 없을 경우 null로 jsp에 출력되지 않는다. 
	출력값 없을 경우를 따로 편집 안해도 되서 편하지만 버그 발생시 어디에 null이 있는지 모를 수 있기 때문에
	controller 단계에서 logger로 값을 consol에 출력하여 확인하는 것이 중요하다.-->
<p>double : ${dou}</p>
<p>double Fomating1 : <fmt:formatNumber value="${dou}" pattern="#,###.##" /></p>
<p>double Fomating2 : <fmt:formatNumber value="${dou}" pattern="#,##0.00" /></p>
<p>double Fomating3 : <fmt:formatNumber value="${dou}" pattern="0.0 %" /></p>
<p>String[] : <c:forEach var="v" items="${array}">${v} </c:forEach></p>
<p>String을 담은 ArrayList : <c:forEach var="s" items="${list}">${s} </c:forEach></p>
<p>VO : 이름 : ${vo.name} 나이 : ${vo.age} 주소 : ${vo.address} 아이디 : ${vo.id}</p>
<p>객체를 담은 ArrayList : 
<c:forEach var="vo" items="${list2}">
이름 : ${vo.name} 나이 : ${vo.age} 주소 : ${vo.address} 아이디 : ${vo.id}<br>
</c:forEach>
</p>
int, double, String 배열, ArrayList<String>, VO객체 등
</body>
</html>