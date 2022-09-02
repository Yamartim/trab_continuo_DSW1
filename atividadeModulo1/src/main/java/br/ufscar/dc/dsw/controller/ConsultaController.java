package br.ufscar.dc.dsw.controller;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.ufscar.dc.dsw.dao.ClienteDAO;
import br.ufscar.dc.dsw.dao.ConsultaDAO;
import br.ufscar.dc.dsw.dao.PrestadorDAO;
import br.ufscar.dc.dsw.domain.Cliente;
import br.ufscar.dc.dsw.domain.Consulta;
import br.ufscar.dc.dsw.domain.Prestador;

@WebServlet(urlPatterns = "/consulta/*")
public class ConsultaController extends HttpServlet {

    private static final long serialVersionUID = 1L;
    
    private ConsultaDAO dao;
    private ClienteDAO daocliente;
	private PrestadorDAO daoprestador;
    
    public void init() {
        dao = new ConsultaDAO();
        daocliente = new ClienteDAO();
        daoprestador = new PrestadorDAO();
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
                case "/agendar":
                    formAgendar(request, response);
                    break;
                case "/inserir":
                	insere(request, response);
                    break;
                case "/cancelar":
                	//cancela(request, response);
                    break;
                default:
                    break;
            }
        } catch (RuntimeException | IOException | ServletException e) {
            throw new ServletException(e);
        }

    }

	private void formAgendar(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException{
		
		Long idcliente = Long.parseLong(request.getParameter("idcliente"));
		Long idprestador = Long.parseLong(request.getParameter("idprestador"));
		
		Prestador prestador = daoprestador.get(idprestador);
		
		request.setAttribute("idcliente", idcliente);
		request.setAttribute("idprestador", idprestador);
		request.setAttribute("prestador", prestador);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("../agendar.jsp");
        dispatcher.forward(request, response);
		
	}
	
	private void insere(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        
        Long idcliente = Long.parseLong(request.getParameter("idcliente"));
        Long idprestador = Long.parseLong(request.getParameter("idprestador"));
        String data = request.getParameter("data");
        String estado = request.getParameter("estado");
        
        Cliente clienteConsulta = daocliente.get(idcliente);
        Prestador prestadorConsulta = daoprestador.get(idprestador);
        
        Consulta consulta = new Consulta(null, clienteConsulta, prestadorConsulta, data, estado);
        dao.insert(consulta);
        
        request.getSession().setAttribute("usuarioLogado", clienteConsulta);
        
        String url = request.getContextPath();
        response.sendRedirect(url.concat("/cliente/"));
    }
}
