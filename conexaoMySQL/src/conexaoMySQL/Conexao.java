package conexaoMySQL;

import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Conexao {
	public static void main(String[] args) throws SQLException{
		// Criando conexão com a base de dados
				Connection con = DriverManager.getConnection(
						"jdbc:mysql://localhost:3306/testes", "root", "senha");

				// O "ResultSet" recebe um resultado e o organiza, permitindo
				// reaver os dados linha por linha um a um
				ResultSet rs = con.getMetaData().getTables(null, null, null,
						new String[] { "TABLE" });
				while (rs.next()) { // enquanto houver linhas de resultado, pegue a
									// próxima.
					// Recebe os resultados da coluna TABLE_NAME
					System.out.println(rs.getString("TABLE_NAME"));
				}

				// Finaliza a conexão com a base de dados
				con.close();
	}

}
