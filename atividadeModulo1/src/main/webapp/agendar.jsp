<%@page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@page isELIgnored="false"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Agendar Consulta</title>
        <link href="../css/cliente.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>
    	<header class="cabecalho">
            <h3 class="cabecalho__titulo">LifeCare</h3>
            <a class="cabecalho__link" href="${pageContext.request.contextPath}/cliente/">Voltar</a>
        </header>
        <div class="corpo">
        	<section class="conteudo_tabelas">
        		<c:choose>
					<c:when test="${idprest != 0 || idcliente != 0}">
						<form class="conteudo__form" action="inserir" method="post">
							<h1>Selecione a data para a consulta com:</h1>
        					<p>${prestador.nome} <br> ${prestador.area} com especialidade em ${prestador.especialidade}</p><br>
							
							<input type="hidden" name="idcliente" value="${idcliente}" />
							<input type="hidden" name="idprestador" value="${idprestador}" />
		  					
		  					<label class="conteudo__form-label" for="nascimento">Data da consulta:</label><br>
		                    <input class="conteudo__form-input" type="date" name="data" required/><br/>
		                    
		                    <input type="hidden" name="estado" value="MARCADA" />
		                    
		                    <input class="botao-primario" type="submit" value="Agendar"/>
						</form>
					</c:when>
					<c:otherwise>
						<h1>ERRO</h1>
					</c:otherwise>
				</c:choose>
        	</section>
        </div>
    </body>
</html>