<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<script>
	//Javascirpt 주석 (소스보기 보임)
	/* JavaScript 주석 (소스보기 보임)*/
	var b = 0;
	function test1() {
		var a = 0;
		a++;
		b++;
		alert(a+', '+b);
	}
	function test2() {
		var n = 100;
		var res = document.getElementById('resultDiv');
		var total = 0;
		for (var i = 1; i <= n; i++) {
			if (i%3 == 0) {
				total = total + i;
				res.value = res.value+""+i;
				res.innerHTML = res.value;
			}
		}
		alert(total);
	}
	function test3() {
		var n = parseInt(prompt("값을 구할 범위를 입력하여 주세요"));
		alert(n+1);
		var p = paseInt(prompt('값을 구할 배수를 입력하여 주세요'));
		var total = 0;
		for (var i = 1; i <= n; i++) {
			if (i%p == 0) {
				total = total + i;
			}
		}
		alert(total);
	}
	function test4(n, p) {
		var total = 0;
		for (var i = 1; i <= n; i++) {
			if (i%p ==0) {
				total = total + i;
			}
		}
		alert(total);
	}
	function test5() {
		//a ~ b까지의 모든 정수의 합계
		var start = parseInt(prompt("값을 구할 시작값을 입력하여 주세요"));
		var end = parseInt(prompt('값을 구할 끝 값을 입력하여 주세요'));
		//정의한 함수 sum을 호출하여 parameter를 전달해 결과값을 return 받는다
		var c = sum(start, end);
		alert(start + '~' + end + '의 합계는 : ' + c);
	}
	function sum(num1, num2) {
		var result = 0;
		for (var i = num1; i <= num2; i++) {
			result += i;
		}
		return result;
	}
	function test6() {
		var start = parseInt(document.getElementById('startNumInput').value);
		var end = parseInt(document.getElementById('endNumInput').value);
		var total = 0;
		for (var i = start; i <= end; i++) {
			total += i;
		}
		var ss = document.getElementById('resultD');
		ss.innerHTML = total;
	}
	function test7() {
		var ar = [10, 20, 30, 40, 50];
		var result = 0;
		for (var i = 0; i < ar.length; i++) {
			result += ar[i];
		}
		alert(result);
	}
	function test8() {
		var ar = [];
		var total = 0;
		while(confirm('숫자를 입력하시겠습니까?')) {
			ar.push(parseInt(prompt('숫자를 입력하여 주세요')));
		}
		for (var i = 0; i < ar.length; i++) {
			total += ar[i];
		}
		alert(total);
	}
	function test9() {
		var flag = true;
		while(flag) {
			var input = prompt('문장을 입력하여 주세요 (종료하고 싶을 경우 종료 를 입력하여 주세요.)');
			switch (input) {
				case '안녕':
					alert('안녕하세요.');
					break;
				case '종료':
					flag = false;
					break;
				default:
					alert('안녕 이라고 해보세요');
					break;
			}
		}
	}
	function test10() {
		var start = parseInt(prompt('곱셈을 시작할 값을 입력하여주세요'));
		var end = parseInt(prompt('곱셈의 끝 값을 입력하여주세요'));
		var result = multiply(start, end);
		alert(result);
	}
	function multiply(a, b) {
		var result = 1;
		for (var i = a; i <= b; i++) {
			result *= i;
		}
		return result;
	}
	function test11() {
		var ar = [52, 273, 103, 32, 57, 103, 31, 2];
		var max = 0;
		var min = ar[0];
		var temp = ar[0];
		for (var i = 0; i <ar.length-1; i++) {
			if (ar[i] <= ar[i+1]) {
				if(max <= ar[i+1]) {
					max = ar[i+1];
				}
				else if(min>= ar[i]){					
					min = ar[i]
				}
			}
			else if(ar[i]>=ar[i+1]) {
				if(max <= ar[i]) {
					max = ar[i];
				}
				else if(min>= ar[i+1]){					
					min = ar[i+1]
				}
			}
		}
		alert('최대값은 '+max +', 최소값은 '+min);
	}
</script>
<body>
<h1>[Java Script 연습]</h1>

<p><a href="javascript:test1()">test1()</a></p>
<p><a href="javascript:test2()">test2()</a></p>
<p><a href="javascript:test3()">test3()</a></p>
<p><a href="javascript:test4(100, 3)">test4()</a></p>
<p><a href="javascript:test5()">test5()</a></p>
<p><a href="javascript:test6()">test6()</a></p>
<p><a href="javascript:test7()">test7()</a></p>
<p><a href="javascript:test8()">test8()</a></p>
<p><a href="javascript:test9()">test9()</a></p>
<p><a href="javascript:test10()">test10()</a></p>
<p><a href="javascript:test11()">test11()</a></p>
<div id="resultDiv"></div>
<br>
<input type="text" id="startNumInput"> ~ <input type="text" id="endNumInput">의 합계는 : <span id="resultD"></span>
<%-- JSP 주석(소스보기 하면 안보임) --%>
<!-- HTML 주석(소스보기 하면 보임) -->
</body>
</html>