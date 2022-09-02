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
        		<form class="conteudo__form" action="insercao" method="POST">
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
        	</section>
        </div>
    </body>
</html>