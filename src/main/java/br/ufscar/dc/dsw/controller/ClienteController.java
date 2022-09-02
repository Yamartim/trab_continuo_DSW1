package br.ufscar.dc.dsw.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.ufscar.dc.dsw.dao.ClienteDAO;
import br.ufscar.dc.dsw.dao.ConsultaDAO;
import br.ufscar.dc.dsw.domain.Cliente;
import br.ufscar.dc.dsw.domain.Consulta;


@WebServlet(urlPatterns = "/cliente/*")
public class ClienteController extends HttpServlet {

    private static final long serialVersionUID = 1L;
    
    public ClienteDAO dao;
    public ConsultaDAO daoconsulta;
    
    public void init() {
        dao = new ClienteDAO();
        daoconsulta = new ConsultaDAO();
        
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	
    	String action = request.getPathInfo();
        if (action == null) {
            action = "";
        }

        try {
            switch (action) {
                case "/cadastro":
                    formCadastro(request, response);
                    break;
                case "/insercao":
                    insere(request, response);
                    break;
                case "/insercaoadm":
                	insereADM(request, response);
                    break;
                case "/remover":
                    remove(request, response);
                    break;
                case "/editar":
                    formEdicao(request, response);
                    break;
                case "/atualizacao":
                    atualiza(request, response);
                    break;
                case "/gerenciar":
                    gerencia(request, response);
                    break;
                default:
                    login(request, response);
                    break;
            }
        } catch (RuntimeException | IOException | ServletException e) {
            throw new ServletException(e);
        }
    	
    }
    
    private void formCadastro(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("/logado/cliente/cadastro.jsp");
        dispatcher.forward(request, response);
    }
    
    private void formEdicao(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    	
    	Long id = Long.parseLong(request.getParameter("id"));
    	if(id != 0) {
    		Cliente cliente = dao.get(id);
            request.setAttribute("cliente", cliente);
    	}else {
    		Cliente cliente = null;
    		request.setAttribute("cliente", cliente);
    	}
        
        RequestDispatcher dispatcher = request.getRequestDispatcher("/logado/cliente/edicao.jsp");
        dispatcher.forward(request, response);
    }
    
    private void atualiza(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");

        Long id = Long.parseLong(request.getParameter("id"));
        String email = request.getParameter("email");
        String senha = request.getParameter("senha");
        String nome = request.getParameter("nome");
        String CPF = request.getParameter("CPF");
        Integer adm = Integer.parseInt(request.getParameter("adm"));
    	String telefone = request.getParameter("telefone");
        String sexo = request.getParameter("sexo");
        String nascimento = request.getParameter("nascimento");
        
        Cliente cliente = new Cliente(id, email, senha, nome, CPF, adm, telefone, sexo, nascimento);

        dao.update(cliente);
        response.sendRedirect("gerenciar");
    }
    
    private void insere(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        
        String email = request.getParameter("email");
        String senha = request.getParameter("senha");
        String nome = request.getParameter("nome");
        String CPF = request.getParameter("CPF");
        Integer adm = Integer.parseInt(request.getParameter("adm"));
    	String telefone = request.getParameter("telefone");
        String sexo = request.getParameter("sexo");
        String nascimento = request.getParameter("nascimento");
        
        Cliente cliente = new Cliente(null, email, senha, nome, CPF, adm, telefone, sexo, nascimento);
        dao.insert(cliente);
        response.sendRedirect("login");
    }
    
    private void insereADM(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        
        String email = request.getParameter("email");
        String senha = request.getParameter("senha");
        String nome = request.getParameter("nome");
        String CPF = request.getParameter("CPF");
        Integer adm = Integer.parseInt(request.getParameter("adm"));
    	String telefone = request.getParameter("telefone");
        String sexo = request.getParameter("sexo");
        String nascimento = request.getParameter("nascimento");
        
        Cliente cliente = new Cliente(null, email, senha, nome, CPF, adm, telefone, sexo, nascimento);
        dao.insert(cliente);
        response.sendRedirect("gerenciar");
    }
    
    private void remove(HttpServletRequest request, HttpServletResponse response)
            throws IOException {
    	
        Long id = Long.parseLong(request.getParameter("id"));
        
        Cliente cliente = new Cliente(id, null, null, null, null, 0, null, null, null);
        dao.delete(cliente);
        response.sendRedirect("gerenciar");
        
    }
    
    private void gerencia(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    	
    	List<Cliente> listaClientes = dao.getAll();
        request.setAttribute("listaClientes", listaClientes);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/logado/cliente/gerenciamento.jsp");
        dispatcher.forward(request, response);
    }
    
    private void login(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    	
    	Cliente usuario = (Cliente) request.getSession().getAttribute("usuarioLogado");
    	
    	if (usuario == null) {
    		response.sendRedirect(request.getContextPath());
    	} else if (usuario.getAdm()== 0) {
    		
    		List<Consulta> listaConsulta = daoconsulta.getAllbyCliente(usuario.getId());
    		
    		request.setAttribute("listaConsulta", listaConsulta);
    		
    		RequestDispatcher dispatcher = request.getRequestDispatcher("/logado/cliente/index.jsp");
            dispatcher.forward(request, response);
    	} else {
    		RequestDispatcher rd = request.getRequestDispatcher("/logout.jsp");
    		rd.forward(request, response);
    	}
    	
    }
}