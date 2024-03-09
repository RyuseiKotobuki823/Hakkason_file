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
<link rel="stylesheet" href="./css/style.css">


<meta charset="UTF-8">

<div class="picture">
	<h1 class="header-box1">
		<a href="entrance.jsp">Additive</a>
	</h1>
	<div class="header-box2" >
		<% if ((request.getAttribute("yes_log_in") == null) || ( Integer.parseInt(request.getAttribute("yes_log_in").toString()) == 0) ) {%>
		
			<a id="header-box2-1" href="sign_up.jsp">新規登録</a>
			<a id="header-box2-2" href="log_in.jsp">ログイン</a>
		
		<% }else { %>
			<a href="log_out-servlrt">ログアウト</a>
		<% } %>
	</div>
</div>
<br>

<%-- green messege --%>
<div class="green-messege">
	<% if(request.getAttribute("green_messege") != null) {%>
		<%=  request.getAttribute("green_messege") %>
	<% } %>
</div>
<div>
	<%-- red messege --%>
	<% if(request.getAttribute("red_messege") != null) {%>
		<%=  request.getAttribute("red_messege") %>
	<% } %>
</div>
<br>

