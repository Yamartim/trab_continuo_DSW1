<%@ page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page isELIgnored="false"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>LifeCare-Proffisional</title>
        <link href="../css/prestador.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>
    	<header class="cabecalho">
            <h3 class="cabecalho__titulo">LifeCare</h3>
            <a class="cabecalho__link" href="${pageContext.request.contextPath}/logout.jsp">Sair</a>
        </header>
        <div class="corpo">
        	<section>
        		<h1>Olá, ${sessionScope.usuarioLogado.nome}.</h1>
        		<p>Estas são as consultas agendadas com você:</p> 
        	</section>
        </div>
    </body>
</html>