package br.com.ead_pcd.aula15.exemplos;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/SomarNumeros")
public class SomarNumeros extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		Double numero1 = Double.parseDouble(request.getParameter("n1"));
		Double numero2 = Double.parseDouble(request.getParameter("n2"));
		String operador = request.getParameter("selectOperacao");
		Double result = null;
		
		if (operador.equals("somar")) {
			result = numero1 + numero2;
		}
		if (operador.equals("subtrair")) {
			result = numero1 - numero2;
		}
		if (operador.equals("multiplicar")) {
			result = numero1 * numero2;
		}
		if (operador.equals("dividir")) {
			result = numero1 / numero2;
		}
		
		out.write("<html>");
		out.write("<head>");
		out.write("<title>ServeltCalc - Resultado</title>");
		out.write("</head>");
		out.write("<body>");
		out.write("<h1>Resultado: " + result + "</h1>");
		out.write("</body>");
		out.write("</html>");
		out.close();
	}

}
