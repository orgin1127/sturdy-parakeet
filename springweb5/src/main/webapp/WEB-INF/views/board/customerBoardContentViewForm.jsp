<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>${boardContent.title}</title>
<script>
	function deleteCheck(boardnum) {
		if (confirm('정말로 삭제하시겠습니까?')) {
			location.href="deleteBoardContent?boardnum="+boardnum
		}
	}
</script>
</head>
<body>
<table>
	<tr>
		<td>
			글 번호
		</td>
		<td>
			${boardContent.boardnum }
		</td>
	</tr>
	<tr>
		<td>
			제목
		</td>
		<td>
			${boardContent.title}
		</td>
	</tr>
	<tr>
		<td>
			내용
		</td>
		<td>
			${boardContent.content}
		</td>
	</tr>
</table>
<c:if test="${boardContent.custid == sessionScope.CustomerID}">
<a href="editBoardContent?boardnum=${boardContent.boardnum}">수정</a>
<a href="javascript:deleteCheck(${boardContent.boardnum})">삭제</a>
</c:if>
<a href="viewBoard">목록으로</a>
</body>
</html>