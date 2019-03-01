package com.java.config;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

@Component
public class MyUserDetailsService implements UserDetailsService{
	
	@Autowired JdbcTemplate template;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		UserDetail details=template.query("select u.username as username, u.password as password, true as enabled, r.authority as authority from user_details u, user_roles r"
				+ " where u.username=? and r.username = u.username ",new Object[] {username},new ResultSetExtractor<UserDetail>() {

					@Override
					public UserDetail extractData(ResultSet rs) throws SQLException, DataAccessException {
						UserDetail obj= new UserDetail();
						obj.setAuthorities(new ArrayList<>());
						while(rs.next()) {
							obj.setUsername(rs.getString("username"));
							obj.setPassword(rs.getString("password"));
							obj.setEnabled(rs.getBoolean("enabled"));
							obj.getAuthorities().add(rs.getString("authority"));
						}
						return obj;
					}
				});
		
		return new User(details.getUsername(), details.getPassword(), details.getAuthorities().stream().map(x-> new SimpleGrantedAuthority(x)).collect(Collectors.toList()));
	}

}
