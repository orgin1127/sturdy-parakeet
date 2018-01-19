<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>jQuery 연습</title>
<script src="./resources/JS/jquery-3.2.1.min.js"></script>
<script>
	//ready는 페이지가 로딩되며 가장 먼저 할일을 정의하는 함수
	//이곳에서 각종 밑작업을 설정해놓는다
	/* $(document).ready(function () {
		alert('jQuery 작동확인');
	}); */
	
	/* $(document).ready(start);
	
	function start() {
		alert('jQuery 작동확인2');
	} */
	/* $(document).ready(basicJQueryPrac); */
	
	function basicJQueryPrac() {
		$('h1').css('color', 'red');
	}
	
	function test1() {
		$('h1').css('color', 'red');
		$('p').css('color', 'SeaGreen');
		$('#div1 > p').css('color', 'SpringGreen');
		$('p > span.boldtext').css('color', 'red');
		$('#ptext').css('color', 'yellow');
		$('p.bluetext').css('color', 'blue');
	

	}
	
	//Form 요소 선택 연습
	function test2() {
		
		$('input[type="text"]').val('Hello jQuery');
		$('input[type="text"]').css('background-color', 'Chartreuse');
		$('input[type="password"]').css('background-color', 'DarkSlateGrey');
		
		$('textarea').css('background-color', 'Teal');
		
	}
	
	//표 요소 선택 연습
	function test3() {
		$('table').css('border', 'solid 1px red');
		$('tr> td').css('border', 'dotted 1px green');
		$('table').css('text-align', 'center');
		$('tr > td').css('text-align', 'center');
	}
	
	function test4() {
		var output = $('select > option:selected').val();	
		alert(output);
	}
	
	function test5() {
		$('tr:odd').css('background', 'Tomato');
		$('tr:even').css('background', 'Teal');
		$('th').css('background','PaleTurquoise');
	}
	
</script>
</head>
<body>

<h1> [ jQuery 연습 ] </h1>
<%-- <img src="./resources/Image/pepeSad.jpg">--%>

<p><a href="javascript:test1()">test1()</a>
<p><a href="javascript:test2()">test2()</a>
<p><a href="javascript:test3()">test3()</a>
<p><a href="javascript:test5()">test5()</a>

<p>p태그 사용한 문자열</p>
<p>p태그 사용한 문자열</p>
<p id="ptext">p태그 사용한 문자열</p>
<p class="bluetext">p태그 사용한 문자열</p>

<p><img src="./resources/Image/pepeSad.jpg"></p>

<div id="div1">
	<p>div내의 p태그</p>
	<p>div내의 p태그 <span class="boldtext">그 안의 span태그</span></p>
</div>

<table>
	<tr>
		<td>aaa</td>
		<td>bbb</td>
	</tr>
	<tr>
		<td>ccc</td>
		<td>ddd</td>
	</tr>
</table>
<br>
<form>
	ID<input type="text"><br>
	PW<input type="password"><br>
	<textarea rows="" cols=""></textarea>
	<input type="submit" value="전송">
</form>
<br>
<select onchange="javascript:test4()">
	<option selected="selected">DEFAULT</option>
	<option>iPhone</option>
	<option>Galaxy</option>
	<option>V30</option>
	<option>iPad</option>
</select>
<br><br><br>

<table>
	<tr>
		<th>이름</th><th>혈액형</th><th>지역</th>
	</tr>
	<tr>
		<td>
			강민수
		</td>
		<td>
			ab형
		</td>
		<td>
			서울특별시 송파구
		</td>
	</tr>
	<tr>
		<td>
			구지연
		</td>
		<td>
			B형
		</td>
		<td>
			미국 캘리포니아
		</td>
	</tr>
	<tr>
		<td>
			김미화
		</td>
		<td>
			AB형
		</td>
		<td>
			미국 메사추세츠
		</td>
	</tr>
	<tr>
		<td>
			김선화
		</td>
		<td>
			O형
		</td>
		<td>
			서울 강서구
		</td>
	</tr>
	<tr>
		<td>
			남기주
		</td>
		<td>
			A형
		</td>
		<td>
			서울 노량진구
		</td>
	</tr>
	<tr>
		<td>
			윤하린
		</td>
		<td>
			B형
		</td>
		<td>
			서울 용산구
		</td>
	</tr>
</table>






</body>
</html>