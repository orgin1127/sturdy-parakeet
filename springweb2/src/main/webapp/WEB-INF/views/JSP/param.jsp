<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>[ Parameter 연습]</title>
<link href="resources/CSS/test.css" rel="stylesheet" type="text/css">
</head>
<body>
<form action="param2" method="post">
	<table class="testTable">
		<tr class="tableHead">
			<th class="tHead">테이블</th>
			<th class="tHead">만들기</th>
			<th class="tHead">실험</th>
		</tr>
		<tr class="tableContent">
			<td class="tContent">이름 : <input type="text" id="name" name="name"></td>
			<td class="tContent">나이 :  <input type="text" id="age" name="age"></td>
			<td class="tContent">주소 : <input type="text" id="address" name="address"></td>
		</tr>
		<tr class="tableFooter">
			<td colspan="3" class="tFooter">
				<input type="submit" value="전송">
			</td>
		</tr>
	</table>
</form>
</body>
</html>