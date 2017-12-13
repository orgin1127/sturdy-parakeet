<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<style>

	.viewT {
		border: 1px solid lightGrey;
	}
	tr {
		border: 1px solid lightGrey;
	}
	td { 
		border: 1px solid lightGrey;
	}
</style>

<script>

	function del() {
		if (confirm('삭제하시겠습니까?')) {
			location.href='board?action=delete&boardnum=${vo.boardNum}&id=${sessionScope.id }'
		}
	}
	
	function showEdit() {
		location.href='board?action=showEdit&boardnum=${vo.boardNum}'
	}

</script>

<title>글 읽기</title>
</head>
<body>
<div class="viewD"><table class="viewT">
	<tr>
		<td>글번호</td>
		<td>${vo.boardNum}</td>
		<td>id</td>
		<td>${vo.id }</td>
	</tr>
	<tr>
		<td>제목</td>
		<td>${vo.title }</td>
		<td>조회수</td>
		<td>${vo.hits }</td>
	</tr>
	<tr>
		<td colspan="4">
			<div class="content"><pre>${vo.content }</pre></div>
		</td>
	</tr>
</table></div>
<div class="editContent">

<!-- 해당 글을 쓴 사람만 이 버튼을 볼 수 있도록 -->
<c:if test="${sessionScope.id != null && sessionScope.id == vo.id }">
<input type="button" value="수정" onclick="javascript:showEdit()">
<input type="button" value="삭제" onclick="javascript:del()">
</c:if>
<input type="button" value="목록보기" onclick="location.href='board?action=list'">

</div>

</body>
</html>