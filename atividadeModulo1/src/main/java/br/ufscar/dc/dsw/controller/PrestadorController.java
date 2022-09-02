package br.ufscar.dc.dsw.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.ufscar.dc.dsw.dao.PrestadorDAO;
import br.ufscar.dc.dsw.domain.Prestador;

@WebServlet(urlPatterns = "/prestador/*")
public class PrestadorController extends HttpServlet {

	private static final long serialVersionUID = 1L;

	private PrestadorDAO dao;

	public void init() {
		dao = new PrestadorDAO();
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
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
			case "/listagem":
				listaPrestadores(request, response);
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
		RequestDispatcher dispatcher = request.getRequestDispatcher("/logado/prestador/cadastro.jsp");
		dispatcher.forward(request, response);
	}

	private void formEdicao(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		Long id = Long.parseLong(request.getParameter("id"));
		if (id != 0) {
			Prestador prestador = dao.get(id);
			request.setAttribute("prestador", prestador);
		} else {
			Prestador prestador = null;
			request.setAttribute("prestador", prestador);
		}

		RequestDispatcher dispatcher = request.getRequestDispatcher("/logado/prestador/edicao.jsp");
		dispatcher.forward(request, response);
	}

	private void insere(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");

		String email = request.getParameter("email");
		String senha = request.getParameter("senha");
		String nome = request.getParameter("nome");
		String CPF = request.getParameter("CPF");
		String area = request.getParameter("area");
		String especialidade = request.getParameter("especialidade");

		Prestador prestador = new Prestador(null, email, senha, nome, CPF, area, especialidade);
		dao.insert(prestador);
		response.sendRedirect("login");
	}

	private void insereADM(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");

		String email = request.getParameter("email");
		String senha = request.getParameter("senha");
		String nome = request.getParameter("nome");
		String CPF = request.getParameter("CPF");
		String area = request.getParameter("area");
		String especialidade = request.getParameter("especialidade");

		Prestador prestador = new Prestador(null, email, senha, nome, CPF, area, especialidade);
		dao.insert(prestador);
		response.sendRedirect("gerenciar");
	}

	private void remove(HttpServletRequest request, HttpServletResponse response) throws IOException {

		Long id = Long.parseLong(request.getParameter("id"));

		Prestador prestador = new Prestador(id, null, null, null, null, null, null);
		dao.delete(prestador);
		response.sendRedirect("gerenciar");

	}

	private void atualiza(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");

		Long id = Long.parseLong(request.getParameter("id"));
		String email = request.getParameter("email");
		String senha = request.getParameter("senha");
		String nome = request.getParameter("nome");
		String CPF = request.getParameter("CPF");
		String area = request.getParameter("area");
		String especialidade = request.getParameter("especialidade");

		Prestador prestador = new Prestador(id, email, senha, nome, CPF, area, especialidade);
		dao.update(prestador);
		response.sendRedirect("gerenciar");
	}

	private void gerencia(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		List<Prestador> listaPrestadores = dao.getAll();
		request.setAttribute("listaPrestadores", listaPrestadores);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/logado/prestador/gerenciamento.jsp");
		dispatcher.forward(request, response);
	}

	private void listaPrestadores(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String filtroarea = request.getParameter("filtroarea");
		String filtroespec = request.getParameter("filtroespec");
		
		List<Prestador> listaPrestadores = dao.getAll();
		Prestador prestador;

		List<String> listaArea = new ArrayList<>();
		String area;
		
		List<String> listaEspec = new ArrayList<>();
		String espec;

		//pega os valores de areas para seleção do filtro
		for (int i = 0; i < listaPrestadores.size(); i++) {
			prestador = listaPrestadores.get(i);
			if (listaArea.contains(prestador.getArea()) == false) {
				area = prestador.getArea();
				listaArea.add(area);
			}
		}
		
		if(listaArea.contains(filtroarea)){
			listaPrestadores = dao.getPrestadorFiltro(filtroarea, null);
			
			//pega os valores de especialidades para seleção do filtro
			for (int i = 0; i < listaPrestadores.size(); i++) {
				prestador = listaPrestadores.get(i);
				if (listaEspec.contains(prestador.getEspecialidade()) == false) {
					espec = prestador.getEspecialidade();
					listaEspec.add(espec);
				}
			}
			
			if(listaEspec.contains(filtroespec)) {
				listaPrestadores = dao.getPrestadorFiltro(filtroarea, filtroespec);
			}
			
		}else {
			RequestDispatcher dispatcher = request.getRequestDispatcher("/listagem");
		}

		request.setAttribute("listaPrestadores", listaPrestadores);
		request.setAttribute("listaArea", listaArea);
		request.setAttribute("listaEspec", listaEspec);
		request.setAttribute("filtroarea", filtroarea);
		request.setAttribute("filtroespec", filtroespec);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("/listaprofs.jsp");
		dispatcher.forward(request, response);

	}

	private void login(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		Prestador prestador = (Prestador) request.getSession().getAttribute("usuarioLogado");

		if (prestador == null) {
			response.sendRedirect(request.getContextPath());
		} else if (prestador.getEmail() != null) {
			RequestDispatcher dispatcher = request.getRequestDispatcher("/logado/prestador/index.jsp");
			dispatcher.forward(request, response);
		} else {
			RequestDispatcher rd = request.getRequestDispatcher("/logout.jsp");
			rd.forward(request, response);
		}
	}
}