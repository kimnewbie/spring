<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="utf-8">
	<title>Home</title>
<!-- Latest compiled and minified CSS -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">

<!-- jQuery library -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>

<!-- Latest compiled JavaScript -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>	
</head>
<body>
 
	<div class="container panel panel-info">
		<h3 class="panel-heading">LOGIN</h3>
		<pre>
		1. action = "/login"  고정
		2. method = "post"    고정
		3. name값 고정  name="username"  /   name="password" 
		4. 보안 csrf :   input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"  설정 
		</pre>
		 <form action ="${pageContext.request.contextPath}/login" method="post">
        	<fieldset>
            <legend>로그인</legend>
            <div class="form-group">
            	<label for="username">ID</label>
            	<input type="text"  name="username" id="username" placeholder="아이디를 입력해주세요."  class="form-control">
            </div>
            <div class="form-group">
            	<label for="password">PASSWORD</label>
            	<input type="password" name="password" id="password" placeholder="비밀번호를 입력해주세요." class="form-control">
            </div>	
            <div class="form-group">
            	<input type="submit" value="로그인"  class="btn btn-danger">
            	<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
            </div>
        	</fieldset>
   		 </form>
	</div>
</body>
</html>
 