<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="../resources/js/joinScript.js"></script>
</head>
<body>
<form action="idcheck" method="post">
	<table>
		<tr>
			<td>
				사용할 ID : 
			</td>
			<td>
				<input type="text" name="custid" id="userID" value="${afterSearch}"><br>
				* ID는 영문 혹은 숫자로 4자 이상 9자 이하여야 합니다.
			</td>
		</tr>
		<tr>
			<td colspan="2">
				<input type="submit" value="중복검사" onclick="return idValidCheck()">
			</td>
		</tr>
	</table>
</form>

<c:if test="${afterSearch != null }">
	<c:if test="${searchID != null }">
		<p>사용 불가한 ID 입니다.</p>
	</c:if>
	<c:if test="${searchID == null }">
		<p>사용 가능한 ID 입니다. ${afterSearch}</p>
		<p><input type="button" value="ID 사용하기" onclick="usethisID()"></p>
	</c:if>
</c:if>
</body>
</html>