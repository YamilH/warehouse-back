package ar.com.warehouse.entity;

import java.time.LocalDate;

public class Product {
	
	private Long id;
    private String name;
    private String description;
    private Long quantity;
    private Double price;
    private String location;
    private LocalDate enrollmentDate;
    
    
	public Product(String name, String description, Long quantity, Double price, String location,
			LocalDate enrollmentDate) {
		this.name = name;
		this.description = description;
		this.quantity = quantity;
		this.price = price;
		this.location = location;
		this.enrollmentDate = enrollmentDate;
	}


	public Product(Long id, String name, String description, Long quantity, Double price, String location,
			LocalDate enrollmentDate) {
		this.id = id;
		this.name = name;
		this.description = description;
		this.quantity = quantity;
		this.price = price;
		this.location = location;
		this.enrollmentDate = enrollmentDate;
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}


	public Long getQuantity() {
		return quantity;
	}


	public void setQuantity(Long quantity) {
		this.quantity = quantity;
	}


	public Double getPrice() {
		return price;
	}


	public void setPrice(Double price) {
		this.price = price;
	}


	public String getLocation() {
		return location;
	}


	public void setLocation(String location) {
		this.location = location;
	}


	public LocalDate getEnrollmentDate() {
		return enrollmentDate;
	}


	public void setEnrollmentDate(LocalDate enrollmentDate) {
		this.enrollmentDate = enrollmentDate;
	}


	@Override
	public String toString() {
		return "Product [id=" + id + ", name=" + name + ", description=" + description + ", quantity=" + quantity
				+ ", price=" + price + ", location=" + location + ", enrollmentDate=" + enrollmentDate + "]";
	}
    
	
	
	
    

}
