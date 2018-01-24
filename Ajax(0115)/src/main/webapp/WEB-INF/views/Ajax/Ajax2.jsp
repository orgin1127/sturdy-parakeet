<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>[ Ajax 연습 2 ]</title>
<script src="./resources/JS/jquery-3.2.1.min.js"></script>

<script>
	$(document).ready(function() {
		$('#formButton1').on('click', check);
		$('#formButton2').on('click', check2);
		$('#formButton3').on('click', check3);
		$('#bt1').on('click', test1);
		$('#bt2').on('click', test2);
	});
	
	function check() {
		var name = $('#name').val();
		var age = $('#age').val();
		var phone = $('#phone').val();
		
		//입력 데이터 유효성 검사
		if (name=='' || age=='' || phone=='') {
			alert('필수 입력들을 입력하세요');
		}
		//서버로 전송
		$.ajax({
			url: 'insert1'
			, type: 'POST'
			, data: {name: name, age: age, phone: phone}
			, success: function() {
				alert('저장되었습니다.');
			}
			, error: function(e) {
				alert('저장 실패');
			}
		});
	
	}
	
	function check2() {
		var name = $('#name2').val();
		var age = $('#age2').val();
		var phone = $('#phone2').val();
		
		//입력 데이터 유효성 검사
		if (name=='' || age=='' || phone=='') {
			alert('필수 입력들을 입력하세요');
		}
		//서버로 전송
		$.ajax({
			url: 'insert2'
			, type: 'POST'
			, data: {name: name, age: age, phone: phone}
			, success: function() {
				alert('저장되었습니다.');
			}
			, error: function(e) {
				alert('저장 실패');
			}
		});
	}
	
	function check3() {
		$.ajax({
			url: 'insert3'
			, type: 'POST'
			//해당 아이디의 전체를 다 가져옴 이때 보내는 값 속성에 name이 있어야 하고 VO의 Field랑 이름이 일치해야 한다
			, data: $('#writeForm3').serialize()
			, success: function() {
				alert('저장되었습니다.');
			}
			, error: function(e) {
				alert('저장 실패');
			}
		});
	}
	
	//서버에서 VO String으로 받아오기
	function test1() {
		$.ajax({
			url:'output1'
			, type: 'GET'
			, dataType: 'text'
			, success: function(txt) {
				$('#outputDiv1').html(txt);
			}
			, error: function() {
				alert('저장실패');
			}
		});
	}
	//서버에서 VO JSON으로 받아오기
	function test2() {
		$.ajax({
			url:'output2'
			, type: 'GET'
			, dataType: 'json'
			, success: function(txt) {
				//$('#outputDiv2').html('이름 : ' + txt.name + ', 나이 : '+ txt.age + ', 전화번호 : '+ txt.phone);
				var output = '';
				output += '이름 : ' + txt.name + ', 나이 : '+ txt.age + ', 전화번호 : '+ txt.phone;
				$('#outputDiv2').html(output);
			}
			, error: function(e) {
				alert('저장실패');
			}
		});
	}
</script>

</head>
<body>
<p>1. 각각의 parameter를 서버로 전달</p>
<form id="writeForm">
	이름 : <input type="text" id="name"><br>
	나이 : <input type="text" id="age"><br>
	전화 : <input type="text" id="phone"><br>
	<input type="button" id="formButton1" value="저장">
</form>
<p>2. VO객체를 서버로 전달</p>
<form id="writeForm2">
	이름 : <input type="text" id="name2"><br>
	나이 : <input type="text" id="age2"><br>
	전화 : <input type="text" id="phone2"><br>
	<input type="button" id="formButton2" value="저장">
</form>
<!-- 폼 통째로 전달 -->
<p>3. VO객체를 서버로 전달 2</p>
<form id="writeForm3">
	이름 : <input type="text" name="name"><br>
	나이 : <input type="text" name="age"><br>
	전화 : <input type="text" name="phone"><br>
	<input type="button" id="formButton3" value="저장">
</form>
<!-- 서버에서 값 받기 -->
<p>4. 서버에서 VO객체를 String으로 받기</p>
<p><input type="button" id="bt1" value="문자열로 받기"></p>
<div id="outputDiv1"></div>

<p>5. 서버에서 VO객체를 JSON으로 받기</p>
<p><input type="button" id="bt2" value="문자열로 받기"></p>
<div id="outputDiv2"></div>

</body>
</html>