package org.jugvale.ola.servlet;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;

@WebFilter("/*")
public class FiltroGlobal implements Filter {

	public void destroy() {
	}

	public void doFilter(ServletRequest req, ServletResponse resp,
			FilterChain chain) throws IOException, ServletException {
		HttpServletRequest r = (HttpServletRequest) req;

		System.out.println("Invocando Servlet no contexto: "
				+ r.getRequestURI());
		chain.doFilter(req, resp);
		System.out.println("Fim da invocação do Servlet no contexto: "
				+ r.getRequestURI());
	}

	public void init(FilterConfig config) throws ServletException {

	}

}
