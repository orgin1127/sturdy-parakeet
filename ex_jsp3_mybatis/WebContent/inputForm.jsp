<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>inputForm.jsp</title>
<script>
//입력 폼의 유효성 검사
function formCheck() {
	var name = document.getElementById('name');
	if (name.value == '') {
		alert('이름을 입력하세요.');
		return false;
	}
	return true;
}
</script>
</head>
<body>
<h1>[ Form 데이터 입력 ]</h1>

<form method="post" action="input" onsubmit="return formCheck()">
이름 : <input type="text" name="name" id="name"><br>
나이 : <input type="text" name="age" id="age"><br>
전화 : <input type="text" name="phone" id="phone"><br>
주소 : <input type="text" name="address" id="address"><br>
	 <input type="submit" value="저장"><br>
</form>

</body>
</html>
