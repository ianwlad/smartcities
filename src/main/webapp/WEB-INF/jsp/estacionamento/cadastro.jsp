<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="tags" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<tags:template title="Home">
	<h1>Cadastro de estacionamento</h1>
	<c:if test = "${ not empty msg }">
		<div class="alert alert-success">
			<strong>Successo!</strong>
			${msg }
		</div>
	</c:if>
	<c:url value="/estacionamento/cadastrar" var="action" />
	<form:form action="${action }" method="post" commandName="estacionamento">
		<div class="form-group">
			<form:label path="nome">Nome</form:label>
			<form:input path="nome" cssClass="form-control"/>
		</div>
		<div class="form-group">
			<form:label path="endereco">Endereço</form:label>
			<form:input path="endereco" cssClass="form-control"/>
		</div>
		<div class="form-group">
			<form:label path="vagas">Número de Vagas</form:label>
			<form:input path="vagas" cssClass="form-control"/>
		</div>
		<div class="form-group">
			<form:label path="preco">Preço</form:label>
			<form:input path="preco" cssClass="form-control"/>
		</div>
		<div class="d-flex flex-row-reverse"><input type="submit" value="Cadastrar" class="btn btn-error">
		</div>
	</form:form>
</tags:template>