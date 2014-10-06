package br.com.snaperpnfedesktop.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class ConnectionFactory {

	public ConnectionFactory() {
		
	}
	
	public static Connection getConnection() throws ClassNotFoundException{   
    try{  
    	System.out.println("Conexao com BD");
        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");  
        return DriverManager.getConnection("jdbc:sqlserver://localhost:1433;DatabaseName=NF_ELETRONICA;user=snapsystems;Password=snap@2103");
        //return DriverManager.getConnection("jdbc:sqlserver://54.207.162.96:1433;DatabaseName=NF_ELETRONICA;user=snapsystems;Password=snap@2103");
    }catch(SQLException e){  
    	System.out.println("NAO CONECTOU");
        throw new RuntimeException(e);  
    }  
}  
}
