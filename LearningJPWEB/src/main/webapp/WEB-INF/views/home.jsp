<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
<head>

	<title>Lean Japanese & Enjoy your Study</title>
	
	<style>
		/* The Modal (background) */
		.modal {
		    display: none; /* Hidden by default */
		    position: fixed; /* Stay in place */
		    z-index: 1; /* Sit on top */
		    padding-top: 100px; /* Location of the box */
		    left: 0;
		    top: 0;
		    width: 100%; /* Full width */
		    height: 1000%; /* Full height */
		    overflow: auto; /* Enable scroll if needed */
		    background-color: rgb(0,0,0); /* Fallback color */
		    background-color: rgba(0,0,0,0.4); /* Black w/ opacity */
		}
		

		/* Modal Header */
		.modal-header {
		    padding: 2px 16px;
		    background-color: #5cb85c;
		    color: white;
		}
		
		/* Modal Body */
		.modal-body {
			padding: 2px 16px;
			margin: auto;
			width: 280px;
		}
		
		/* Modal Footer */
		.modal-footer {
		    padding: 2px 16px;
		    background-color: #5cb85c;
		    color: white;
		}
		
		/* Modal Content */
		.modal-content {
		    position: relative;
		    background-color: #fefefe;
		    margin: auto;
		    padding: 0;
		    border: 1px solid #888;
		    width: 40%;
		    font-size: 15px;
		    text-align: center;
		    box-shadow: 0 4px 8px 0 rgba(0,0,0,0.2),0 6px 20px 0 rgba(0,0,0,0.19);
		    animation-name: registerModal;
		    animation-duration: 0.5s
		}
		#registerTable {
			text-align: center;
			border: 3px Lightgrey dotted;
		}
		#registerForm {
			padding: 0;
			margin-right: 0px;
			width: 270px;
		}
		/* The Close Button */
		#closeModal {
		    color: #aaaaaa;
		    float: right;
		    font-size: 28px;
		    font-weight: bold;
		}
		
		#closeModal:hover,
		#closeModal:focus {
		    color: #000;
		    text-decoration: none;
		    cursor: pointer;
		}
		@keyframes registerModal {
		    from {top: -300px; opacity: 0}
		    to {top: 0; opacity: 1}
		}
	</style>
	<script src="./resources/JS/jquery-3.2.1.min.js"></script>
	<script>
		$(document).ready(function() {
			// When the user clicks on the button, open the modal 
			$('#myButton').on('click', function() {
				$('#myModal').css('display', 'block');
				makeRegisterForm();
				// Get the <span> element that closes the modal
				// When the user clicks on <span> (x), close the modal
				$('#closeModal').on('click', closeModal);
				$('#registerSubmit').on('click', submitRegisterForm);
			})
			
		})
		function makeRegisterForm() {
			var contentForModalBody = "";
			contentForModalBody += '<p><form action="register" method="post" id="registerForm"><table id="registerTable">';
			contentForModalBody += '<tr><td>I D</td><td><input type="text" id="userID" name="userID" placeholder="ID를 입력하여 주세요">';
			contentForModalBody += '<br><span id="idValidateCheck"> </span></td></tr>';
			contentForModalBody += '<tr><td>PASSWORD</td><td><input type="password" id="userPassword" name="userPassword"></td></tr>';
			contentForModalBody += '<tr><td>닉네임</td><td><input type="text" id="userName" name="userName"></td></tr>';
			contentForModalBody += '<tr><td colspan="2"><input type="button" id="registerSubmit" value="회원가입"></td></tr>';
			contentForModalBody += '</table></form></p>';
			$('.modal-body').html(contentForModalBody);
		}
		function closeModal() {
			$('#myModal').css('display', 'none');
		}
		function submitRegisterForm() {
			var userID = $('#userID').val();
			var userPassword = $('#userPassword').val();
			var userName = $('#userName').val();
			$.ajax({
				url: 'register'
				, type: 'post'
				, data: {userID: userID, userPassword: userPassword, userName: userName}
				, dataType: 'text'
				, success: function(result) {
					if (result == 1) {
						alert('회원가입에 성공하셨습니다. 메인으로 돌아갑니다.');
						closeModal();
					}
					else {
						alert('회원가입에 실패하였습니다. 입력사항을 확인하여 주세요');
						return;
					}
				}
				, error: function(e) {
					alert(JSON.stringify(e));
				}
			});
		}
	</script>
</head>
<body>
	<div class="sidemenu">
		<ul>
			<li><button id="myButton">회원가입</button></li>
			<li><a href="">로그인</a></li>
			<li>단어검색</li>
			<li>단어게임</li>
			<li>게시판</li>
		</ul>
	</div>
	<div class="mainContent" id="registerWindow"></div>
	<!-- Trigger/Open The Modal -->


	<!-- The Modal -->
	<div id="myModal" class="modal">
	  	<!-- Modal content -->
		<div class="modal-content">
			  <div class="modal-header">
			    <span id="closeModal">&times;</span>
			    <h2>[ R e g i s t e r ]</h2>
			  </div>
			  <div class="modal-body"></div>
			  <div class="modal-footer"><h1> </h1></div>
		</div>
	</div>
	
</body>
</html>
