package conexaoMySQL;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class AquisicaoDeDados {

	public static void main(String[] args) throws SQLException {
		// Criando conexão com a base de dados
		Connection con = DriverManager.getConnection(
				"jdbc:mysql://localhost:3306/testes", "root", "senha");

		System.out.println("Statement");
		// Objeto criado para criar uma instrução SQL
		Statement stmt = con.createStatement();

		// O "ResultSet" recebe um resultado e o organiza, permitindo
		// reaver os dados linha por linha um a um
		ResultSet rs = stmt.executeQuery("SELECT * FROM livros");
		while (rs.next()) { // enquanto houver linhas de resultado, mover para a próxima.
			// Recebe os resultados da coluna com indice 3 ("titulo")
			System.out.println(rs.getString(3));
		}

		rs.beforeFirst(); // move o cursor para antes da primeira linha
		while (rs.next()) { // enquanto houver linhas de resultado, 
			// Recebe os resultados da coluna com o nome ("titulo")
			System.out.println(rs.getString("titulo"));
		}
		
		// ------------------------------------------------------
		System.out.println("\nPrepared Statement");
		
		String sql = "SELECT * FROM autores WHERE nome LIKE ? AND pais LIKE ?";
		
		// O PreparedStatement permite inserir parametros nas consultas SQL.
		PreparedStatement preparedStatement = con.prepareStatement(sql);
		preparedStatement.setString(1, "%ssor%");
		preparedStatement.setString(2, "%brasi%");
		
		rs = preparedStatement.executeQuery();
		while (rs.next()) { // enquanto houver linhas de resultado, mover para a próxima.
			// Recebe os resultados da coluna com indice 3 ("titulo")
			System.out.println(rs.getString("nome"));
		}
		
		// Finaliza a conexão com a base de dados
		con.close();

	}

}
