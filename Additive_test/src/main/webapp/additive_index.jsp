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
<title>additive_index.jsp</title>
<link rel="stylesheet" href="./css/style.css">
</head>
<body class="body-additive-index">
	<%@ include file="header.jsp" %>
	<div class="additive_index_text">
		<h1>添加物検索</h1>
		<form action="search_additive-servlet" method="post">
			検索
			<input type="text" name="search_additive_name">
		</form>
	</div>
	
	<h1 class="result">
		検索結果
	</h1>
	<% if (request.getAttribute("search_result_additiveDTO") != null) { %>
			<% AdditiveDTO searchResultAdditiveDTO =  (AdditiveDTO)request.getAttribute("search_result_additiveDTO");%>
			<%= searchResultAdditiveDTO.additiveId					%><br>
			<%= searchResultAdditiveDTO.additiveCeateStamp			%><br>	
			<%= searchResultAdditiveDTO.additiveName				%><br>
			<%= searchResultAdditiveDTO.additiveDetail %><br>
	<% } %>
	
	<h1>添加物一覧</h1>
	<% if (request.getAttribute("AdditiveDTOAllList") != null){ %>
		<h1>NOT null</h1>
		<% List<AdditiveDTO> additiveDTOList = new ArrayList<>(); %>
		<% additiveDTOList = (List<AdditiveDTO>)request.getAttribute("AdditiveDTOAllList"); %>
		<% for(AdditiveDTO additiveDTO : additiveDTOList) {%>
			<%= additiveDTO.additiveId %>
			<%= additiveDTO.additiveCeateStamp %>
			<%= additiveDTO.additiveName %>
			<a href="additive_show-servlet?additive_name=<%=additiveDTO.additiveName%>">詳細</a>
			<br>
		<% } %>
	<% }else{ %>
		<h1>null</h1>
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