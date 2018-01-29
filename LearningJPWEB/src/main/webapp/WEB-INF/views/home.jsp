<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Lean Japanese & Enjoy your Study</title>
	
	<!-- JS -->
	<script src="./resources/JS/jquery-3.2.1.min.js"></script>
	<script src="./resources/JS/registerJS.js"></script>
	<script src="./resources/JS/loginJS.js"></script>
	<script src="./resources/JS/wordSearchJS.js"></script>
	<!-- CSS -->
	<link href="./resources/CSS/registerModalCSS.css" rel="stylesheet" type="text/css">
	
</head>
<body>
	<table>
		<tr>
			<c:if test="${loginUser == null}">
				<td><button id="myButton">회원가입</button></td>
				<td><button id="myLogin">로그인</button></td>
			</c:if>
			<c:if test="${loginUser != null}">
				<td><button id="myWordSearch">단어검색</button></td>
				<td>단어게임</td>
				<!-- <td><button id="myUserBoard">게시판</button></td> -->
				<td>환영합니다 ${loginUserName}(${ loginUserID})님!</td>
				<td>정보수정</td>
				<td><a href="userLogout"><button id="myLogout">로그아웃</button></a></td>
			</c:if>
		</tr>
	</table>
	<hr>

	<!-- Trigger/Open The Modal -->


	<!-- The Register Modal -->
	<div id="myRegisterModal" class="modal">
	  	<!-- Modal content -->
		<div class="modal-content">
			  <div class="modal-header">
			    <span class="closeModal" id="registerCloser">&times;</span>
			    <h2>[ R e g i s t e r ]</h2>
			  </div>
			  <div class="modal-body" id="myRegisterModalBody"></div>
			  <div class="modal-footer"><h1> </h1></div>
		</div>
	</div>
	
	<!-- Login Modal -->
	<div id="myLoginModal" class="modal">
		<div class="modal-content">
			<div class="modal-header">
				<span class="closeModal" id="loginCloser">&times;</span>
			    <h2>[ Log - IN ]</h2>
			</div>
			<div class="modal-body" id="myLoginModalBody"></div>
			<div class="modal-footer"><h1> </h1></div>
		</div>
	</div>
	
	<!-- UserWordSearch Div -->
	<div class="modal" id="userWordSearchModal">
		<div class="modal-content" id="SearchWordModalContent">
			<div class="modal-header">
				<span class="closeModal" id="wordSearchCloser">&times;</span>
				<h2>[ Searching Word ]</h2>
			</div>
			<div id="mySearchWordBody"></div>
			<div class="modal-footer"><h1> </h1></div>
		</div>
	</div>
</body>
</html>
