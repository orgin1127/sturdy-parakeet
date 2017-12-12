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

<script>

	function conetentCheck() {
		var title = document.getElementById('title');
		if (title.value.length > 15) {
			alert('제목이 너무 깁니다. ')
			return false;
		}
		if (title.value == '') {
			alert('제목을 입력하세요.')
			return false;
		}
		var obj = title.value;
		if (obj != '') {
			obj = obj.replace(/&/g, "&amp;");
		    obj = obj.replace(/</g, "&lt;");
		    obj = obj.replace(/>/g, "&gt;");
		    obj = obj.replace(/\"/g, "&quot;");
		    obj = obj.replace(/(\r\n|\n)/g, "<br />$1");
		    title.value = obj;
		}
	} 

</script>

</head>
<body>
<form method="post" action="board" onclick="return contentCheck()">
	<input type="hidden" name="action" value="edit">
	<input type="hidden" name="bnum" value="${vo.boardNum }">
	<table class="writeForm">
		<tr>
			<th>제목</th>
			<td><input type="text" name="titleContent" id="title" value="${vo.title}"></td>
		</tr>
		<tr>
			<th>내용</th>
			<td><textarea name="content" id="content">${vo.content}</textarea></td>
		</tr>
		<tr>
			<td colspan="2"><input type="submit"></td>
		</tr>
	</table>
</form>
</body>
</html>