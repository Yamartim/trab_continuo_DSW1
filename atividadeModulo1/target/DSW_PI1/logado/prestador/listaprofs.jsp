<%@page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@page isELIgnored="false"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
        <title>Lista de Profissionais</title>
        <link href="../css/prestador.css" rel="stylesheet" type="text/css"/>
</head>
<body>
	    <%
			String contextPath = request.getContextPath().replace("/", "");
		%>
    	<header class="cabecalho">
            <h3 class="cabecalho__titulo">LifeCare</h3>
            <a class="cabecalho__link" href="${pageContext.request.contextPath}/">Voltar</a>
        </header>
        <div class="corpo">
			<table border="1">
				<caption>Nossos Profissionais</caption>
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
						<td><a class="botao-primario" href="#">Agendar</a>
					</tr>
				</c:forEach>
			</table>
		</div>
</body>
</html>