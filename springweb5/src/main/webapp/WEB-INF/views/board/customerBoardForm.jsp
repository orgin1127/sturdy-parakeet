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
	
	function pagingFormSubmit(pnum) {
		var pagingForm = document.getElementById('pagingForm');
		var page = document.getElementById('page');
		page.value = pnum; // 폼에 요청할 페이지번호 저장
		pagingForm.submit(); //폼 전송
	}
</script>
<body>
<h1> [ 게 시 판 ] </h1>
<p>전체 글 개수 : ${pn.totalRecordsCount}</p>
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
				<c:if test="${boardList.savedFile != null && boardList.originalFile != null}">
					<img src="<c:url value="/resources/image/attachedFile.png" />  " height="20" width="20">
				</c:if>
				<c:if test="${boardList.replyCount != 0 }">
					<b><a href="viewBoardContent?boardnum=${boardList.boardnum}&replyTable=true">[${boardList.replyCount}]</a></b>
				</c:if>
			</td>
			<td>
				${boardList.custid}(${boardList.name })
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

<div id="navigator">
<!-- 페이지 이동 부분 -->                      
	<a href="javascript:pagingFormSubmit(${pn.currentPage - pn.pagePerGroup})">◁◁ </a> &nbsp;&nbsp;
	<a href="javascript:pagingFormSubmit(${pn.currentPage - 1})">◀</a> &nbsp;&nbsp;

	<c:forEach var="counter" begin="${pn.startPageGroup}" end="${pn.endPageGroup}"> 
		<c:if test="${counter == pn.currentPage}"><b></c:if>
			<a href="javascript:pagingFormSubmit(${counter})">${counter}</a>&nbsp;
		<c:if test="${counter == pn.currentPage}"></b></c:if>
	</c:forEach>
	&nbsp;&nbsp;
	<a href="javascript:pagingFormSubmit(${pn.currentPage + 1})">▶</a> &nbsp;&nbsp;
	<a href="javascript:pagingFormSubmit(${pn.currentPage + pn.pagePerGroup})">▷▷</a>
<!-- /페이지 이동 끝 -->                      

<form id="pagingForm" method="get" action="viewBoard">
	<input type="hidden" name="page" id="page">
	<select name="searchType">
		<option value="" <c:if test="${searchType == '' }"> selected="selected" </c:if>>==검색방법을 선택하여 주세요==</option>
		<option value="title" <c:if test="${searchType == 'title'}"> selected="selected" </c:if>>제목</option>
		<option value="custid" <c:if test="${searchType == 'custid'}"> selected="selected" </c:if>>글쓴이</option>
		<option value="content" <c:if test="${searchType == 'content'}"> selected="selected" </c:if>>내용</option>
		<option value="titleAndID" <c:if test="${searchType == 'titleAndId'}"> selected="selected" </c:if> >제목 & 글쓴이</option>
	</select>
	<input type="text" name="searchText" value="${searchText}">
	<input type="button" onclick="pagingFormSubmit(1)" value="검색">
</form>
</div>

</body>
</html>