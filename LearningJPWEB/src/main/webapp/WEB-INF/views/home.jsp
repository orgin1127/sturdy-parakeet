<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Learn Japanese & Enjoy your Study</title>
	
	<!-- JS -->
	<script src="./resources/JS/jquery-3.2.1.min.js"></script>
	<script src="./resources/JS/registerJS.js"></script>
	<script src="./resources/JS/loginJS.js"></script>
	<script src="./resources/JS/wordSearchJS.js"></script>
	<script src="./resources/JS/BlinkGame.js"></script>
	<script src="./resources/JS/UserInfoEdit.js"></script>
	<!-- CSS -->
	<link href="./resources/CSS/registerModalCSS.css" rel="stylesheet" type="text/css">
	<link href="./resources/CSS/LoginCSS.css" rel="stylesheet" type="text/css">
	<link href="./resources/CSS/SearchWordCSS.css" rel="stylesheet" type="text/css">
	<link href="./resources/CSS/BlinkGameCSS.css" rel="stylesheet" type="text/css">
	<link href="./resources/CSS/HomeCSS.css" rel="stylesheet" type="text/css">
	<link href="./resources/CSS/UserInfoEditCSS.css" rel="stylesheet" type="text/css">
	<!-- font -->
	<link href="https://fonts.googleapis.com/css?family=Anton" rel="stylesheet">
</head>
<body>
<div class="headimg"><img src="./resources/IMAGE/raccoon.png" width="300" height="300" ></div>
<br><br>
	<table class="userNaviTable" id="userNaviTable">
		<tr>
			<c:if test="${loginUser == null}">
				<td><button id="myButton">회원가입</button></td>
				<td><button id="myLogin">로그인</button></td>
			</c:if>
			<c:if test="${loginUser != null}">
				<td><button id="myWordSearch">단어검색</button></td>
				<td><button id="myBlinkGame">단어게임</button></td>
				<td>환영합니다.</td><td>${loginUserName}(${ loginUserID})님!</td>
				<td><a href="userLogout"><button id="myLogout">로그아웃</button></a></td>
			</c:if>
		</tr>
	</table>

	<!-- Trigger/Open The Modal -->


	<!-- The Register Modal -->
	<div id="myRegisterModal" class="modal">
	  	<!-- Modal content -->
		<div class="modal-content" id="registerModalContent">
			  <div class="modal-header" id="registerModalHeader">
			    <span class="closeModal" id="registerCloser">&times;</span>
			    <h2>[ R e g i s t e r ]</h2>
			  </div>
			  <div class="modal-body" id="myRegisterModalBody"></div>
			  <div class="modal-footer" id="registerModalFooter"><h1> </h1></div>
		</div>
	</div>
	
	<!-- Login Modal -->
	<div id="myLoginModal" class="modal">
		<div class="modal-content" ID="loginModalContent">
			<div class="modal-header" id="loginModalHeader">
				<span class="closeModal" id="loginCloser">&times;</span>
			    <h2>[ Log - IN ]</h2>
			</div>
			<div class="modal-body" id="myLoginModalBody"></div>
			<div class="modal-footer" id="loginModalFooter"><h1> </h1></div>
		</div>
	</div>

	<!-- UserWordSearch Div -->
	<div class="modal" id="userWordSearchModal">
		<div class="modal-content" id="SearchWordModalContent">
			<div class="modal-header" id="wordSearchModalHeader">
				<span class="closeModal" id="wordSearchCloser">&times;</span>
				<h2>[ Searching Word ]</h2>
			</div>
			<div id="mySearchWordBody">
				<div id="searchFormDiv"><form action="wordSearch" method="get" id="wordSearchForm">
					<input type="hidden" name="page" id="page">
					<select name="searchType">
						<option value="" selected="selected">--검색 방법 선택--</option>
						<option value="word">한자</option>
						<option value="yomigana">발음</option>
						<option value="meaning">뜻</option>
						<option value="wordAndYomi">한자 & 발음</option>
					</select>
					<input type="text" name="inputWord" id="inputWord" value="${searchText}">
					<input type="button" onclick="searchWord(1)" value="검색">
				</form></div><span id="downSearchList"></span>
				<div id="searchResultPrintDiv"></div>
				<div id="pageNavigator"></div>
			</div>
			<div class="modal-footer" id="wordSearchModalFooter"><h1> </h1></div>
		</div>
	</div>
	
	<!-- UserWordBlinkGame -->
	<div id="myBlinkModal" class="modal">
		<div class="modal-content" ID="blinkModalContent">
			<div class="modal-header" id="blinkModalHeader">
				<span class="closeModal" id="blinkGameCloser">&times;</span>
			    <h2>[ Blink Word ]</h2>
			</div>
			<div class="modal-body" id="myBlinkModalBody">
				<select name="gameType" id="gameType">
					<option value="" selected="selected">게임 난이도 선택</option>
					<option value="N1">N1</option>
					<option value="N2">N2</option>
					<option value="N2">N3</option>
					<option value="N2">N4</option>
					<option value="N2">N5</option>
				</select>
				<input type="button" id="blinkGameStartBT" value="게임시작">
				<div id="gameInfoDiv"></div>
				<div id="gameContentDiv"></div>
				<div id="answerInputDiv"></div>
			</div>
			<div class="modal-footer" id="blinkModalFooter"><h1> </h1></div>
		</div>
	</div>
</body>
</html>
