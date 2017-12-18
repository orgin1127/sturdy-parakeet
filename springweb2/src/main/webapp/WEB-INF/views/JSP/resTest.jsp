<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
<head>
<title>[ Resources Test ]</title>
<link href="resources/CSS/test.css" rel="stylesheet" type="text/css">
<script type="text/javascript" src="resources/JS/test.js"></script>
</head>
<body>
<!-- 이미지 넣기 -->
<img src="resources/image/pepeSad.jpg">

<!-- 스타일 적용 -->
<p>색 변경 확인</p>

<!-- Java Script 실행 -->
<input type="button" onclick="test1()" value="실행">
<br>
<table class="testTable">
	<tr class="tableHead">
		<th class="tHead">테이블</th>
		<th class="tHead">만들기</th>
		<th class="tHead">실험</th>
	</tr>
	<tr class="tableContent">
		<td class="tContent">내용1</td>
		<td class="tContent">내용2</td>
		<td class="tContent">내용3</td>
	</tr>
	<tr class="tableFooter">
		<td colspan="3" class="tFooter">Table Footer</td>
	</tr>
</table>
</body>
</html>