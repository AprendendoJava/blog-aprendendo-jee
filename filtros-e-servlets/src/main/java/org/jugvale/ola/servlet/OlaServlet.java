package org.jugvale.ola.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/diga-ola")
public class OlaServlet extends HttpServlet {

	@Override
	public void init() throws ServletException {
		System.out.println("Criando Servlet OLA");
		super.init();
	}

	@Override
	public void destroy() {
		System.out.println("Destruindo Servlet Olá");
		super.destroy();
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		String nome = req.getParameter("nome");
		if (nome == null) {
			resp.sendError(400, "Informe um nome ae, tiozão");
		} else {
			PrintWriter pw = resp.getWriter();
			pw.write("<h1>Olá Mundo!!</h1>");
			pw.write("<h2>Bem vindo ao mundo Java WEB, " + nome + "</h2>");
			pw.close();
		}
	}
}