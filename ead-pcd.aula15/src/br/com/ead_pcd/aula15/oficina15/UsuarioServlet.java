package br.com.ead_pcd.aula15.oficina15;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/cadastroDeUsuario")
public class UsuarioServlet extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		String login = request.getParameter("login");
		String nome = request.getParameter("nome");
		String senha = request.getParameter("senha");
		
		out.write("<html>");
		out.write("<head>");
		out.write("<title>Sistema de Gestão Financeira</title>");
		out.write("</head>");
		out.write("<body>");
		out.write("<h1>Cadastro de Usuários</h1>");
		out.write("<p>Nome: " + nome + " Login: " + login + " Senha: " + senha + "</p>");
		out.write("<p><a href=" + "cadastroUsuarios.html" + ">Voltar</a></p>");
		out.write("</body>");
		out.write("</html>");
		out.close();
	}

}
