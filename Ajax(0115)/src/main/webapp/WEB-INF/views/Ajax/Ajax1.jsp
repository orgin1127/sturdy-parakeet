<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>JSON 1</title>
<script src="./resources/JS/jquery-3.2.1.min.js"></script>
<script>

	$(document).ready(function() {
		$('#bt1').on('click', call1);
		$('#bt2').on('click', call2);
		$('#bt3').on('click', call3);
	});
	
	function call1() {
		alert('call1() 실행');
		
		//ajax method 사용시작
		$.ajax({
			url: 'ajaxtest1' //같은 위치에서 부르기 때문에 컨트롤러의 어노테이션을 부른다, 위치 다르면 상대경로 써준다
			, type: 'GET' //POST 사용가능
			, dataType: 'text'
			, success: output1 //이 자리에서 직접 function 정의해서 써도 됨
			, error: function(e) {
				alert(JSON.stringify(e));
			}
		});
	}
	
	function call2() {
		alert('call2 실행');
		
		$.ajax({
			url: 'ajaxtest2'
			, type: 'POST'
			, data: {str: 'abcdefg'} // 서버로 보낼 값을 data라고 부른다. 
			, dataType: 'text' //success로 서버에서 값이 돌아올때 text 타입으로 받을지 JSON 타입으로 받을지 결정하는 부분
			, success: function(str) {
				alert('str=' + str);
			}
			, error: function(e) {
				alert(JSON.stringify(e));
			}
		})
	}
	
	function call3() {
		//사용자에게 숫자를 하나 입력받음
		var input = prompt('숫자를 입력하세요');
		//서버로 ajax 요청을 보내면서 그 숫자 전달
		$.ajax({
			url: 'ajaxtest3'
			, type: 'GET'
			, data: {'input': input}
			
			, dataType: 'text'
			, success: function(result) {
				alert('result : ' + result);
			}
			, error: function(e) {
				alert(JSON.stringify(e));
			}
		})
		//서버에서 1~그 숫자까지의 합계 계산해서 리턴
		//결과값을 대화상자를 띄워서 출력
	}
	
	function output1() {
		alert('output1()로 돌아옴');
	}
	
	
</script>
</head>
<body>
<H1> [ Ajax 연습 ]</H1>
<p><input type="button" id="bt1" value="서버로 요청보내기">
<p><input type="button" id="bt2" value="값 전달 리턴">
<p><input type="button" id="bt3" value="사용자 값 입력">
</body>
</html>