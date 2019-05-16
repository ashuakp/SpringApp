package com.sapiens.utilz;

import java.sql.Connection;
import java.sql.DriverManager;

public class DButilz {
	public static final String driver = "oracle.jdbc.driver.OracleDriver";
	public static final String url ="jdbc:sqlserver://localhost;instanceName=LCL_DVLPR_2016;integratedSecurity=true" ;
	public static final String user = "PCMP";
	public static final String pwd = "F00tballer";
	
	private static Connection con;
	public static Connection getConnection() throws Exception
	{
		Class.forName(driver);
		con = DriverManager.getConnection(url, user, pwd);
		return con;
	}
	
	public static void closeConnection() throws Exception
	{
		if(con != null)
			con.close();

	}
}
