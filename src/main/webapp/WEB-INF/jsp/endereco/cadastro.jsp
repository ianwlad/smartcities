<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="tags" tagdir="/WEB-INF/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<tags:template title="Home">
	<h1>Cadastro de endereco</h1>
	<c:if test="${ not empty msg }">
		<div class="alert alert-success">
			<strong>Successo!</strong> ${msg }
		</div>
	</c:if>
	<c:url value="/endereco/cadastrar" var="action" />
	<form:form action="${action }" method="post" commandName="endereco">
		<div class="form-group">
			<form:label path="logradouro">Logradouro</form:label>
			<form:input path="logradouro" cssClass="form-control" />
		</div>
		<div class="form-group">
			<form:label path="numero">Numero</form:label>
			<form:input path="numero" cssClass="form-control" />
		</div>
		<div class="form-group">
			<form:label path="cep">CEP</form:label>
			<form:input path="cep" cssClass="form-control" />
		</div>
		<div class="form-group">
			<form:label path="bairro">Bairro</form:label>
			<form:input path="bairro" cssClass="form-control" />
		</div>
		<div class="d-flex flex-row-reverse">
			<input type="submit" value="Cadastrar" class="btn btn-error">
		</div>
	</form:form>
</tags:template>