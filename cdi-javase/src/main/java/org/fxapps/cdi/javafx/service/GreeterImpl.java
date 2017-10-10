package org.fxapps.cdi.javafx.service;

public class GreeterImpl implements Greeter {

	public String greet(String name) {
		if(name == null) {
			name = "unknown";
		}
		return "Hello " + name + "!";
	}

}