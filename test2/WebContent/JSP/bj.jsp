<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:useBean id="bjVO" class="BJVO.BJVO" scope="page"></jsp:useBean>
<jsp:useBean id="bjDAO" class="BJDAO.DAO" scope="page"></jsp:useBean>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>BJ</title>
</head>
<body>
확인용<br>
<%ArrayList<BJVO.BJVO> userDeck = new ArrayList<>();
ArrayList<BJVO.BJVO> dealerDeck = new ArrayList<>();%>
<% BJVO.BJVO vo = bjDAO.drawCard(); %>
<%=vo%>
<% vo = bjDAO.drawCard(); %>
<%=vo%>
<% vo = bjDAO.drawCard(); %>
<%=vo%>
</body>
</html>