package com.java.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.PreparedStatementSetter;
import org.springframework.stereotype.Repository;

import com.java.dao.Product;
import com.java.dao.Product.ProductExtractor;
import com.java.dao.Product.ProductMapper;
import com.java.exception.DatabaseException;

@Repository
@Primary
public class ProductRepositoryImpl2 implements ProductRepository{

	@Autowired JdbcTemplate template;
	@Autowired ProductMapper mapper;
	@Autowired ProductExtractor extractor;

	@Override
	public Product getProductById(int productId) {
	/*Product p=template.query(new PreparedStatementCreator() {
		
		@Override
		public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
		PreparedStatement stmt=con.prepareStatement("select * from product where productId=? ");
		stmt.setInt(1, productId);
		return stmt;
		}
	}, extractor);
		return p;*/
		Object[] params= {productId};
		Product p= null;
		try {
		 p=template.queryForObject("select * from product where productId= ?",params ,mapper);
		}catch(EmptyResultDataAccessException e) {
			System.out.println(e.getMessage());
		}
		return p;
	}

	@Override
	public Collection<Product> getAllProducts() {
		List<Product> products= template.query(new PreparedStatementCreator() {
				
				@Override
				public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
				PreparedStatement stmt=con.prepareStatement("select * from product ");
				return stmt;
				}
			}, mapper);
		return products;
	}

	@Override
	public int updateProduct(Product product)  {
		int rowcount=template.update("update product set name =?, description= ?, price= ? where productId= ?", new PreparedStatementSetter() {
			
			@Override
			public void setValues(PreparedStatement ps) throws SQLException {
				ps.setString(1, product.getProductName());
				ps.setString(2, product.getDescription());
				ps.setFloat(3, product.getPrice());
				ps.setInt(4, product.getProductId());
			}
		});
		return rowcount;
	}

	@Override
	public int deleteProduct(int productId) {
		Object[]  params= {productId};
		return template.update("delete from product where productId =?",params , Integer.class);
	}

	@Override
	public void insertProduct(Product product) {
		// TODO Auto-generated method stub
		
	}
	
}
