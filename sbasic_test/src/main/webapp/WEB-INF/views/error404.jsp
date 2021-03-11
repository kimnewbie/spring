<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page isErrorPage="true" %><!-- 에러 넘겨받기. 에러니? 응 에러야 true-->
<% response.setStatus(200); %><!-- 응답은 이렇게 해줄게, 상관없어! 괜찮은 페이지니까 Network>Status:200 -->
<!DOCTYPE html>
<html lang = "ko">
<head>
<meta charset="UTF-8">
<!-- Latest compiled and minified CSS -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">

<!-- jQuery library -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>

<!-- Latest compiled JavaScript -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
<title>Insert title here</title>
</head>	
	<div class="container panel panel-info">
		<h3 class="panel-heading">404 error 페이지</h3>
	</div>
</body>
</html>