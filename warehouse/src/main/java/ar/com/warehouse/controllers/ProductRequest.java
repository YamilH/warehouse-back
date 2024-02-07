package ar.com.warehouse.controllers;

import java.time.LocalDate;

public class ProductRequest {
	
    private String name;
    private String description;
    private Long quantity;
    private Double price;
    private String location;
    private LocalDate enrollmentDate;
    
    public ProductRequest() {
    	
    }

	public ProductRequest(String name, String description, Long quantity, Double price, String location,
			LocalDate enrollmentDate) {
		this.name = name;
		this.description = description;
		this.quantity = quantity;
		this.price = price;
		this.location = location;
		this.enrollmentDate = enrollmentDate;
	}

	public String getName() {
		return name;
	}

	public String getDescription() {
		return description;
	}

	public Long getQuantity() {
		return quantity;
	}

	public Double getPrice() {
		return price;
	}

	public String getLocation() {
		return location;
	}

	public LocalDate getEnrollmentDate() {
		return enrollmentDate;
	}

	@Override
	public String toString() {
		return "ProductRequest [name=" + name + ", description=" + description + ", quantity=" + quantity + ", price="
				+ price + ", location=" + location + ", enrollmentDate=" + enrollmentDate + "]";
	}
	
	
	
    
    

}
