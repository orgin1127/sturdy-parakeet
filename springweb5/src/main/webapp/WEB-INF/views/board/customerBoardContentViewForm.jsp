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
	
	function editReply(reContent, bnum, rnum) {
		var output = '';
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
		var reEditForm = document.getElementById('replyEditForm'+rnum);
		
		reEditForm.innerHTML=output;
		
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
<a href="viewBoard">목록으로</a>
<c:if test="${sessionScope.CustomerID != null }">
	<form action="replyWrite" method="post">
		<input type="hidden" name="boardnum" value="${boardContent.boardnum}">
		리플 쓰기 <input type="text" name="replyContent"> 
		<input type="submit" value="확인">
	</form>
</c:if>
======================================================================================
<c:forEach var="re" items="${replyList}">
	<table>
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
	<div id="replyEditForm${re.replynum}"></div>
</c:forEach>
</body>
</html>