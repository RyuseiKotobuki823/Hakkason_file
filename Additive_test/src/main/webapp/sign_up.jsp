<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="ja">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>新規登録</title>
    <meta name="description" content="text text text">
    <link rel="stylesheet" href="./css/style.css">
</head>
<body class="sign_body">
	<%@ include file="header.jsp" %>
	<div class="cartain" >
	    <div class="sign_subscribe">
	        <h1>新規登録</h1>
	        <div class="input_subscribe">
			    <form action="sign_up-servlet" method="POST">
			    		氏名<br>
			            <input type="text" 		name="user_name"	 	placeholder="名前"><br>
				        
				        ユーザID<br>
				        <input type="text" 		name="user_flont_id" 	placeholder="ユーザID"><br>
				        
				        パスワード<br>
				        <input type="password" name="user_password"	placeholder="パスワード"><br><br>
				        
				        <input type="submit" value="新規登録" >
			    </form>
	    	</div>
		</div>
	</div>

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