<%-- Essa paǵina será a página após o login do cliente, adm ou prestador 
	Esse código não é util
	O fluxo de login será controlado pelo IndexController e a page inicial do sistema será login.jsp
	Seguindo exemplo de login do professor.
--%>

<%@ page import="br.ufscar.dc.dsw.domain.BaseUser" %>
<%
String email = request.getParameter("usuario");
String senha = request.getParameter("senha");
if(senha.equals(nomeLogin)) {
    User usuario = new User();
    usuario.setNome("Steve Jobs");
    usuario.setNomeLogin(nomeLogin);
    usuario.setSenha(senha);
    session.setAttribute("usuarioLogado", usuario);
%>
<jsp:forward page="principal.jsp" />
<% }
else { %>
<jsp:forward page="index.jsp" />
<% } %>
