<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>[ 글 쓰 기 ]</title>
<script>

	function check() {
		var writename = document.getElementById('name');
		if (writename.value == '' || writename.value.length > 9 || writename.value.length < 1) {
			alert('이름은 1글자 이상 9글자 이하여야 합니다.');
			writename.focus();
			writename.select();
			return false;
		}
		
		var writepassword = document.getElementById('password');
		if (writepassword.value == '' || writepassword.value.length > 12 || writepassword.value.length < 4) {
			alert('비밀번호는 4글자 이상 11자 이하여야 합니다.');
			writepassword.focus();
			writepassword.select();
			return false;
		}
		
		
		
		var obj = document.getElementById('content');
		if (obj.value == '' ) {
			alert('내용을 입력하여 주세요');
			obj.focus();
			obj.select();
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
	}

</script>
</head>
<body>
<h1>[ 방 명 록 글 쓰 기 ]</h1>
<form action="writeBBS" method="post">
	<table>
		<tr>
			<td>이름</td>
			<td><input type="text" name="name" id="name"></td>
		</tr>
		<tr>
			<td>비밀번호</td>
			<td><input type="password" name="password" id="password"></td>
		</tr>
		<tr>
			<td>내용</td>
			<td><textarea rows="20" cols="30" name="content" id="content"></textarea></td>
		</tr>
		<tr>
			<td colspan="2"><input type="submit" onclick="return check()">
		</tr>
	</table>
</form>
</body>
</html>