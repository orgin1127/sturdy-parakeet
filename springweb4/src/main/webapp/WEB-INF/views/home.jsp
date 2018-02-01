<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
<head>
	<title>Home</title>
	<script>
		function mapStart() {
			var container = document.getElementById('map'); //지도를 담을 영역의 DOM 레퍼런스
			var options = { //지도를 생성할 때 필요한 기본 옵션
				center: new daum.maps.LatLng(33.450701, 126.570667), //지도의 중심좌표.
				level: 3 //지도의 레벨(확대, 축소 정도)
			};
			var map = new daum.maps.Map(container, options); //지도 생성 및 객체 리턴
		}
	</script>
</head>
<body onload="mapStart()">
<script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=19ab5a8b74e84b882f7f3add83506ef4"></script>
<h1>
	Hello world! This is Spring Web 4 Practice Home
</h1>

<P>  The time on the server is ${serverTime}. </P>

<c:if test="${afterLogin == null }">
	<p><a href="regi"> [ REGISTRATION ] </a></p>
	<P><a href="login"> [ LOG - IN ] </a></P>
</c:if>
<c:if test="${afterLogin != null }">
	<p><a href="logout"> [ LOG - OUT ]</a></p>
</c:if>

<p><a href="./goBbs"> [ GO TO BBS ] </a>
<div id="map" style="width:500px;height:400px;"></div>
</body>
</html>
