<%@page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@page isELIgnored="false"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
    <head>
        <title>Gerenciar Profissionais</title>
        <link href="../css/cliente.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>
    	<%
			String contextPath = request.getContextPath().replace("/", "");
		%>
    	<header class="cabecalho">
            <h3 class="cabecalho__titulo">LifeCare</h3>
            <h4>Gerenciar Profissionais</h4>
            <a class="cabecalho__link" href="${pageContext.request.contextPath}/prestador/editar?id=0">Adicionar novo</a>
            <a class="cabecalho__link" href="${pageContext.request.contextPath}/admin/">Voltar</a>
        </header>
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
							<td><a class="botao-primario" href="/<%= contextPath%>/prestador/editar?id=${prestador.id}">Editar</a></td>
							<td><a class="botao-primario" href="/<%= contextPath%>/prestador/remover?id=${prestador.id}">Remover</a></td>
						</tr>
					</c:forEach>
				</table>
        	</section>
        </div>
    </body>
</html>