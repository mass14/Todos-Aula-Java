package conta;


import java.sql.DriverManager;
import java.sql.Connection;
 import java.sql.SQLException;

public abstract class Conexao  {
	protected Connection con;
	
	public Conexao() throws SQLException{
		con = criarConexao();
	}
	
	public static Connection criarConexao() throws SQLException{
	Connection con = DriverManager.getConnection (
			"jdbc:mysql://localhost:3306/conta", "root", "senha");
	return con;
	}
}
