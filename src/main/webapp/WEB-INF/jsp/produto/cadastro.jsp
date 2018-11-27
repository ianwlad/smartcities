<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="tags" tagdir="/WEB-INF/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<tags:template title="Home">
	<h1>Cadastro de produto</h1>
	<c:if test="${ not empty msg }">
		<div class="alert alert-success">
			<strong>Successo!</strong> ${msg }
		</div>
	</c:if>
	<c:url value="/produto/cadastrar" var="action" />
	<form:form action="${action }" method="post" commandName="produto">
		<div class="form-group">
			<form:label path="nomeProduto">Nome do produto</form:label>
			<form:input path="nomeProduto" cssClass="form-control" />
		</div>
		<div class="form-group">
			<form:label path="nomeMarca">Marca do produto</form:label>
			<form:input path="nomeMarca" cssClass="form-control" />
		</div>
		<div class="form-group">
			<form:label path="medida">Medida</form:label>
			<form:input path="medida" cssClass="form-control" />
		</div>
		<div class="form-group">
			<form:label path="preco">Preço</form:label>
			<form:input path="preco" cssClass="form-control" />
		</div>
		<div class="d-flex flex-row-reverse">
			<input type="submit" value="Cadastrar" class="btn btn-error">
		</div>
	</form:form>
</tags:template>