<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>JS4</title>

<script>
	var temp;
	
	function test1() {
		temp = window.open("js1", "JS 기본문법 연습", "top=200,left=300,width=450,height=250,resizable=no");
		
	}
	
	function test2() {
		if (temp == undefined) {
			alert('열린 창이 없습니다.');
		}
		else if (temp.closed) {
			alert('창이 닫혔습니다.');
		}
		else {			
			temp.close();
		}
	}
	
	function test3() {
		if (temp == undefined) {
			alert('열린 창이 없습니다.');
		}
		else if (temp.closed) {
			alert('창이 닫혔습니다.');
		}
		else {
			temp.moveTo(0,0);
			temp.focus();
		}
	}
	
	function test4() {
		if (temp =='undefined') {
			alert('열린 창이 없습니다.');
		}
		else if (temp.closed) {
			alert('창이 닫혔습니다.');
		}
		else {			
			setInterval (function () {
				temp.moveBy(10,10);
			}, 1000);
		}
	}
	
	function test5() {
		var clientScreenWidth = screen.width;
		var clientScreenHeight = screen.height;
		var clientAvailWidth = screen.availWidth;
		var clientAvailHeight = screen.availHeight;
		alert(clientScreenWidth+", "+clientScreenHeight);
		alert(clientAvailWidth+", "+clientAvailHeight);
	}
	
	var win;
	function test6() {
		//사용자 화면 가로, 세로 반 정도 크기의 창을 화면 정중앙에 열고, 1초마다 크기가 10px씩 늘어남
		//일정 크기가 되면 반복 종료하고 창 닫음
		var clientHalfScreenWidth = screen.width/2;
		var clientHalfScreenHeight = screen.height/2;
		win = window.open("js1", "","width="+clientHalfScreenWidth+",height="+clientHalfScreenHeight);
		win.moveBy(250,250);
		setInterval(function () {
			win.resizeBy(20, 20);
			if (win.outerWidth >= clientHalfScreenWidth*2 || win.outerHeight >= clientHalfScreenHeight*2){
				win.close();
			}
		}, 1000);
		
	}
	
	function test7() {
		alert('현재경로:'+location.href);
		alert('Naver로 이동합니다.');
		location.href = 'http://www.naver.com/';
	}
	
	function test8() {
		var userNavi = navigator.userAgent;
		//alert(navigator.userAgent);
		
		var keywords = ['mobile', 'android', 'ios', 'samsung'];
		for ( var key in keywords) {
			if (userNavi.includes(keywords[key])) {
				location.href = 'jsmobile';
			}
			else {
				location.href = 'jspc';
			}
		} 
		
	}
	function test9() {
		history.go(-1);
	}
</script>
</head>
<body>
<h1>[ 브라우저 객체 모델 ]</h1>
<p><a href="javascript:test1()">test1</a>
<p><a href="javascript:test2()">test2</a>
<p><a href="javascript:test3()">test3</a>
<p><a href="javascript:test4()">test4</a>
<p><a href="javascript:test5()">test5 (Screen 객체 사용, 사용자 화면 정보)</a>
<p><a href="javascript:test6()">test6</a>
<p><a href="javascript:test7()">test7</a>
<p><a href="javascript:test8()">test8(navigator)</a>
<p><a href="javascript:test9()">test9(History)</a>
</body>
</html>