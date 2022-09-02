<%@ page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page isELIgnored="false"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>LifeCare-Cliente</title>
        <link href="../css/cliente.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>
    	<%
			String contextPath = request.getContextPath().replace("/", "");
		%>
    	<header class="cabecalho">
            <h3 class="cabecalho__titulo">LifeCare</h3>
            <a class="cabecalho__link" href="${pageContext.request.contextPath}/prestador/listagem">Nossos Profissionais</a>
            <a class="cabecalho__link" href="${pageContext.request.contextPath}/logout.jsp">Sair</a>
        </header>
        <div class="corpo">
        	<section>
        		<h1>Olá, ${sessionScope.usuarioLogado.nome}.</h1>
        		<c:choose>
					<c:when test="${listaConsulta == null}">
						<p>Você não possui consultas agendadas.</p><br>
					</c:when>
					<c:otherwise>
						<p>Você possui essas consultas agendadas:</p><br>
		        		<section class="conteudo_tabelas">
		        		<table>
							<tr>
								<th>Paciente</th>
								<th>Profissional</th>
								<th>Area</th>
								<th>Especialidade</th>
								<th>Data</th>
								<th>Estado</th>
							</tr>
							<c:forEach var="consulta" items="${requestScope.listaConsulta}">
								<tr>
									<td>${consulta.getCliente().getNome()}</td>
									<td>${consulta.getPrestador().getNome()}</td>
									<td>${consulta.getPrestador().getArea()}</td>
									<td>${consulta.getPrestador().getEspecialidade()}</td>
									<td>${consulta.data}</td>
									<td>${consulta.estado}</td>
									<td><a class="botao-primario" href="/<%= contextPath%>/consulta/cancelar?id=${consulta.id}">Cancelar</a></td>
								</tr>
							</c:forEach>
						</table>
		        		</section>
					</c:otherwise>
				</c:choose>
        	</section>
        </div>
    </body>
</html>