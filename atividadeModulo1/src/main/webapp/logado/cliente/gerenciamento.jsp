<%@page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@page isELIgnored="false"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
    <head>
        <title>Gerenciar Clientes</title>
        <link href="../css/cliente.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>
    	<%
			String contextPath = request.getContextPath().replace("/", "");
		%>
    	<header class="cabecalho">
            <h3 class="cabecalho__titulo">LifeCare</h3>
            <h4>Gerenciar Clientes</h4>
            <a class="cabecalho__link" href="${pageContext.request.contextPath}/cliente/editar?id=0">Adicionar novo</a>
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
						<th>ADM</th>
						<th>Telefone</th>
						<th>Sexo</th>
						<th>Data Nascimento</th>
					</tr>
					<c:forEach var="cliente" items="${requestScope.listaClientes}">
						<tr>
							<td>${cliente.id}</td>
							<td>${cliente.email}</td>
							<td>${cliente.nome}</td>
							<td>${cliente.CPF}</td>
							<td>${cliente.adm}</td>
							<td>${cliente.telefone}</td>
							<td>${cliente.sexo}</td>
							<td>${cliente.data_nascimento}</td>
							<td><a class="botao-primario" href="/<%= contextPath%>/cliente/editar?id=${cliente.id}">Editar</a></td>
							<td><a class="botao-primario" href="/<%= contextPath%>/cliente/remover?id=${cliente.id}">Remover</a></td>
						</tr>
					</c:forEach>
			</table>
        	</section>
        </div>
    </body>
</html>