package org.fxapps.cdi.javafx;

import javax.enterprise.inject.se.SeContainer;
import javax.enterprise.inject.se.SeContainerInitializer;
import javax.inject.Inject;

import org.fxapps.cdi.javafx.service.Greeter;

public class App {

	@Inject
	Greeter greeter;

	public void callGreeter() {
		String greeting = greeter.greet("William");
		System.out.println(greeting);

	}

	public static void main(String[] args) {
		SeContainerInitializer initializer = SeContainerInitializer.newInstance();
		try(final SeContainer container = initializer.initialize()){
			 App app = container.select(App.class).get();
			 app.callGreeter();
		};
	}

}
