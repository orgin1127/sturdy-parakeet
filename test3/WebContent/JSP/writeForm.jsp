<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>[ 글쓰기 Phase ]</title>
<script>

function formCheck() {
	var name = document.getElementById('name');
	var obj = document.getElementById('content');
	if (name.value == '' && name.length>10) {
		alert('이름을 입력하세요.');
		return false;
	}
	var con = obj.value;

	if (con != '') {
		con = con.replace(/&/g, "&amp;");
	    con = con.replace(/</g, "&lt;");
	    con = con.replace(/>/g, "&gt;");
	    con = con.replace(/\"/g, "&quot;");
	    con = con.replace(/(\r\n|\n)/g, "<br />$1");
	    obj.value = con;
	}
	return true;
}

</script>

<style>
	div {
		margin: auto;
		width: 230px;
	}
	
	div content {
		margin: auto;
		width: 400px;
	}
	.submit {
		margin: auto;
		width: 150px;
	}
</style>

</head>
<body>
<br>
<br>
<br>
<form action="../Write" method="post"  onsubmit="return formCheck()">
	<div>이름 : <input type="text" name="name" id="name"></div><br>
	<div><textarea rows="20" cols="50" placeholder="글 내용을 입력하여 주세요" id="content" name="content"></textarea></div>
	<br>
	<div class="submit"><input type="submit" value="글쓰기 저장"></div>
</form>


</body>
</html>