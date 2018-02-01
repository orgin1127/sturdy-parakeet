<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script src="./resources/JS/jquery-3.2.1.min.js"></script>
<title>[ Ajax 연습 - Reply ]</title>
<style>
	.replyTable {
		border: 1px solid grey;
	}
	td {
		border: 1px solid grey;
	}
	tr {
		border: 1px solid grey;
	}
</style>

<script>

	$(document).ready(function() {
		$('#formButton').on('click', sendReply);
	
		init();

	});

	function sendReply() {
		//이름, 리플 내용 읽기
		var name = $('#name').val();
		var text = $('#text').val();
		//내용이 없거나 기준에 맞지 않으면 경고 후 리턴
		if (name == '' || text == '') {
			alert('값을 입력하여 주세요');
			return;
		}
		//서버로 저장 요청 보냄
		$.ajax({
			url: 'insert'
			, type: 'post'
			, data: {name: name, text: text}
			, dataType: 'text'
			, success: function(result) {
				if (result ==1) {
					//성공하면 "저장되었습니다." 메세지 출력 후 폼 초기화
					alert('저장 되었습니다.');		
					$('#name').val('');
					$('#text').val('');
					init();
				}
				if (result ==0) {
					alert('저장에 실패하였습니다. 다시 시도하여 주세요');
				}
			}
			, error: function() {
				alert('저장에 실패하였습니다.');
			}
		});
	}
	
	//리플 목록 읽어서 화면에 출력
	function init() {
		$.ajax({
			url: 'replyList'
			, type: 'get'
			, dataType: 'json'
			, success: function (replyList) {
				output(replyList);
			}
			, error: function() {
				alert('에러입니다.');
			}
		})
	}
	
	function output(replyList) {
		var output = '<table class="replyTable">';
		//리플 정보를 HTML 태그와 함께 output에 추가
		$.each(replyList, function(index, values) {
			output += '<tr><td class="tdNumHead">번호</td><td class="tdNum">'+values.num+'</td>';
			output += '<td class="tdNameHead">작성자</td><td class="tdName">'+values.name+'</td>';
			output += '<td class="tdTextHead">내용</td><td class="tdTextHead">'+values.text+'</td>';
			output += '<td><input type="button" value="삭제" class="delButton"'+ 'delNum="' + values.num +'"></td></tr>';
		})
		output += '</table>';
		$('#replyDiv').html(output);
		//html 함수로 집어넣은 뒤에야 위의 output에 들어간 객체들을 사용 가능하다
		$('.delButton').on('click', deleteReply);
	}
	
	function deleteReply() {
		$.ajax({
			url: 'deleteReply'
			, type: 'get'
			, data: {delNum: $(this).attr('delNum')}
			, dataType: 'text'
			, success: function(result) {
				if (result == 1) {
					alert('리플 삭제 성공');
					init();
				}
				else {
					alert('리플 삭제 실패');
				}
			}
			, error: function(e) {
				alert('에러입니다.');
			}
		})
	}
	
</script>
</head>
<body>
<h1>Ajax 연습 - Reply</h1>
<!-- 리플 출력 영역 -->
<div id="replyDiv"></div>
<!-- 리플 작성 폼 -->
<div id="formDiv">
	<form id="writeForm">
		이름 <input type="text" id="name" class="tdName">
		내용 <input type="text" id="text" class="tdText">
		<input type="button" id="formButton" value="저장">
	</form>
</div>
</body>
</html>