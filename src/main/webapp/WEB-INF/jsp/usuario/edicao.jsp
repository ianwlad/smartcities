<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%><%@ taglib prefix="form"
	uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="tags" tagdir="/WEB-INF/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<tags:template title="Edição de Usuario">
	<h1>Editar o usuario</h1>
	<c:if test="${ not empty msg }">
		<div class="alert alert-success">
			<strong>Successo!</strong> ${msg }
		</div>
	</c:if>
	<c:url value="/usuario/editar" var="action" />
	<form:form action="${action }" method="post" commandName="usuario">
		<form:hidden path="codigo" />
		<div class="form-group">
			<form:label path="email">Email</form:label>
			<form:input path="email" cssClass="form-control" />
		</div>
		<div class="form-group">
			<form:label path="senha">Senha</form:label>
			<form:input path="senha" cssClass="form-control" />
		</div>
		<div class="d-flex flex-row-reverse">
			<input type="submit" value="Cadastrar" class="btn btn-primary">
		</div>
	</form:form>
</tags:template>