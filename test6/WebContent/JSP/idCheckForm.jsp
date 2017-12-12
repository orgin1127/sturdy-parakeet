<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>ID 중복 확인 </title>

<style>
	
	body {
		background-color: #607D8B;
	}
	
	.checkForm {
		width: 320px;
		margin: auto;
		margin-top: 20px;
		background-color: #ECEFF1;
		height: 25px;
		padding: 8px;
		border: 3px dotted lightgrey;
	}
	
	.idCheckHeader {
		color: #E0F2F1;
		text-align: center;
		width: 140px;
		height: 30px;
		margin: auto;
	}
	
	.canuse {
		color: #FFCDD2;
		text-align: center;
	}
</style>

<script>

function IDCheck() {
	var id = document.getElementById('userid');
	var checkIDs = /[\w]{4,8}/;
	
	if (!(checkIDs.test(id.value))) {
		alert('아이디는 영문 혹은 숫자로 4자리 이상 8자리 이하여야 합니다.');
		id.focus();
		id.select();
		return false;
	}
}

function usethisID() {
	var checkedID = '${param.searchID}';
	var idForm = opener.document.getElementById('userid');
	idForm.value = checkedID;
	this.close();
	/*js에서도 현재 페이지는 this. 이고 어떤 창에서 js를 통해서 새 창을 열었을 경우
	원래 창을 opener라고 부른다*/
}

</script>

</head>
<body>
<div class="idCheckHeader"><h3> [ ID 중복 검사 ] </h3></div><br>
<!-- ID 검색 폼 -->
<div class="checkForm">
	<form method="post" action="member">
		<input type="hidden" name="action" value="idCheck">
		사용할 ID : &nbsp;&nbsp;<input type="text" name="searchID" id="userid" value="${param.searchID}">
		<input type="submit" value="검색" onclick="return IDCheck()">
	</form>
</div>

<!-- 검색 후에만 출력 -->
<c:if test="${param.searchID !=null}"> 
		<!-- 검색 결과가 있을 때 - 사용불가 -->
		<c:if test="${member != null}"><p>사용불가한 ID 입니다.</p></c:if>
		<!-- 검색 결과가 없을 때 - 사용가능 -->
		<c:if test="${member == null}">
			<p class="canuse"><b>사용 가능한 ID 입니다.</b></p>
			<p><input type="button" value="ID 사용하기" onclick="usethisID()"></p>
		</c:if>
</c:if>
	


</body>
</html>