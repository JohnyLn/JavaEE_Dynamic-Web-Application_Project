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
			method="post" id="formWrapper">
			<div style="text-align: center; margin-top: -10px;">
				<img src="https://www.leonard-de-vinci.net/images/aldv-ilv-b.png">
			</div>
			<div id="verif_acces" class="hide">
				<div class="progress progress-striped progress-deep active"
					style="margin: 0px;">
					<div class="bar" style="width: 100%;">Vérification des accès</div>
				</div>
				<div class="verif_acces-arrow-border"></div>
				<div class="verif_acces-arrow"></div>
			</div>
			<div class="col-xs-6" id="identifiant">
				<input id="login" name="username" type="text"
					class="input-block-level" placeholder="Identifiant" >
			</div>
			<div class="col-xs-6" id="password">
				<input id="pass" name="password" type="password"
					class="input-block-level" placeholder="Mot de passe">
			</div>
			<div class="row-fluid">
				<input type="submit" value="Suivant" id="btn_next"
					class="btn btn-primary pull-right span6" />
			</div>
		</form>
		<!-- BEGIN FOOTER -->
		<div class="form-footer-copyright">
			ALV Online - <small>2019 © Léonard de Vinci</small> <br>
			<small>Dynamic Web Application</small><br> Xavier BOUVET - Johny LIN<br><small> ESILV A4 IBO 2</small>

		</div>
		<!-- END FOOTER -->
	</div>
</body>
</html>
