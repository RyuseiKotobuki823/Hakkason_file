<%@ page language="java" contentType="text/html; charset=UTF-8"   pageEncoding="UTF-8"%>

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
<title>item_index.jsp</title>
<link rel="stylesheet" href="./css/style.css">
</head>
<body class="body-item-index">
	<%@ include file="header.jsp" %>
	<div class="item-index-text">
		<h1>商品検索</h1>
			<form action="search_item-servlet" method="post">
				検索
				<input type="text" name="search-item-name">
			</form>
	</div>
	<div>
		<h1>検索結果</h1>
		<% if (request.getAttribute("search_result_itemDTO") != null) { %>
			<% ItemDTO searchResultItemDTO =  (ItemDTO)request.getAttribute("search_result_itemDTO");%>
			<%= searchResultItemDTO.itemId					%>
			<%= searchResultItemDTO.itemCreateStamp			%>
			<%= searchResultItemDTO.itemName				%>
			<%= searchResultItemDTO.itemGenreName %>
			<% for(String dis : searchResultItemDTO.havingAdditiveNames) {%>
				<a href="additive_show-servlet?additive_name=<%=dis%>" ><%= dis %></a>
			<% } %>
		<% } %>
	
	</div>
	
	<h1>商品一覧</h1>
	<table>
		<tr>
			<th>商品ID</th>
			<th>レコード登録日時</th>
			<th>商品名</th>
			<th>商品ジャンル</th>
			<th>詳細ページへのリンク</th>
		</tr>
		<% if (request.getAttribute("itemDTOAll") != null){ %>
			
				<% List<ItemDTO> itemDTOList = new ArrayList<>();%>
				<% itemDTOList =  (List<ItemDTO>)request.getAttribute("itemDTOAll"); %>
				<% for (ItemDTO itemDTO : itemDTOList){ %>
				<tr>
					<td><%= itemDTO.itemId					%></td>
					<td><%= itemDTO.itemCreateStamp			%></td>
					<td><%= itemDTO.itemName				%></td>
					<td><%= itemDTO.itemGenreName				%></td>
					<td><a href="item_show-servlet?item_id=<%= itemDTO.itemId %>">詳細</a></td>
				</tr>
				<% } %>
			
			</table>
			<h1>NOT null</h1>
		<% }else{ %>
			<h1>null</h1>
		<% } %>
	
	
	<h1>検索結果</h1>
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