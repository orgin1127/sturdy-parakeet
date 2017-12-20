<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>[ EX 2 ]</title>
<script>
window.onload = start;
	function start() {
		alert('${str}');
		
		var s = document.getElementById('intext');
		intext.value='${str}';
		
		var output1 = document.getElementById('output');
		output1.innerHTML = '<p>' + '${str}' + '</p>';
		
	};
	
	
	
</script>
</head>
<body>

<H1>EX 2 페이지 입니다.</H1>
<p>int : ${inum}</p>
<p>double : ${dnum}</p>
<p>String : ${str}</p>
<p>Array[] : ${array}</p>
<p>
	Array[] : 
	<c:forEach var="str" items="${array}">
		${str}
	</c:forEach>
</p>
<p>map: ${map}</p>
<p>ArrayList : ${list}</p>
<p>ArrayList : 
	<c:forEach var="listStr" items="${list}">
		${listStr}
	</c:forEach>
</p>

<p><img src="<c:url value="/resources/image/img1.png" />"></p>

<form>
	<%-- 문자열 <input type="text" id="intext" value="${str}"><br>--%>
	문자열 <input type="text" id="intext"><br>
</form>

<div id="output"></div>

<form>
	<c:forEach var="str" items="${array}">
		<input type="text" value="${str}"><br>
	</c:forEach>
</form>


</body>
</html>