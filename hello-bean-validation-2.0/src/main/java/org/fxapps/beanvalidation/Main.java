package org.fxapps.beanvalidation;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.constraints.Email;

public class Main {
	public static void main(String[] args) {
		Validator validator = Validation.buildDefaultValidatorFactory().getValidator();
		Product p1 = new Product(null, -1);
		Set<ConstraintViolation<Product>> p1Validation = validator.validate(p1);
		System.out.println("Validating p1...");
		printValidationMessages(p1Validation);

		List<@Email String> subscribersForP2 = new ArrayList<>();
		subscribersForP2.add("john@email.com");
		subscribersForP2.add("bad email");
		Product p2 = new Product("Bread", 10, subscribersForP2);
		Set<ConstraintViolation<Product>> p2Validation = validator.validate(p2);
		System.out.println("Validating p2...");
		printValidationMessages(p2Validation);

		List<@Email String> subscribersForP3 = new ArrayList<>();
		subscribersForP3.add("john@email.com");
		subscribersForP3.add("may@email.com");
		LocalDate p3ManufactureDate = LocalDate.now().minus(10, ChronoUnit.DAYS);
		LocalDate p3ExpirationDate = LocalDate.now();
		Product p3 = new Product("Car", 10, subscribersForP3, p3ManufactureDate, p3ExpirationDate);
		Set<ConstraintViolation<Product>> p3Validation = validator.validate(p3);
		System.out.println("Validating p3...");
		printValidationMessages(p3Validation);
		
		LocalDate p4ExpirationDate = LocalDate.now().plus(20, ChronoUnit.DAYS);
		Product p4 = new Product("Car", 10, subscribersForP3, p3ManufactureDate, p4ExpirationDate);
		Set<ConstraintViolation<Product>> p4Validation = validator.validate(p4);
		System.out.println("Validating p4...");
		printValidationMessages(p4Validation);
	}

	private static void printValidationMessages(Set<ConstraintViolation<Product>> p1Validation) {
		if (!p1Validation.isEmpty()) {
			p1Validation.stream().map(ConstraintViolation::getMessage).map(m -> "\t- " + m)
					.forEach(System.out::println);
		} else {
			System.out.println("\t- Object is valid!");
		}
	}

}