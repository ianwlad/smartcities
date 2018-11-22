<%@ tag language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ attribute name="title" required="true"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>${title }</title>
<link rel="stylesheet" type="text/css"
	href="<c:url value="/resources/css/bootstrap.min.css"/>">
<link rel="stylesheet" type="text/css"
	href="<c:url value="/resources/css/stylesheet.css"/>">
</head>
<link rel="stylesheet"
	href="https://use.fontawesome.com/releases/v5.3.1/css/all.css" />
<body>
	<nav class="navbar navbar-expand-lg navbar-light bg-light">
		<a class="navbar-brand" href='<c:url value="/"/>'> <img
			src="<c:url value="/resources/img/s_logo_solid_w.png"/>"
			class="d-inline-block align-top" alt="">
			<h4 class="navbar-text">Spatula</h4>
		</a>
		<button class="navbar-toggler" type="button" data-toggle="collapse"
			data-target="#navbarSupportedContent"
			aria-controls="navbarSupportedContent" aria-expanded="false"
			aria-label="Toggle navigation">
			<i class="fas fa-bars"></i>
		</button>

		<div class="collapse navbar-collapse" id="navbarSupportedContent">
			<ul class="navbar-nav mr-auto">
				<li class="nav-item active"><a class="nav-link"
					href='<c:url value="/login"/>'>Log-in</a></li>
				<li class="nav-item dropdown"><a
					class="nav-link dropdown-toggle" href="#" id="navbarDropdown"
					role="button" data-toggle="dropdown" aria-haspopup="true"
					aria-expanded="false"> Receitas </a>
					<div class="dropdown-menu" aria-labelledby="navbarDropdown">
						<a class="dropdown-item" href='#'>Gluten-free</a> <a
							class="dropdown-item" href='#'>Opções veganas</a>
					</div></li>
				<li class="nav-item dropdown"><a
					class="nav-link dropdown-toggle" href="#" id="navbarDropdown"
					role="button" data-toggle="dropdown" aria-haspopup="true"
					aria-expanded="false"> Estacionamento </a>
					<div class="dropdown-menu" aria-labelledby="navbarDropdown">
						<a class="dropdown-item"
							href='<c:url value="/estacionamento/cadastrar"/>'>Cadastrar</a> <a
							class="dropdown-item"
							href='<c:url value="/estacionamento/listar"/>'>Listar</a>
					</div></li>
				<li class="nav-item dropdown"><a
					class="nav-link dropdown-toggle" href="#" id="navbarDropdown"
					role="button" data-toggle="dropdown" aria-haspopup="true"
					aria-expanded="false"> Cadastrar </a>
					<div class="dropdown-menu" aria-labelledby="navbarDropdown">
						<a class="dropdown-item"
							href='<c:url value="/produto/cadastrar"/>'>Produto</a> 
						<a class="dropdown-item" 
							href='<c:url value="/usuario/cadastrar"/>'>Usuario</a>
					</div></li>
				<li class="nav-item dropdown"><a
					class="nav-link dropdown-toggle" href="#" id="navbarDropdown"
					role="button" data-toggle="dropdown" aria-haspopup="true"
					aria-expanded="false"> Listar </a>
					<div class="dropdown-menu" aria-labelledby="navbarDropdown">
						<a class="dropdown-item" href='<c:url value="/produto/listar"/>'>Produto</a>
						<a class="dropdown-item" href='<c:url value="/usuario/listar"/>'>Usuario</a>
					</div></li>
			</ul>
			<form class="form-inline">
				<input class="form-control mr-sm-2" type="search"
					placeholder="Procurar prato">
				<button class="btn btn-outline-success my-2 my-sm-0" type="submit">
					<i class="fas fa-search"></i>
				</button>
			</form>
		</div>
	</nav>
	<div class="container">
		<jsp:doBody />
	</div>
	<script src="<c:url value="/resources/js/jquery-3.3.1.min.js"/>"></script>
	<script src="<c:url value="/resources/js/bootstrap.min.js"/>"></script>
</body>
</html>