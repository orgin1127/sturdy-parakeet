<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@page import="java.util.ArrayList"%>
<%@page import="test.jsp6.vo.BoardVO"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>[ 게시판 ]</h1>
<!-- 게시판 글 목록 출력 부분 -->
<div class="bbsForm"><table border="1" class="bbs">
	<thead>
		<tr>
			<th>
				글 번호
			</th>
			<th>
				글쓴이
			</th>
			<th class="contentTitle">
				글 제목
			</th>
			<th>
				글 쓴 날짜
			</th>
		</tr>
	</thead>
	<tbody>
		<c:forEach var="v" items="${requestScope.list}">
			<tr>
				<td>
					${v.boardNum}
				</td>
				<td>
					${v.id}
				</td>
				<td>
					<a href="board?action=read&boardnum=${v.boardNum}"><c:out value="${v.title}"/></a>
				</td>
				<td>
					${v.inputdate}
				</td>
				<td>
					${v.hits}
				</td>
			</tr>
		</c:forEach>
	</tbody>
</table></div>
<!-- 글쓰기 버튼 -->
<div class="tfooter">
<p>
<c:if test="${(requestScope.pnum - 1)==0}">

</c:if>
<c:if test="${(requestScope.pnum - 1)!=0}">
<a href="board?action=list&page=${requestScope.pnum - 1}">이전</a>
</c:if>
<a href="board?action=list&page=${requestScope.pnum + 1}">다음</a>
<input type="button" onclick="location.href='board?action=writeForm'" value="글쓰기">
</div>

<!-- 페이지 이동 및 검색 폼 -->
</body>
</html>