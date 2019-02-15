package com.java.repository;

import java.util.Collection;

import com.java.dao.Product;
import com.java.exception.DatabaseException;

public interface ProductRepository {

	Product getProductById(int productId) throws DatabaseException;
	Collection<Product> getAllProducts();
	int updateProduct(Product product) throws DatabaseException;
	int deleteProduct(int productId);
	void insertProduct(Product product);
}
