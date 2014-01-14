package org.jugvale.ola.jaxws;

import javax.ejb.Stateless;
import javax.jws.WebParam;
import javax.jws.WebService;

@WebService
@Stateless
public class CalculadoraWS {

	public double fazerOp(@WebParam(name = "num1") double a,
			@WebParam(name = "num2") double b, @WebParam(name = "op") String op) {
		// Por que você não clona o projeto e cria mais funções para brincar?
		switch (op) {
		case "+":
			return a + b;
		case "-":
			return a - b;
		case "*":
			return a * b;
		case "/":
			return a / b;
		default:
			throw new IllegalArgumentException("Operação '" + op
					+ "' não reconhecida. Informa '+', '-', '*' ou '/'.");
		}
	}
}
