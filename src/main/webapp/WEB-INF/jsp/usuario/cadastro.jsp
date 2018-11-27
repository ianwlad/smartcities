<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="tags" tagdir="/WEB-INF/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<tags:template title="Home">
	<h1>Cadastro de usuario</h1>
	<c:if test="${ not empty msg }">
		<div class="alert alert-success">
			<strong>Successo!</strong> ${msg }
		</div>
	</c:if>
	<c:url value="/usuario/cadastrar" var="action" />
	<form:form action="${action }" method="post" commandName="usuario">
		<div class="form-group">
			<form:label path="nome">Nome do usuario</form:label>
			<form:input path="nome" cssClass="form-control" />
		</div>
		<div class="form-group">
			<form:label path="email">Email do usuario</form:label>
			<form:input path="email" cssClass="form-control" />
		</div>
		<div class="form-group">
			<form:label path="senha">Senha</form:label>
			<form:input path="senha" cssClass="form-control" />
		</div>
		<div class="d-flex flex-row-reverse">
			<input type="submit" value="cadastrar" class="btn btn-error">
		</div>
	</form:form>
</tags:template>