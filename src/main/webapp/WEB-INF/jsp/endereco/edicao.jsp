<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%><%@ taglib prefix="form"
	uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="tags" tagdir="/WEB-INF/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<tags:template title="Edição de Endereco">
	<h1>Editar o cadastro</h1>
	<c:if test="${ not empty msg }">
		<div class="alert alert-success">
			<strong>Successo!</strong> ${msg }
		</div>
	</c:if>
	<c:url value="/endereco/editar" var="action" />
	<form:form action="${action }" method="post" commandName="endereco">
		<form:hidden path="codigo" />
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
			<input type="submit" value="Cadastrar" class="btn btn-primary">
		</div>
	</form:form>
</tags:template>