<%@page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@page isELIgnored="false"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<title>Lista de Profissionais</title>
<link href="../css/prestador.css" rel="stylesheet" type="text/css" />
</head>
<body>
	<%
			String contextPath = request.getContextPath().replace("/", "");
		%>
	<header class="cabecalho">
		<h3 class="cabecalho__titulo">LifeCare</h3>
		<h4>Nossos Profissionais</h4>
		<c:choose>
			<c:when test="${sessionScope.usuarioLogado.adm != null}">
				<a class="cabecalho__link" href="/<%= contextPath%>/cliente/login">Voltar</a>
			</c:when>
			<c:otherwise>
				<a class="cabecalho__link" href="/<%= contextPath%>/">Voltar</a>
			</c:otherwise>
		</c:choose>
	</header>
	<div class="corpo">
		<section class="conteudo">
			<form class="conteudo__form" action="listagem" method="POST">
				<label class="conteudo__form-label" for="filtroarea">Filtre por Area:</label> 
					<select class="conteudo__form-filtro" name="filtroarea">
						<option value="nenhuma">Nenhuma</option>
						<c:forEach items="${listaArea}" var="area">
							<option value="${area}" ${filtroarea==area ? 'selected' : '' }>${area}</option>
						</c:forEach>
					</select><br>
					
					<label class="conteudo__form-label" for="filtroespec">Filtre por Especialidade:</label> 
					<select class="conteudo__form-filtro" name="filtroespec">
						<option value="nenhuma">Nenhuma</option>
						<c:forEach items="${listaEspec}" var="espec">
							<option value="${espec}" ${filtroespec==espec ? 'selected' : '' }>${espec}</option>
						</c:forEach>
					</select><br>
				<input class="botao-primario" type="submit" value="Filtrar" />
			</form>
		</section>
	</div>
	<div class="corpo">
		<section class="conteudo_tabelas">
			<table>
				<tr>
					<th>ID</th>
					<th>Email</th>
					<th>Nome</th>
					<th>CPF</th>
					<th>Area</th>
					<th>Especialidade</th>
				</tr>
				<c:forEach var="prestador" items="${requestScope.listaPrestadores}">
					<tr>
						<td>${prestador.id}</td>
						<td>${prestador.email}</td>
						<td>${prestador.nome}</td>
						<td>${prestador.CPF}</td>
						<td>${prestador.area}</td>
						<td>${prestador.especialidade}</td>
						<c:if test="${sessionScope.usuarioLogado.adm != null}">
							<td><a class="botao-primario" href="/<%= contextPath%>/consulta/agendar?idcliente=${sessionScope.usuarioLogado.id}&idprestador=${prestador.id}">Agendar</a>
						</c:if>
					</tr>

				</c:forEach>
			</table>
		</section>
	</div>

</body>
</html>