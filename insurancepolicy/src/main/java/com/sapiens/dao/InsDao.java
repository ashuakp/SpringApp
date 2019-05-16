package com.sapiens.dao;

import java.io.*;
import java.sql.*;

import com.sapiens.customer.Customer;
import com.sapiens.policy.Policy;
import com.sapiens.utilz.DButilz;

public class InsDao implements Closeable {
	private PreparedStatement stateselect, stateInsert,searchname,searchid,stateCustID, stateRiskLoc;
	public InsDao() throws Exception {
		Connection connection = DButilz.getConnection();
		this.stateselect = connection.prepareStatement("select * from CUSTOMERS");
		this.stateInsert = connection.prepareStatement("insert into CUSTOMERS(CUST_NAME,CUST_ADD,ROLE) values(?,?,?)");
		this.searchname = connection.prepareStatement("select * from CUSTOMERS where CUST_NAME = ?");
		this.searchid = connection.prepareStatement("select * from CUSTOMERS where CUST_ID = ?");
		this.stateCustID = connection.prepareStatement("select * from CUSTOMERS where CUST_ID = ?");
		this.stateRiskLoc = connection.prepareStatement("insert into CUST_POLICY(RISK_LOC = ?)");
		}
		
		public int insert (Policy policy) throws Exception
		{
			stateInsert.setString(1, policy.getRiskloc());
			return stateInsert.executeUpdate();
		}
	
	public int insert (Customer customer) throws Exception
	{
		stateInsert.setString(1, customer.getName());
		stateInsert.setString(2, customer.getAddress());
		stateInsert.setString(3, customer.getRole());
		return stateInsert.executeUpdate();
	}
	
	


	public void close() throws IOException {
		// TODO Auto-generated method stub
		try {
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public Customer searchByName(String name) throws Exception {
		searchname.setString(1, name);
		ResultSet rs = searchname.executeQuery();
		if(rs.next()) {
			Customer cust = new Customer();
			cust.setId(rs.getInt("CUST_ID"));
			cust.setName(rs.getString("CUST_NAME"));
			cust.setAddress(rs.getString("CUST_ADD"));
			cust.setRole(rs.getString("ROLE"));
			return cust;	
		}
		else
			return null;
	}

	public Customer searchById(int id) throws Exception {
		// TODO Auto-generated method stub
		searchid.setInt(1, id);
		ResultSet rs = searchid.executeQuery();
		if(rs.next()) {
			Customer cust = new Customer();
			cust.setId(rs.getInt("CUST_ID"));
			cust.setName(rs.getString("CUST_NAME"));
			cust.setAddress(rs.getString("CUST_ADD"));
			cust.setRole(rs.getString("ROLE"));
			return cust;	
		}
		else
			return null;
	}
}
