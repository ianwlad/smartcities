<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="tags" tagdir="/WEB-INF/tags"%>

<tags:template title="Lista de endereco">

	<h1>enderecos cadastrados</h1>
	<c:if test="${ not empty msg }">
		<div class="alert alert-success">
			<strong>Successo!</strong> ${msg }
		</div>
	</c:if>
	<table class="table">
		<tr>
			<th>Logradouro</th>
			<th>Numero</th>
			<th>CEP</th>
			<th>Bairro</th>
			<th></th>
		</tr>
		<c:forEach items="${lista }" var="e">
			<tr>
				<td>${e.logradouro }</td>
				<td>${e.numero }</td>
				<td>${e.cep }</td>
				<td>${e.bairro }</td>
				<td><c:url value="/endereco/editar/${e.codigo }" var="link" />
					<a href="${link}" class="btn btn-primary"> <i
						class="fas fa-edit"></i>
				</a> <a href="excluir/${e.codigo}" class="btn btn-danger"> <i
						class="fas fa-trash"></i></a></td>
			</tr>
		</c:forEach>
	</table>

	<!-- Modal -->
	<div class="modal fade" id="excluirModal" tabindex="-1" role="dialog"
		aria-labelledby="exampleModalLabel" aria-hidden="true">
		<div class="modal-dialog" role="document">
			<div class="modal-content">
				<div class="modal-header">
					<h5 class="modal-title" id="exampleModalLabel">Confirmação</h5>
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
				</div>
				<div class="modal-body">Realmente deseja excluir o endereco?</div>
				<div class="modal-footer">
					<c:url value="/endereco/excluir" var="action" />
					<form action="${action }" method="post">
						<input type="hidden" name="codigo" id="codigo">
						<button type="button" class="btn btn-secondary"
							data-dismiss="modal">Cancelar</button>
						<button type="submit" class="btn btn-danger">Excluir</button>
					</form>
				</div>
			</div>
		</div>
	</div>

</tags:template>