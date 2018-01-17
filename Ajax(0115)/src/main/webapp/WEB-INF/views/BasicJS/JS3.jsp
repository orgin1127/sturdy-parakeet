<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>JS3</title>
<script>

	function test1() {
		//JS의 객체는 {}로 생성자를 만든다
		var board = {
			boardnum : 10
			, name : '홍길동'
			, title : '글제목'
			, contents : '글내용'
		};
		//JS 객체를 그냥 출력시 Object가 출력됨
		alert(board);
		//JS 객체 안의 특정 속성 값을 출력할때 객체명.속성명 or 객체명[속성명]
		alert(board.boardnum);
		alert(board.title);
		//JSON type으로 받은 자료의 내부를 보고 싶을때
		alert(JSON.stringify(board));
		
		//JS 객체 안의 특정 속성 값 접근 방법 중 객체명[속성명]을 이용하면 
		//속성명을 일일히 쓸 필요 없이 FOR IN 반복으로 반복이 가능하다
		// VAR KEY => 객체의 속성 개수만큼 하나하나 변한다
		//FOR IN의 반복 회수는 대상 객체의 속성 수만큼 
		var output = '';
		for ( var key in board) {
			output += '*' + key + ' : ' + board[key] + '\n';
		}
		alert(output);
	}

	function test2() {
		var student = {
			name :'홍길동'
			, birth : {year:1999, month:10, date:5}
			, score : [100, 100, 90]
			, test : true
		};
		
		var output = document.getElementById('test2Div');
		var tab = '';
		
		tab += '<table border="1"><tr><td>이름</td>';
		tab += '<td colspan="3">'+student.name+'</td>';
		tab += '</tr><tr><td>생년월일</td><td colspan="3">'+student.birth.year+'/'+student.birth.month+'/'+student.birth.date+'</td></tr>';
		tab += '<tr><td>점수</td><td>'+student.score[0]+'</td>';
		tab += '<td>'+student.score[1]+'</td>';
		tab += '<td>'+student.score[2]+'</td></tr>';
		tab += '<tr><td>평가</td><td colspan="3">';
		if (student.test == true ) { 
			tab += '합격';
		}
		else {
			tab += '불합격';
		}
		tab += '</td></tr></table>';
		
		output.innerHTML = tab;
	}
	
	function test3() {
		//prompt()로 숫자 입력받음
		//3~10자리이고, 0-9외엔 포함되면 안됨
		
		//정규식 버전 3~10자리 순수숫자
		var rex = /^\d{3,10}$/ig;
		var input = prompt('숫자 3~10자리를 입력하여 주세요');
		
		if (rex.test(input)) {
			alert('3~10자리의 숫자입니다.');
		}
		else {
			alert('숫자가 아닌 것이 포함되어 있거나 자리수가 올바르지 않습니다.');
		}
		
		var n = prompt('숫자입력');
		if (n.length < 3 || n.length > 10) {
			alert('틀렸어');
		} 
		
		if (isNaN(n)) {
			alert('숫자아님');
		}
		
	}
</script>

</head>
<body>

<p><a href="javascript:test1()">객체의 생성과 사용</a></p>
<p><a href="javascript:test2()">객체의 생성과 사용2</a></p>
<p><a href="javascript:test3()">String 객체의 생성과 사용3</a></p>
<br>
<div id="test2Div"></div>
</body>
</html>