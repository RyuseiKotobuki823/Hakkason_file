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
<body class="body-item-show">
	<%@ include file="header.jsp" %>
	<h1>商品詳細ページ</h1>
	<% if (request.getAttribute("itemDTO") != null){ %>
		<% ItemDTO itemDTO =  (ItemDTO)request.getAttribute("itemDTO");%>
		
		<%= itemDTO.itemId					%><br>
		<%= itemDTO.itemCreateStamp			%><br>	
		<%= itemDTO.itemName				%><br>
		<%= itemDTO.itemGenreName %><br>
		<% for(String dis : itemDTO.havingAdditiveNames) {%>
			<a href="additive_show-servlet?additive_name=<%=dis%>" ><%= dis %></a>
		<% } %>
		
	<% } %>
	
</body>
<footer>
	<div class="wrapper">
		<p>
			<small>
				&copy; 2024 ハッカソン Additive
			</small>
		</p>
	</div>
</footer>
</html>