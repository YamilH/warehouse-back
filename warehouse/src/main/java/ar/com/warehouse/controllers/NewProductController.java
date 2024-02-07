package ar.com.warehouse.controllers;

import java.io.IOException;
import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

import ar.com.warehouse.entity.Product;
import ar.com.warehouse.repository.MySQLProductRepository;
import ar.com.warehouse.repository.ProductRepository;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/api/product")
public class NewProductController extends AppBaseController {
	
	private ProductRepository repository = new MySQLProductRepository();
	
	protected void doPost(
	        HttpServletRequest request,
	        HttpServletResponse response) 
	    throws ServletException, IOException {

		String json = super.toJson(request);

	    ProductRequest productRequest = super.mapper.readValue(json, ProductRequest.class);

	    if (productRequest.getName() == null || productRequest.getDescription() == null || productRequest.getQuantity() == null || productRequest.getPrice() == null || productRequest.getLocation() == null) {
	        // Handle validation or error response if necessary
	        response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
	        response.getWriter().print("Invalid product data");
	        return;
	    }

	    ProductRepository repository = new MySQLProductRepository();
	    Product product = new Product(
	            productRequest.getName(),
	            productRequest.getDescription(),
	            productRequest.getQuantity(),
	            productRequest.getPrice(),
	            productRequest.getLocation(),
	            LocalDate.now());

	    repository.save(product);

	    response.setStatus(HttpServletResponse.SC_CREATED);

	    response.getWriter().print(mapper.writeValueAsString(product));

	    System.out.println("Product created successfully");
	}
	
	
	protected void doGet(
	        HttpServletRequest request,
	        HttpServletResponse response) throws ServletException, IOException {

	    	List<Product> products = this.repository.findAll();

	    	String jsonToSendToFrontend = super.mapper.writeValueAsString(products);

	    	response.setStatus(HttpServletResponse.SC_OK);

	    	response.getWriter().print(jsonToSendToFrontend);
	}
	
	
	protected void doDelete(
	        HttpServletRequest req,
	        HttpServletResponse resp) throws ServletException, IOException {

			String id = req.getParameter("id");
		
			this.repository.delete(Long.parseLong(id));
	
			resp.setStatus(HttpServletResponse.SC_OK);
	}
	
	
	protected void doPut(
			HttpServletRequest request, 
			HttpServletResponse response) throws ServletException, IOException {
		
			String id = request.getParameter("id");
			
			String json = super.toJson(request);
		
			ProductRequest productRequest = super.mapper.readValue(json, ProductRequest.class);

			Product product = repository.getById(Long.parseLong(id));

			product.setName(productRequest.getName());
			product.setDescription(productRequest.getDescription());
			product.setQuantity(productRequest.getQuantity());
			product.setPrice(productRequest.getPrice());
			product.setLocation(productRequest.getLocation());

			repository.update(product);

			response.setStatus(HttpServletResponse.SC_OK);
	}


	
	


}
