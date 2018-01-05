<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>게시판 글쓰기</title>
<script type="text/javascript" src="../resources/js/BoardScript.js"></script>
<script>
	var msg = '${errMSG}';
	if (msg != '') {
		alert(msg);
	}
</script>
</head>
<body>
<h1>[글쓰기]</h1>
<form action="writeCustomerBoard" method = "post" onsubmit="boardCheck()">
	<table>
		<tr>
			<td>
				제목
			</td>
			<td>
				<input type="text" id="title" name="title" placeholder="제목을 입력하여 주세요" value="${title }">
			</td>
		</tr>
		<tr>
			<td>
				내용
			</td>
			<td>
				<textarea rows="20" cols="60" placeholder="내용을 입력하여 주세요" id="content" name="content">${content}</textarea>
			</td>
		</tr>
		<tr>
			<td>
				파일첨부
			</td>
			<td>
				<input type="file" value="파일선택">
			</td>
		</tr>
		<tr>
			<td colspan="2">
				<input type="submit" value="저장">
			</td>
		</tr>
	</table>
</form>
</body>
</html>