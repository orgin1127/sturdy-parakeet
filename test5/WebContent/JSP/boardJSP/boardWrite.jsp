<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>

<script>

	function conetentCheck() {
		
	} 

</script>

<style>
	.writeForm {
		border: 1px solid white;
		background-color: ligthgrey;
	}
</style>
</head>
<body>
<h1>[ 게시판 글 쓰기 ]</h1>

<form method="post" action="board" onclick="return contentCheck()">
	<input type="hidden" name="action" value="write">
	<table class="writeForm">
		<tr>
			<th>제목</th>
			<td><input type="text" name="title" id="title"></td>
		</tr>
		<tr>
			<th>내용</th>
			<td><textarea name="content" id="content"></textarea></td>
		</tr>
		<tr>
			<td colspan="2"><input type="submit"></td>
		</tr>
	</table>
</form>
</body>
</html>