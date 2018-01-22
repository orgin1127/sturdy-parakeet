<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>jQuery3 - 이벤트 처리</title>
<script src="./resources/JS/jquery-3.2.1.min.js"></script>
<script>

	function test1() {
		alert('test1 실행');
	}
	
	function test2() {
		alert('test2 실행');
		/* $('#bt1').off(); */ //해당 id에 있는 모든 이벤트 취소
		$('#bt1').off('click'); //특정 이벤트만 취소
	}
	
	function test3() {
		$('#bt1').on('click', test1);
	}
	
	//on method 실행법
	$(document).ready(function() {
		$('#bt1').on('click', test1);
		$('#bt2').on('click', test2);
		$('#bt3').on('click', test3);
		
		$('#text1').on('click', function() {
			alert('#text1 클릭');
		});
		$('#text2').on('click', function() {
			$('#bt1').trigger('click'); //text2 가 클릭될 때 trigger를 이용하여 bt1에 연결된 이벤트 중 click 이벤트를 강제 발동
		});
		$('#text3').on('click', function() {
			setTimeout(function() {
				$('#bt1').trigger('click');
			}, 3000);
		});
		
		$('#img1, #img2').on('mouseenter', function() {
			/* var s = $(this).attr('src'); //현재 이벤트를 발생시키는 객체를 가리키는 키워드 this
			alert(s+'\n'+'어딜 보시는 겁니까 그건 제 잔상입니다.'); */
			
			//그림에 마우스 올리면 현재 크기 2배
			var s = $(this).width()*2;
			
			$(this).css('width', s);
			
		});
		$('#img1, #img2').on('mouseleave', function() {
			//마우스 떼면 현재 크기 반으로
			var s = $(this).width()/2;
			$(this).css('width', s);
		});
		
		$('.bts').on('click', function() {
			var d = $(this).attr('data');
			switch (d) {
				case '1':
					alert('1번 버튼 누름');
					break;
				case '2':
					alert('2번 버튼 누름');
					break;
				case '3':
					alert('3번 버튼 누름');
					break;
				default:
					break;
			}
		});
		
		$('#imgButton').on('click', function() {
			var array = [
				{ name: 'catch', link : './resources/Image/catch.gif'}
				, { name : 'smile', link : './resources/Image/smile.gif'}
				, { name : 'distrub', link : './resources/Image/distrub.gif'}
			];
			var output = '';
			$.each(array, function(key, value) {
				output += '<p><img src="'+value.link+'" class="imgs" id="img'+key+'"></p>';
				
			})
			$('#imgOutput').html(output);
			
			$('.imgs').on('click', function() {
				alert($(this).attr('src'));
			})
		});
		
		$('#input1, #input2').on('focus', function() {
			$(this).addClass('stlye1');
		})
		$('#input1, #input2').on('blur', function() {
			$(this).removeClass('stlye1');
		})
		
		$('#input3').on('keyup', function() {
			var count = $(this).val().length;
			$(textCount).html("글자수 : "+count+" 자리");
		})
		
		$('#hide').on('click', function() {
			$('#div1').hide();
		})
		$('#show').on('click', function() {
			$('#div1').show();
		})
		$('#toggle').on('click', function() {
			$('#div1').toggle('slow');
		})
		$('#slideUp').on('click', function() {
			$('#div1').slideUp('slow');
		})
		$('#slideDown').on('click', function() {
			$('#div1').slideDown('slow');
		})
		$('#slideToggle').on('click', function() {
			$('#div1').slideToggle('slow');
		})
		$('#fadeIn').on('click', function() {
			$('#div1').fadeIn('slow');
		})
		$('#fadeOut').on('click', function() {
			$('#div1').fadeOut('slow');
		})
		$('#fadeToggle').on('click', function() {
			$('#div1').fadeToggle('slow');
		})
	}); 

	/* $(document).ready(function() {
		$('#bt2').on('click', test2);
	}); */
</script>
<style>
	
	#text1 {
		text-decoration: underline;
		color: blue;
		cursor: pointer;
		background-color: LightGray;
		width: 120px;
		border: 1px solid black;
	}
	
	input {
		background-color: Lightgrey;
		border: 1px solid black;
	}
	
	.stlye1 {
		background-color: yellow;
		border: 2px dotted red;
	}
	#div1 {
		background-color: green;
		border: 2px dotted salmon;
		color: yellow;
		width: 180px;
		text-align: center;
	}
</style>
</head>
<body>
<h1>[ jQuery 연습 - 이벤트 ]</h1>


<p><input type="button" value="test1() 실행" id="bt1"></p> <!-- test1 기능 작동 -->
<p><input type="button" value="test2() 실행" id="bt2"></p> <!-- bt1의 이벤트 취소 -->
<p><input type="button" value="test3() 실행" id="bt3"></p> <!-- bt원에 다시 이벤트 추가 -->

<p id="text1">일반 텍스트로 이벤트 처리</p>
<p id="text2">일반 텍스트로 이벤트 처리2</p>
<p id="text3">일반 텍스트로 이벤트 처리3</p>

<!-- 아래 이미지 위로 마우스 포인터 올리면 그림경로 출력 -->
<p><img src="./resources/Image/double.gif" id="img1"></p>
<p><img src="./resources/Image/dance.gif" id="img2"></p>

<p><input type="button" value="버튼" class="bts" data="1"></p>
<p><input type="button" value="버튼" class="bts" data="2"></p>
<p><input type="button" value="버튼" class="bts" data="3"></p>

<p id="imgButton">문서 객체 생성</p>
<div id="imgOutput"></div>

<p><input type="text" id="input1"></p>
<p><input type="text" id="input2"></p>

<p><input type="text" id="input3"></p>
<div id="textCount"></div>

<input type="button" id="hide" value="hide()">
<input type="button" id="show" value="show()">
<input type="button" id="toggle" value="toggle()">
<input type="button" id="slideUp" value="slideUp()">
<input type="button" id="slideDown" value="slideDown()">
<input type="button" id="slideToggle" value="slideToggle()">
<input type="button" id="fadeIn" value="fadeIn()">
<input type="button" id="fadeOut" value="fadeOut()">
<input type="button" id="fadeToggle" value="fadeToggle()">
<br>
<div id="div1">
	<p>div 안의 문자열</p>
	<p>div 안의 문자열</p>
	<p>div 안의 문자열</p>
</div>
</body>
</html>