package com.java.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;

import lombok.Data;

@Data
public class Product {

	private int productId;
	@NotEmpty
	@Size(min=3, max=20, message="Size.product.productName")
	private String productName;
	private float price;
	private String category;
	private String description;
	
	
	public static class ProductMapper implements RowMapper<Product>{

		@Override
		public Product mapRow(ResultSet set, int rowNum) throws SQLException {
			Product p= new Product();
			p.setProductId(set.getInt("productId"));
			p.setProductName(set.getString("productName"));
			p.setCategory(set.getString("category"));
			p.setDescription(set.getString("description"));
			p.setPrice(set.getFloat("price"));
			return p;
		}
		
	}
	
	public static class ProductExtractor implements ResultSetExtractor<Product>{

		@Override
		public Product extractData(ResultSet set) throws SQLException, DataAccessException {
			Product p= new Product();
			p.setProductId(set.getInt("productId"));
			p.setProductName(set.getString("productName"));
			p.setCategory(set.getString("category"));
			p.setDescription(set.getString("description"));
			p.setPrice(set.getFloat("price"));
			return p;
		}
		
	}
}
