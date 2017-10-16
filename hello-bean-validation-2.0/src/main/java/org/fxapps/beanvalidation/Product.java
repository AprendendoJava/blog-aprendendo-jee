package org.fxapps.beanvalidation;

import java.time.LocalDate;
import java.util.List;
import javax.validation.constraints.Email;
import javax.validation.constraints.Future;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Positive;

public class Product {

	@NotNull(message = "A product must have a name!")
	private String name;

	@Positive(message = "Quantity should never be negative")
	private Integer quantity;

	private List<@Email(message = "Email is not valid in product subscribers list!") String> subscribers;

	@Past(message = "Manufacture date should be in the past")
	private LocalDate manufactureDate;

	@Future(message = "Expiration Date should be in future")
	private LocalDate expirationDate;

	public Product(String name, Integer quantity) {
		super();
		this.name = name;
		this.quantity = quantity;
	}

	public Product(String name, Integer quantity, List<String> subscribers) {
		super();
		this.name = name;
		this.quantity = quantity;
		this.subscribers = subscribers;
	}

	public Product(String name, Integer quantity, List<String> subscribers, LocalDate manufactureDate,
			LocalDate expirationDate) {
		super();
		this.name = name;
		this.quantity = quantity;
		this.subscribers = subscribers;
		this.manufactureDate = manufactureDate;
		this.expirationDate = expirationDate;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public List<String> getSubscribers() {
		return subscribers;
	}

	public void setSubscribers(List<String> subscribers) {
		this.subscribers = subscribers;
	}

}
