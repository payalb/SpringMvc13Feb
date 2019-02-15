package com.java.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collection;

import org.apache.tomcat.dbcp.dbcp2.BasicDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

import com.java.dao.Product;
import com.java.exception.DatabaseException;

@Repository
@Scope("singleton")
public class ProductRepositoryImpl implements ProductRepository {
	
	@Autowired BasicDataSource bds;

	@Override
	public Product getProductById(int productId) throws DatabaseException  {
		Product p= new Product();
		Connection con;
		try {
			con = bds.getConnection();
		
		PreparedStatement st=con.prepareStatement("select * from product where productId= ?");
		st.setInt(1, productId);
		ResultSet set=st.executeQuery();
		
		if(set.next()) {
		
			p.setProductId(set.getInt("productId"));
			p.setProductName(set.getString("productName"));
			p.setCategory(set.getString("category"));
			
		}
		} catch (SQLException e) {
			throw new DatabaseException("Failed to fetch product details from db for id: "+ productId+ ". Message :"+ e.getMessage());
		}
		return p;
	}

	@Override
	public Collection<Product> getAllProducts() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int updateProduct(Product product) throws DatabaseException {
		Connection con;
		int numberOfRowsUpdated=0;
		try {
			con = bds.getConnection();
		
		PreparedStatement st=con.prepareStatement("insert into product values (?,?,?,?,?)");
		st.setInt(1, product.getProductId());
		st.setString(2, product.getProductName());
		st.setFloat(3, product.getPrice());
		st.setString(4, product.getCategory());
		st.setString(5, product.getDescription());
		numberOfRowsUpdated=st.executeUpdate();
		
		con.commit();
		} catch (SQLException e) {
			throw new DatabaseException("Failed to insert product details to db for product: "+ product+ ". Message :"+ e.getMessage());
		}
		return numberOfRowsUpdated;
	}

	@Override
	public int deleteProduct(int productId) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void insertProduct(Product product) {
		// TODO Auto-generated method stub

	}

}
