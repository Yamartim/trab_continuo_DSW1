<%@ page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page isELIgnored="false"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Cadastro Cliente</title>
        <link href="../css/cliente.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>
    	<header class="cabecalho">
            <h3 class="cabecalho__titulo">LifeCare</h3>
            <a class="cabecalho__link" href="${pageContext.request.contextPath}/">Voltar</a>
        </header>
        <div class="corpo">
        	<section class="conteudo">
        		<c:choose>
					<c:when test="${cliente != null}">
						<form action="atualizacao" method="post">
						
							<input type="hidden" name="id" value="${cliente.id}" />
						
							<label class="conteudo__form-label" for="email">E-mail:</label><br>
		                    <input class="conteudo__form-input" type="email" name="email" value="${cliente.email}" required/><br/>
		                    
		                    <label class="conteudo__form-label" for="password">Senha:</label><br>
		                    <input class="conteudo__form-input" type="password" name="senha" value="${cliente.senha}" required/><br/>
		                    
		                    <label class="conteudo__form-label" for="nome">Nome:</label><br>
		                    <input class="conteudo__form-input" type="text" name="nome" value="${cliente.nome}" required/><br/>
		                    
		                    <label class="conteudo__form-label" for="CPF">CPF:</label><br>
		                    <input class="conteudo__form-input" type="text" name="CPF" value="${cliente.CPF}" required/><br/>
		                    
		                    <label class="conteudo__form-label" for="adm">ADM:</label><br>
		                    <input type="number" name="adm" value="${cliente.adm}" required/>
		                    
		                    <label class="conteudo__form-label" for="telefone">Telefone:</label><br>
		                    <input class="conteudo__form-input" type="tel" name="telefone" value="${cliente.telefone}" required/><br/>
		                    
		                    <label class="conteudo__form-label" for="sexo">Sexo:</label><br>
		                    <select class="conteudo__form-input" name="sexo" value="${cliente.sexo}" required>
							    <option value="Masculino">Masculino</option>
							    <option value="Feminino">Feminino</option>
		  					</select><br>
		  					
		  					<label class="conteudo__form-label" for="nascimento">Data de Nascimento:</label><br>
		                    <input class="conteudo__form-input" type="date" name="nascimento" value="${cliente.data_nascimento}" required/><br/>
		                    
		                    <input class="botao-primario" type="submit" value="Atualizar"/>
						</form>
					</c:when>
					<c:otherwise>
						<form action="insercao" method="post">
							<label class="conteudo__form-label" for="email">E-mail:</label><br>
		                    <input class="conteudo__form-input" type="email" name="email" required/><br/>
		                    
		                    <label class="conteudo__form-label" for="password">Senha:</label><br>
		                    <input class="conteudo__form-input" type="password" name="senha" required/><br/>
		                    
		                    <label class="conteudo__form-label" for="nome">Nome:</label><br>
		                    <input class="conteudo__form-input" type="text" name="nome" required/><br/>
		                    
		                    <label class="conteudo__form-label" for="CPF">CPF:</label><br>
		                    <input class="conteudo__form-input" type="text" name="CPF" required/><br/>
		                    
		                    <input type="hidden" name="adm" value="0"/>
		                    
		                    <label class="conteudo__form-label" for="telefone">Telefone:</label><br>
		                    <input class="conteudo__form-input" type="tel" name="telefone" required/><br/>
		                    
		                    <label class="conteudo__form-label" for="sexo">Sexo:</label><br>
		                    <select class="conteudo__form-input" name="sexo" required>
							    <option value="Masculino">Masculino</option>
							    <option value="Feminino">Feminino</option>
		  					</select><br>
		  					
		  					<label class="conteudo__form-label" for="nascimento">Data de Nascimento:</label><br>
		                    <input class="conteudo__form-input" type="date" name="nascimento" required/><br/>
		                    
		                    <input class="botao-primario" type="submit" value="Cadastrar" />
						</form>
					</c:otherwise>
				</c:choose>
        	</section>
        </div>
    </body>
</html>