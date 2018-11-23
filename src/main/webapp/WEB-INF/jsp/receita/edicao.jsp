<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%><%@ taglib prefix="form"
	uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="tags" tagdir="/WEB-INF/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<tags:template title="Edição de Receita">
	<h1>Editar a receita</h1>
	<c:if test="${ not empty msg }">
		<div class="alert alert-success">
			<strong>Successo!</strong> ${msg }
		</div>
	</c:if>
	<c:url value="/receita/editar" var="action" />
	<form:form action="${action }" method="post" commandName="receita">
		<form:hidden path="codigo" />
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
		<div class="d-flex flex-row-reverse">
			<input type="submit" value="Cadastrar" class="btn btn-primary">
		</div>
	</form:form>
</tags:template>