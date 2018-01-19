<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="./resources/CSS/jQueryCSS.css" rel="stylesheet" type="text/css">
<script src="./resources/JS/jquery-3.2.1.min.js"></script>
<script>

/* 	$(document).ready(start);
	function start() {
		alert('작동확인');
	} */
	
	function test1() {
		var arr = [10, 50, 100, 200, 300];
		
		//$.each함수를 사용할때는 처음엔 배열(객체), 두번째는 그 배열(객체)를 받아 사용할 함수를 넣는다
		//함수에는 두가지를 정의해줘야 하는데 처음 값은 배열이나 객체의 key, 두번째 값은 그 key에 달려있는 값을 받을 변수
		
		$.each(arr, function (name, link) {
			alert('name : ' + name + ', link : ' + link);
		});
		
		var array = [
						{ name: 'Hanbit Media', link : 'http://hanbit.co.kr'}
						, { name : 'Naver', link : 'http://naver.com'}
						, { name : 'Daum', link : 'http://daum.net'}
					];
		var linkDiv = document.getElementById('linkDiv');
		
		var output = ''
		
		$.each(array, function (key, value) {
			alert('key : ' + key + ', value : ' + value.name + ' ' + value.link);
			output += '<p><a href="' + value.link + '">';
			output += value.name+'</a></p>';
		})
		//innerHTML 대신 jQuery의 html 함수를 사용하여 div 값을 채워넣는다
		//html()으로 사용하면 값 읽기, html(변수)로 사용하면 값 수정하기 (text()나 val()도 마찬가지)
		
		$('#linkDiv').html(output);
	}
	
	function test2() {
		var s = $('h1').html();
		var a = $('h1').text();
		var c = $('h1').val();
		
		alert('html()=' + s + ', text()=' + a + ', val()=' + c);
		
		$('h1').each(function (index, items) {
			alert(index + ', ' + $(items).html());
		})
		
		
	}
	
	function test3() {
		alert($('#text1').css('background'));
		alert($('#text1').val());
		
		$('#text2').val($('#text1').val());
		$('#text2').css('background', $('#text1').css('background'));
		
		//alert($('.item[data=1]').val());
		
	}
	
	//addClass('클래스이름')으로 자동으로 css가 적용되도록 할 수 있다.
	function test4() {
		$('#textDiv').removeClass();
		$('#textDiv').addClass('style1');
	}
	//추가되어 있는 class를 바꾸고 싶을 때에는 removeClass로 삭제 후 addClass로 추가한다.
	function test5() {
		$('#textDiv').removeClass();
		$('#textDiv').addClass('style2');
	}
	function test6() {
		$('#textDiv').removeClass();
		$('#textDiv').addClass('style3');
	}
	
	function test7() {
		$('#imgID').removeClass();
		$('#imgID').addClass('imgStyle1');
	}
	function test8() {
		$('#imgID').removeClass();
		$('#imgID').addClass('imgStyle2');
	}
	function test9() {
		alert($('#imgID').attr('src')); //src라는 속성의 값을 읽는 attr 함수 사용법
		alert($('#imgID').attr('width'));
		alert($('#imgID').attr('space')); //없는 속성 읽을 시 undefinded
		alert($('#imgID').attr('number')); //사용자가 임의로 만들어낸 속성 number를 읽는다
		$('#imgID').attr('src', './resources/Image/kawai.GIF');
	}
</script>
<title>jQuery 2 [배열]</title>
</head>
<body>
<h1>[ jQuery <b>배열 연습</b> ]</h1>
<h1>[ <b>배열 연습</b> ]</h1>


<p><a href="javascript:test1()">test1</a></p>
<p><a href="javascript:test2()">test2</a></p>
<p><a href="javascript:test3()">test3</a></p>
<p><a href="javascript:test4()">test4</a></p>
<p><a href="javascript:test5()">test5</a></p>
<p><a href="javascript:test6()">test6</a></p>

<p><a href="javascript:test7()">test7 (그림 크게)</a></p>
<p><a href="javascript:test8()">test8 (그림 작게)</a></p>

<p><a href="javascript:test9()">test9 (속성 제어)</a></p>
<br>
<div id="linkDiv"></div>
<div class="item" data="1"></div>
<p>
	<input type="text" id="text1" style="background:yellow;">
	<input type="text" id="text2">
</p>

<div id="textDiv">
	DIV 안의 문자열들
</div>
<br>
<img src="./resources/Image/pepeSad.jpg" width= 50px height= 50px id="imgID" number="1">

</body>
</html>