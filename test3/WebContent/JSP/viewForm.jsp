<%@page import="java.util.ArrayList"%>
<%@page import="test.jsp4.vo.BbsVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>방명록 글 읽기</title>
<style>
	thead {
		padding: 30px;
		text-align: center;
		background-color: #444444;
		color: white; 
		width: 20px;
	}
	thead tr {
		height: 60px;
		width: 30px;
	}
	tbody {
		border: 1px solid grey;
		text-align: center;
		padding: 3px;
		background-color: #b3b2ef;
	}
	.bbsTitle {
		width: 300px;
		text-align: center;
		margin: auto;
	}
	.bbs {
		border-collapse: collapse;
		border: 3px solid lightgrey;
	}
	.bbsForm {
		width: 1050px;
		margin: auto;
	}
	.content {
		width: 700px;
		white-space: pre-line;
		word-break: break-all;
	}
	tbody tr:hover {
		background-color: #ffb871;
	}
}
</style>

<script>
function del(num) {
	var number = num;
	if (confirm('삭제하시겠습니까?')) {
		location.href = 'delete?deleteNum='+number;
	}
}

</script>

</head>
<body>
<div class="bbsTitle"><h1><b>[ 방명록 글 목록 ]</b></h1></div><br>

<% ArrayList<BbsVO> list = (ArrayList<BbsVO>) request.getAttribute("list"); %>
<% if(list == null) { %>
	<p>방명록에 등록된 글이 없습니다.</p>
<% return;
	} %>

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
				글 내용
			</th>
			<th>
				글 쓴 날짜
			</th>
			<th>
				삭제하기
			</th>
		</tr>
	</thead>
	<tbody>
		<% for (BbsVO vo : list) { %>
		<tr>
			<td>
				<%=vo.getNum() %>
			</td>
			<td>
				<%=vo.getName() %>
			</td>
			<td>
				<pre class="content" id="contents"><%=vo.getContent() %></pre>
			</td>
			<td>
				<%=vo.getIndate() %>
			</td>
			<td><a href="javascript:del(<%=vo.getNum() %>)">삭제</a></td>
		</tr>
		<% } %>
	</tbody>
</table></div>
</body>
</html>