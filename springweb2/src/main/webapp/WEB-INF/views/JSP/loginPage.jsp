<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>[ L O G I N ]</title>
</head>
<body>
<h1>L O G I N</h1>
<form action="login" method="post">
	<table class="testTable">
		<tr class="tableHead">
			<th class="tHead">ID</th>
			<th class="tHead">PASSWORD</th>
			<th class="tHead">NAME</th>
		</tr>
		<tr class="tableContent">
			<td class="tContent"><input type="text" id="id" name="id"></td>
			<td class="tContent"><input type="password" id="password" name="password"></td>
			<td class="tContent"><input type="text" id="name" name="name"></td>
		</tr>
		<tr class="tableFooter">
			<td colspan="3" class="tFooter">
				<input type="submit" value="전송">
			</td>
		</tr>
	</table>
</form>
</body>
</html>