<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="DTO.ItemDTO" %>
<%@ page import="DAO.ItemDAO" %>
<%@ page import="DAO.UserDAO" %>
<%@ page import="DTO.AdditiveDTO" %>
<%@ page import="DTO.ItemDTO" %>
<%@ page import="java.io.IOException" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.List" %>
<%@ page import="javax.servlet.RequestDispatcher" %>
<%@ page import="javax.servlet.ServletException" %>
<%@ page import="javax.servlet.annotation.WebServlet" %>
<%@ page import="javax.servlet.http.HttpServlet" %>
<%@ page import="javax.servlet.http.HttpServletRequest" %>
<%@ page import="javax.servlet.http.HttpServletResponse" %>
<%@ page import="DAO.ItemDAO" %>
<%@ page import="DTO.ItemDTO" %>



<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="./css/style.css">
</head>
<body class="body-additive-show">
	<%@ include file="header.jsp" %>
	<h1 class="additive-show-goods">添加物</h1>
	<% if (request.getAttribute("additiveDTO") != null){ %>
		<% AdditiveDTO additiveDTO = (AdditiveDTO)request.getAttribute("additiveDTO"); %>
		
		<%= additiveDTO.additiveId			%>
		<%= additiveDTO.additiveCeateStamp	%>
		<%= additiveDTO.additiveName		%><br>
		<%= additiveDTO.additiveDetail		%>	
	<% } %>
</body>
</html>