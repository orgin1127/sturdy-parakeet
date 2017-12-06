<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script>

function checkVaildForm() {
	var name = document.getElementById('id');
	if (name.value == '') {
		alert('아이디를 입력하여 주십시오');
		return false;
	}
	if (name.value.length > 9 || name.value.length <= 2) {
		alert('아이디는 3자 이상 9자 이하여야 합니다.');
		return false;
	}
	
	var pw = document.getElementById('password');
	if (pw.value == '') {
		alert('비밀번호를 입력하여 주십시오');
		return false;
	}
	if (pw.value.length > 12 || pw.value.length <= 3) {
		alert('비밀번호는 4자 이상 12자 이하여야 합니다.')
		return false;
	}
	return true;
	
}

</script>
<title> 회 원 등 록 </title>
</head>
<body>
<form method="post" action="" onsubmit="return checkVaildForm()">
	<table>
		<tr>
			<td>
				I  D
			</td>
			<td>
				<input type="text" placeholder="아이디를 입력하여 주세요" id="id" name="id"><br>
				<div class="registInfo">아이디는 3자 이상, 9자 이하여야 합니다.</div>
			</td>
		</tr>
		<tr>
			<td>
				비밀번호
			</td>
			<td>
				<input type="password" placeholder="비밀번호를 입력하여 주세요" id="password" name="password"><br>
				<div class="registInfo">비밀번호는 4자 이상, 12자 이하여야 합니다.</div>
			</td>
		</tr>
		<tr>
			<td colspan="2">
				<input type="submit" value="write">
			</td>
		</tr>
	</table>
</form>
</body>
</html>