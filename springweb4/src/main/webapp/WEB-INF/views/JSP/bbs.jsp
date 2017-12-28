<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>[ B B S ]</title>
<script>

	function goBBSForm() {
		location.href='goBBSForm';
	}
	
</script>

</head>
<body>
<p id="title"> [ B B S ] </p>
<input type="button" onclick="goBBSForm()" value="글쓰기">

<table>
	<c:forEach var="list" items="${list}">
		<tr>
			<td>
				작성자 : ${list.name}<br>
				작성일 : ${list.inputdate}<br>
				<pre>${list.content}</pre>
				<form action="deleteContent" method="post">
					비밀번호
					<input type="hidden" name="bbsnum" id="bbsnum" value="${list.bbsnum}">
					<input type="password" name="password" id="password">
					<input type="submit" value="삭제">
				</form>
			</td>
		</tr>
	</c:forEach>
</table>

</body>
</html>