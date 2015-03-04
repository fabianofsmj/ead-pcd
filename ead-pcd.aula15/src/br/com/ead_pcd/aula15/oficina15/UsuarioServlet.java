package br.com.ead_pcd.aula15.oficina15;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/cadastroDeUsuario")
public class UsuarioServlet extends HttpServlet {

	private boolean result;
	
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		String idUsu = request.getParameter("id");
		String login = request.getParameter("login");
		String nome = request.getParameter("nome");
		String senha = request.getParameter("senha");
		String acao = request.getParameter("acao");

		UsuarioDAO dao = new UsuarioDAO();
		Usuario usuario = new Usuario();

		if (idUsu != null) {
			usuario.setIdUsuario(Integer.parseInt(idUsu));
		}
		
		usuario.setLogin(login);
		usuario.setNome(nome);
		usuario.setSenha(senha);

		switch (acao) {
		case "Incluir":
			result = dao.inserir(usuario);
			if (result) {
				request.setAttribute("nome", usuario.getNome());
				RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/jsp/usuario-adicionado.jsp");
				rd.forward(request, response);
			}
			break;
		case "Salvar":
			result = dao.atualizar(usuario);
			if (result) {
				request.setAttribute("nome", usuario.getNome());				
				RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/jsp/usuario-atualizado.jsp");
				rd.forward(request, response);
			}
			break;
		case "Excluir":
			usuario = (Usuario) dao.buscarPorLogin(login);
			result = dao.excluir(usuario.getIdUsuario());
			if (result) {
				request.setAttribute("login", usuario.getLogin());
				RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/jsp/usuario-excluido.jsp");
				rd.forward(request, response);
			}
			break;
		case "Pesquisar":
			usuario = (Usuario) dao.buscarPorLogin(login);
			
			request.setAttribute("id", usuario.getIdUsuario());
			request.setAttribute("login", usuario.getLogin());
			request.setAttribute("nome", usuario.getNome());
			request.setAttribute("senha", usuario.getSenha());
			
			RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/jsp/usuario-pesquisar.jsp");
			rd.forward(request, response);				
			break;
		default:
			break;
		}
	}

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

	}
}
