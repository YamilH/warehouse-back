package ar.com.warehouse.repository;

import java.util.List;

import ar.com.warehouse.entity.Product;

public interface ProductRepository {
	
    public void save(Product product);
    public Product getById(Long id);
    public void update(Product product);
    public void delete(Long id);
    public List<Product> findAll();

}
