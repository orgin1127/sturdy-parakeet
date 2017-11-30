<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.Calendar"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>JSP1-17.11.30</title>
<style>
/* CSS 주석 */
</style>
<script>
//JAVA SCRIPT 주석
/* JAVA SCRIPT 주석 */
function calc() {
	var number1 = document.getElementById('num1');
	if (isNaN(parseInt(number1.value))) {
		alert('숫자를 입력하여 주세요');
		return false;
	}
	var number2 = document.getElementById('num2');
	if (isNaN(parseInt(number2.value))) {
		alert('숫자를 입력하여 주세요');
		return false;
	}
	
	var number3 = document.getElementById('num3');
	number3.value = parseInt(number1.value) + parseInt(number2.value);
	
}
</script>
</head>
<body>
<!-- HTML 주석 -->
<%-- JSP 주석 (JSP->JAVA 컴파일 과정에서 없어짐) --%>
<%	//<-java 코드 사용 표시 기호, 이걸 쓰고 그 안에 java 코딩 해야함
	//JAVA 주석 (JAVA -> CLASS 컴파일 과정에서 없어짐)
	/* JAVA 주석 (JAVA -> CLASS 컴파일 과정에서 없어짐) */
	
	int a = 1;
	int b = a * 2;
%>
	b = <%= b %><br>
<form>
	<% Calendar c = Calendar.getInstance();
	int year = c.get(Calendar.YEAR);
	int month = c.get(Calendar.MONTH); 
	int today = c.get(Calendar.DATE); %>
	* 생년월일 : &nbsp;
	<select name="year" id="year">
		<% for (int i=1900; i<=year; i++) { %>
			<% if (i==year) { %>
				<option value="<%=i%>" selected="selected"><%=i %></option>
			<% } else { %>
				<option value="<%=i%>"><%=i %></option>
			<% } %>
		<% } %>
	</select>년
	&nbsp;
	<select name="month" id="month">
		<% for (int i = 1; i <=12; i++) { %>
			<% if (i==month+1) { %>
				<option value="<%=i %>" selected="selected"><%=i %></option>
			<% } else { %>
				<option value="<%=i %>"><%=i %></option>
			<% } %>
		<% } %>
	</select>월
	&nbsp;
	<select name="day" id="day">
		<% for (int i = 1; i <=31; i++) { %>
			<% if (i==today) { %>
				<option value="<%=i %>" selected="selected"><%=i %></option>
			<% } else { %>
				<option value="<%=i %>"><%=i %></option>
			<% } %>
		 <% } %>
	</select>일
<br>
	<h2>* 구구단 3단</h2>
<% 
int three = 3; 
int total = 0;
for (int i = 1; i<=9; i++) { %>
		<% total = i*three; %> 
		<%=three %> * <%=i %> = <%=  total%><br>
<% } %>
<br>
<%
	ArrayList<String> list = new ArrayList<>();
	list.add("스포츠");
	list.add("음악");
	list.add("IT");
%>

	* 관심분야 선택 : 
	<% for(String str : list) { %>
		<input type="checkbox" name="fav"><%=str %>
	<% } %>


<%
	String[] strList = {"학생", "회사원", "프로그래머", "사축", "백수"};
%>
<br><br>
	* 직업 선택 : 
	<% for(int i=0; i<strList.length; i++) { %>
		<input type="radio" name="job"><%=strList[i] %>
	<% } %>
<br><br>
	*계산 : 
<!--  <select id="num1">
	<option value="1">1</option>
	<option value="2">2</option>
</select>
<input type="button" value="+">
<select id="num2">
	<option value="1">1</option>
	<option value="2">2</option>
</select>-->
숫자 1 <input type="text" id="num1">
숫자 2 <input type="text" id="num2">
<input type="button" value="=" onclick="calc()">
<input type="text" id="num3">


</form>
</body>
</html>