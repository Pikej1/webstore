<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html;charset=utf-8">
		<link rel="stylesheet" href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css">
		<link rel="Shortcut icon" href="https://s-media-cache-ak0.pinimg.com/736x/2a/42/71/2a4271d3af1df4acb58b26d976613330.jpg" />
		<title>Witaj</title>
	</head>
	<body>
		<section>
			<div class="jumbotron">
				<div class="container">
					<img src="https://cdn.macrumors.com/article-new/2015/11/macbook_airs_2015.jpg" />
					<h1> ${greeting} </h1>
					<p> ${tagline} </p>
				</div>
				<div class="container">
					<p>
						<a href="<spring:url value="/products" />" class="btn btndefault">
						<span class="glyphicon-hand-right glyphicon"></span>
						Do zakupów!
						</a>
					</p>
				</div>
			</div>
		</section>
	</body>
</html>
