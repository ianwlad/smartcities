<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="tags" tagdir="/WEB-INF/tags"%>

<tags:template title="Lista de Estacionamento">

	<h1>Estacionamentos cadastrados</h1>
	${msg }
	<table class="table">
		<tr>
			<th>Nome</th>
			<th>Endereço</th>
			<th>Vagas</th>
			<th>Preço</th>
			<th></th>
		</tr>
		<c:forEach items="${lista }" var="e">
			<tr>
				<td>${e.nome }</td>
				<td>${e.endereco }</td>
				<td>${e.vagas }</td>
				<td>${e.preco }</td>
				<td><c:url value="/estacionamento/editar/${e.codigo }"
						var="link" /> <a href="${link}" class="btn btn-primary">Editar</a>
					 <a
					href="excluir/${e.codigo}" class="btn btn-danger">Remover</a>
				</td>
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
				<div class="modal-body">Realmente deseja excluir o
					estacionamento?</div>
				<div class="modal-footer">
					<c:url value="/estacionamento/excluir" var="action" />
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