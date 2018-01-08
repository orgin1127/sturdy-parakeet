<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Web 5 게시판</title>
<link href="../resources/css/boardForm.css" rel="stylesheet" type="text/css">
</head>
<script>
	function deleteCheck(boardnum) {
		if (confirm('정말로 삭제하시겠습니까?')) {
			alert(boardnum);
			location.href="deleteBoardContent?boardnum="+boardnum
		}
	}
</script>
<body>
<h1> [ 게 시 판 ] </h1>
<c:if test="${sessionScope.CustomerID != null}">
	<p><a href="writeCustomerBoard"><input type="button" value="글쓰기"></a></p>
</c:if>
<c:if test="${viewList != null }">
<table class="boardForm">
		<tr>
			<th>
				글번호	
			</th>
			<th>
				제목
			</th>
			<th>
				작성자
			</th>
			<th>
				작성일
			</th>
			<th>
				조회수
			</th>
		</tr>
	<c:forEach var="boardList" items="${viewList}">
		<tr>
			<td >
				${boardList.boardnum}
			</td>
			<td class="title">
				<a href="viewBoardContent?boardnum=${boardList.boardnum}">${boardList.title}</a>
			</td>
			<td>
				${boardList.custid}
			</td>
			<td>
				${boardList.inputdate}
			</td>
			<td>
				${boardList.hits}
			</td>
		</tr>
	</c:forEach>
</table>
</c:if>
</body>
</html>