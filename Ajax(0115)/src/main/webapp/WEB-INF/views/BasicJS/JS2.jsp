<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>JS2</title>
<script>

	function test1() {
		alert('test1 실행');
	}
	//test1는 JSP 로딩 시 미리 로딩되어 준비된 상태가 된다.
	//test2는 해당 행(14행)까지 프로그램 흐름이 와야 함수가 정의되어서 변수에 대입된다
	var test2 = function () { alert('test2 실행'); }
	
	function test3() {
		setTimeout(function () {
			alert('test3 3초 지남');
		}, 3000);
	}
	
	//이때의 test1을 콜백함수(등록)이라고 한다. 
	//setTimeout(test1 , 3000);
	//setTimeout(function () { alert('5초 지남!')}, 5000);
	var date = new Date();
	var test4ID;
	function test4 () { 
		test4ID = setInterval( function() {
			alert(date.getFullYear()+', '+date.getMonth()+1+', '+date.getDate()); 
		}, 3000);
	}
	
	function test5() { 
		clearInterval(test4ID);
	}
	
	//단순 정규식일 경우 0100, 0x10, 1.5e3등의 숫자표현을 숫자로 인식 불가
	function test6() {
		var rex = /^[0-9]*$/;
		var input = prompt('숫자를 입력하시오');
		if (rex.test(input)) {
			alert('숫자임');
		}
		else {
			alert('숫자만 입력하세요');
		}
	}
	
	function test7() {
		var input = prompt('숫자를 입력하세요.');
		var num = Number(input);
		if (isNaN(num)) {
			alert(input + ' : 숫자가 아님');
		}
		else {
			alert(num + ' : 숫자입니다. ');
		}
	}
</script>
</head>
<body>

<p><a href="javascript:test1()">test1()</a></p>
<p><a href="javascript:test2()">test2()</a></p>
<p><a href="javascript:test3()">클릭시 3초 후 실행</a></p>
<p><a href="javascript:test4()">클릭시 3초 마다 실행</a></p>
<p><a href="javascript:test5()">실행중지</a></p>
<p><a href="javascript:test6()">입력 숫자 문자열 유효성 검사</a></p>
<p><a href="javascript:test7()">숫자확인 2</a>
</body>
</html>