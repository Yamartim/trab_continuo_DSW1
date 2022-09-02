<%@ page contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page isELIgnored="false"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>LifeCare</title>
        <link href="css/login.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>
        <header class="cabecalho">
            <h3 class="cabecalho__titulo">LifeCare</h3>
            <a class="cabecalho__link" href="${pageContext.request.contextPath}/prestador/listagem">Nossos Profissionais</a>

        </header>
        <div class="corpo">
            <section class="conteudo">
                <form class="conteudo__form" action="index.jsp" method="POST">
                    <label class="conteudo__form-label" for="email">E-mail:</label><br>
                    <input class="conteudo__form-input" type="text" name="email" /><br/>
                    <label class="conteudo__form-label" for="password">Senha:</label><br>
                    <input class="conteudo__form-input" type="password" name="senha" /><br/>
                    <input class="botao-primario" type="submit" name="botaoLogin" value="Entrar" />
                </form>
                <div class="cadastro">
                    <h3 class="subtitulo">Não possue uma conta? Crie sua conta agora mesmo</h3>
                    <div class="botoes">
                        <a href="${pageContext.request.contextPath}/cliente/cadastro"><button class="botao-primario">Cliente</button></a>
                        <a href="${pageContext.request.contextPath}/prestador/cadastro"><button class="botao-primario">Profissional</button></a>
                    </div>
                </div>
            </section>
        </div>
    </body>
</html>
