<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="./css/style.css">
</head>
<body class="body-additive-top">
	<%@ include file="header.jsp" %>
	<h1 class="top_additive">
		Top Page!!
	</h1>
	<hr>
	<div class="top_bottom">
		<div class="switch1">
			<a href="item-index-servlet" style="text-decolation: none">商品　から見る</a>
		</div>
		<div class="switch2">
			<a href="additive-index-servlet" style="text-decolation: none">添加物から見る</a>
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