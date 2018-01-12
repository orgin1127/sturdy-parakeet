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
	
	function pagingFormSubmit(pnum) {
		var pagingForm = document.getElementById('pagingForm');
		var replyPage = document.getElementById('replyPage');
		replyPage.value = pnum; // 폼에 요청할 페이지번호 저장
		pagingForm.submit(); //폼 전송
	}
	
	function editReply(reContent, bnum, rnum) {
		var reEditForm = document.getElementById('replyEditForm'+rnum);
		var reEditClass = document.getElementsByClassName('replyEditClass');
		
		var output = '';
		
		for (var i = 0; i < reEditClass.length; i++) {
			reEditClass[i].innerHTML=output;
		}
		
		output += '<form action="editReply" method="post">'
		output += '리플 수정 '
		output += '<input type="text" name="replyContent"';
		output += 'value="' + reContent + '">';
		output += '<input type="hidden" name="boardnum" ';
		output += 'value="' + bnum + '">';
		output += '<input type="hidden" name="replynum" ';
		output += 'value="' + rnum + '">';
		output += ' <input type="submit" value="확인"></form>';
		
		var resetF = '';
		
		reEditForm.innerHTML=output;
	}
	var t = ${replyTable};
	if (t) {
		alert('리플 눌러서 들어옴');
		window.onload = gotoReply();
	}
	
	function gotoReply() {
		alert('리플이 있는곳으로 곧바로 이동합니다.');
		location.href="#replyTable";
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
			글쓴이
		</td>
		<td>
			${boardContent.custid } (${boardContent.name})
		</td>
	</tr>
		<tr>
		<td>
			조회수
		</td>
		<td>
			${boardContent.hits}
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
			<pre><c:out value="${boardContent.content}" /></pre>
		</td>
	</tr>
</table>
<c:if test="${boardContent.originalFile != null}">
첨부파일 : 
<a href="downloadFile?boardnum=${boardContent.boardnum}&savedFile=${boardContent.savedFile}">
${boardContent.originalFile}</a><br>
</c:if>
<c:if test="${boardContent.originalFile == null}">
첨부파일 : 없음<br>
</c:if>
<c:if test="${boardContent.custid == sessionScope.CustomerID}">
<a href="editBoardContent?boardnum=${boardContent.boardnum}">수정</a>
<a href="javascript:deleteCheck(${boardContent.boardnum})">삭제</a>
</c:if>
<a href="viewBoard">목록으로</a><br>
<c:if test="${sessionScope.CustomerID != null && replyCount < 100}">
	<form action="replyWrite" method="post">
		<input type="hidden" name="boardnum" value="${boardContent.boardnum}">
		리플 쓰기 <input type="text" name="replyContent"> 
		<input type="submit" value="확인">
	</form>
</c:if>
<c:if test="${replyCount >= 100 }">
이 게시물은 댓글이 100개를 초과하여 더이상 댓글을 달 수 없습니다.
</c:if>
======================================================================================
<c:forEach var="re" items="${replyList}">
	<table id="replyTable">
		<tr>
			<td>${re.custid }</td>
			<td>
				<c:out value="${re.replyContent}" /><br>
			</td>
			<td><c:if test="${re.custid == sessionScope.CustomerID }">
				<a href="javascript:editReply('${re.replyContent}', ${boardContent.boardnum}, ${re.replynum})">수정</a>
			</c:if></td>
			<td><c:if test="${re.custid == sessionScope.CustomerID }">
				<a href="deleteReply?boardnum=${re.boardnum}&replynum=${re.replynum}">삭제</a>
			</c:if></td>
		</tr>
	</table>
	<div id="replyEditForm${re.replynum}" class="replyEditClass"></div>
</c:forEach>
<form id="pagingForm" method="get" action="viewBoardContent">
	<input type="hidden" name="replyPage" id="replyPage">
	<input type="hidden" name="boardnum" id="boardnum" value="${boardContent.boardnum}">
</form>
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
</div>    
</body>
</html>