package ar.com.warehouse.repository;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import ar.com.warehouse.entity.Product;

public class MySQLProductRepository implements ProductRepository {

	@Override
	public void save(Product product) {
	    String sql = "INSERT INTO product (name, description, quantity, price, location, enrollment_date) VALUES (?,?,?,?,?,?)";
	    try {
	        Connection conn = ConnectionsManager.getConnection();
	        PreparedStatement statement = conn.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
	        statement.setString(1, product.getName());
	        statement.setString(2, product.getDescription());
	        statement.setLong(3, product.getQuantity());
	        statement.setDouble(4, product.getPrice());
	        statement.setString(5, product.getLocation());
	        statement.setDate(6, new java.sql.Date(System.currentTimeMillis()));
	        statement.executeUpdate();
	    } catch (Exception e) {
	        throw new IllegalArgumentException("Can't create product", e);
	    }
	}


	@Override
	public Product getById(Long id) {
	    String sql = "SELECT id, name, description, quantity, price, location, enrollment_date FROM product WHERE id = ?";
	    Product product = null;
	    try {
	        Connection conn = ConnectionsManager.getConnection();
	        PreparedStatement statement = conn.prepareStatement(sql);
	        statement.setLong(1, id);
	        ResultSet res = statement.executeQuery();
	        if (res.next()) {
	            Long _id = res.getLong(1);
	            String name = res.getString(2);
	            String description = res.getString(3);
	            Long quantity = res.getLong(4);
	            Double price = res.getDouble(5);
	            String location = res.getString(6);
	            Date enrollmentDate = res.getDate(7);

	            product = new Product(_id, name, description, quantity, price, location, LocalDate.now());
	        }

	    } catch (Exception e) {
	        throw new IllegalArgumentException("Can't reach product", e);
	    }
	    return product;
	}


	@Override
	public void update(Product product) {
	    String sql = "UPDATE product "
	            + "SET name=?, description=?, quantity=?, price=?, location=? "
	            + "WHERE id = ?";
	    try {
	        Connection conn = ConnectionsManager.getConnection();
	        PreparedStatement statement = conn.prepareStatement(sql);
	        statement.setString(1, product.getName());
	        statement.setString(2, product.getDescription());
	        statement.setLong(3, product.getQuantity());
	        statement.setDouble(4, product.getPrice());
	        statement.setString(5, product.getLocation());
	        statement.setLong(6, product.getId());

	        statement.executeUpdate();
	    } catch (Exception e) {
	        throw new IllegalArgumentException("Can't update product", e);
	    }
	}


	@Override
	public void delete(Long id) {
	    String sql = "DELETE FROM product WHERE id = ?";
	    try {
	        Connection conn = ConnectionsManager.getConnection();
	        PreparedStatement statement = conn.prepareStatement(sql);
	        statement.setLong(1, id);
	        statement.executeUpdate();
	    } catch (Exception e) {
	        throw new IllegalArgumentException("Can't delete product", e);
	    }
	}


	@Override
	public List<Product> findAll() {
	    String sql = "SELECT id, name, description, quantity, price, location, enrollment_date FROM product";
	    List<Product> products = new ArrayList<>();
	    try {
	        Connection conn = ConnectionsManager.getConnection();
	        PreparedStatement statement = conn.prepareStatement(sql);
	        ResultSet res = statement.executeQuery();

	        while (res.next()) {
	            Long _id = res.getLong(1);
	            String name = res.getString(2);
	            String description = res.getString(3);
	            Long quantity = res.getLong(4);
	            Double price = res.getDouble(5);
	            String location = res.getString(6);
	            Date enrollmentDate = res.getDate(7);

	            Product product = new Product(_id, name, description, quantity, price, location, LocalDate.now());
	            products.add(product);
	        }

	    } catch (Exception e) {
	        throw new IllegalArgumentException("Can't reach product", e);
	    }
	    return products;
	}


}
