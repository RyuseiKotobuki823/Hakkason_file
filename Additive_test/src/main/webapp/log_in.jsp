<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="ja">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>ログイン</title>
    <meta name="description" content="text text text">
    <link rel="stylesheet" href="./css/style.css">
</head>
<body class="log_body">
	<%@ include file="header.jsp" %>
    <div class="log_subscribe">
     	<h1>ログイン</h1>
     	<div class="log_text">
	        <form action="log_in-servlet" method="POST">
	            ユーザID<br>
		        <input type="text" name="user_id" placeholder="ユーザID "><br><br>
		        パスワード<br>
		        <input type="password" name="password"  placeholder="パスワード"><br><br>
		        <input type="submit" value="ログイン" >
	        </form>
	 	</div>
	</div>
	
	<%-- 
   	<% if (request.getAttribute("signupMissMessege") != null){ -%>
   		<%=  request.getAttribute("signupMissMessege") %>
   	<% } %> 
    --%>
	
	
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