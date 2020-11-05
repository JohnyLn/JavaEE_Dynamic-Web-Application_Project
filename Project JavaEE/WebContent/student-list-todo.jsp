<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="utf-8">
<title>Dynamic Web Application Project</title>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta name="description" content="">
<meta name="author" content="">
<link rel="shortcut icon"
	href="https://www.leonard-de-vinci.net/images/favicon.ico?v1.2.1" />
<link rel="icon" type="image/gif"
	href="https://www.leonard-de-vinci.net/images/favicon.gif?v1.2.1">

<link href="https://www.leonard-de-vinci.net/min/g=general_css?v1.3.6"
	rel="stylesheet">
<link
	href="https://www.leonard-de-vinci.net/assets/plugins/font-awesome-4.7.0/css/font-awesome.css"
	rel="stylesheet">
<link rel="stylesheet" type="text/css"
	href="https://www.leonard-de-vinci.net/assets/plugins/select2/select2.css" />

<style type="text/css">
body {
	padding-top: 40px;
	padding-bottom: 40px;
	background-color: #e9eaed;
}
</style>
</head>
<body>
	<div class="container">

		<form class="form-login" action="RegisterControllerServlet"
			method="get" id="formWrapper">
			<div style="text-align: center; margin-top: -10px;">
				<img src="https://www.leonard-de-vinci.net/images/aldv-ilv-b.png">
			</div>
			<br>
			<div class="form-footer-copyright">Login Success - Student</div>
			<td>Welcome</td>
			<%
				String welcome = (String) request.getAttribute("username");
			%>
			<%=welcome%>
			<div id="content">

				<font size="+2">ToDo List :</font> <br>
				<table>
					<tr>
						<th>Description</th>
					</tr>
					<c:forEach var="tempTodo" items="${TODO_LIST}">
						<tr>
							<td>${tempTodo.descrip}</td>
						</tr>
					</c:forEach>
				</table>
			</div>
			<br> <br>
			<div id="container">

				<div style="clear: both;"></div>
				<div class="row-fluid">
					<input type="submit" value="Back to Login" id="btn_next"
						class="btn btn-primary pull-right span6" />
				</div>
			</div>
			<!-- BEGIN FOOTER -->
			<div class="form-footer-copyright">
				ALV Online - <small>2019 © Léonard de Vinci</small> <small>Dynamic
					Web Application</small><br> Xavier BOUVET - Johny LIN<br>
				<small> ESILV A4 IBO 2</small>
			</div>
			<!-- END FOOTER -->
	</div>
</body>
</html>

