package br.ufscar.dc.dsw.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import br.ufscar.dc.dsw.domain.Cliente;


@WebServlet(urlPatterns = "/admin/*")
public class AdminController extends HttpServlet {

    private static final long serialVersionUID = 1L;

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
                default:
                    login(request, response);
                    break;
            }
        } catch (RuntimeException | IOException | ServletException e) {
            throw new ServletException(e);
        }
    	
    }
    
    private void login(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    	
    	Cliente usuario = (Cliente) request.getSession().getAttribute("usuarioLogado");
    	
    	if (usuario == null) {
    		response.sendRedirect(request.getContextPath());
    	} else if (usuario.getAdm()== 1) {
    		RequestDispatcher dispatcher = request.getRequestDispatcher("/logado/admin/index.jsp");
            dispatcher.forward(request, response);
    	} else {
    		RequestDispatcher rd = request.getRequestDispatcher("/logout.jsp");
    		rd.forward(request, response);
    	}
    	
    }
}