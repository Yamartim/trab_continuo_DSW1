<%@page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@page isELIgnored="false"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Editar Prestador</title>
        <link href="../css/cliente.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>
    	<header class="cabecalho">
            <h3 class="cabecalho__titulo">LifeCare</h3>
            <a class="cabecalho__link" href="${pageContext.request.contextPath}/prestador/gerenciar">Voltar</a>
        </header>
        <div class="corpo">
        	<section class="conteudo_tabelas">
        		<c:choose>
					<c:when test="${prestador != null}">
						<form class="conteudo__form" action="atualizacao" method="post">
							
							<input type="hidden" name="id" value="${prestador.id}" />
						
							<label class="conteudo__form-label" for="email">E-mail:</label><br>
		                    <input class="conteudo__form-input" type="email" name="email" value="${prestador.email}" required/><br/>
		                    
		                    <label class="conteudo__form-label" for="password">Senha:</label><br>
		                    <input class="conteudo__form-input" type="password" name="senha" value="${prestador.senha}" required/><br/>
		                    
		                    <label class="conteudo__form-label" for="nome">Nome:</label><br>
		                    <input class="conteudo__form-input" type="text" name="nome" value="${prestador.nome}" required/><br/>
		                    
		                    <label class="conteudo__form-label" for="CPF">CPF:</label><br>
		                    <input class="conteudo__form-input" type="text" name="CPF" value="${prestador.CPF}" required/><br/>
		                    
		                    <label class="conteudo__form-label" for="area">Area:</label><br>
		                    <input class="conteudo__form-input" type="text" name="area" value="${prestador.area}" required/><br/>
		                    
		                    <label class="conteudo__form-label" for="especialidade">Especialidade:</label><br>
		                    <input class="conteudo__form-input" type="text" name="especialidade" value="${prestador.especialidade}" required/><br/>
		                   	
		                    <input class="botao-primario" type="submit" value="Atualizar"/>
						</form>
					</c:when>
					<c:otherwise>
						<form class="conteudo__form" action="insercaoadm" method="post">
							<label class="conteudo__form-label" for="email">E-mail:</label><br>
		                    <input class="conteudo__form-input" type="email" name="email" required/><br/>
		                    
		                    <label class="conteudo__form-label" for="password">Senha:</label><br>
		                    <input class="conteudo__form-input" type="password" name="senha" required/><br/>
		                    
		                    <label class="conteudo__form-label" for="nome">Nome:</label><br>
		                    <input class="conteudo__form-input" type="text" name="nome" required/><br/>
		                    
		                    <label class="conteudo__form-label" for="CPF">CPF:</label><br>
		                    <input class="conteudo__form-input" type="text" name="CPF" required/><br/>
		                    
		                    <label class="conteudo__form-label" for="area">Area:</label><br>
		                    <input class="conteudo__form-input" type="text" name="area" required/><br/>
		                    
		                    <label class="conteudo__form-label" for="especialidade">Especialidade:</label><br>
		                    <input class="conteudo__form-input" type="text" name="especialidade" required/><br/>
		                    
		                    <input class="botao-primario" type="submit" value="Cadastrar" />
						</form>
					</c:otherwise>
				</c:choose>
        	</section>
        </div>
    </body>
</html>