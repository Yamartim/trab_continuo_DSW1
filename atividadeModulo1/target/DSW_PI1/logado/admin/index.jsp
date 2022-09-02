<%@ page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page isELIgnored="false"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>LifeCare-Admin</title>
        <link href="../css/admin.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>
    	<header class="cabecalho">
            <h3 class="cabecalho__titulo">LifeCare</h3>
            <a class="cabecalho__link" href="${pageContext.request.contextPath}/cliente/gerenciar">Gerenciar Clientes</a>
            <a class="cabecalho__link" href="${pageContext.request.contextPath}/prestador/gerenciar">Gerenciar Profissionais</a>
            <a class="cabecalho__link" href="${pageContext.request.contextPath}/logout.jsp">Sair</a>
        </header>
        <div class="corpo">
        	<section>
        		<h1>Página do Administrador</h1>
        		<p>Olá, ${sessionScope.usuarioLogado.nome}! Aqui você encontra todas as ferramentas para administrar seu sistema!</p>
        	</section>
        </div>
    </body>
</html>