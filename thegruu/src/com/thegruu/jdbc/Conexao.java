package com.thegruu.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao {
	
	public static Connection getConnection(){
		Connection con=null;
		try { 
			Class.forName("com.mysql.jdbc.Driver");
			
			con =  DriverManager.getConnection("jdbc:mysql://localhost/thegruu", "root", "geracaotec"); 
			
			System.out.println("Conectado com sucesso!");
			
		} catch (SQLException | ClassNotFoundException e) {
			
			System.out.println("Não pode conectar: "+e.getMessage());
		}
		
		return con;
		
	}

}
