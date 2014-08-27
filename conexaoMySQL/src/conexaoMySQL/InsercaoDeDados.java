package conexaoMySQL;


	import java.sql.Connection;
	import java.sql.DriverManager;
	import java.sql.PreparedStatement;
	import java.sql.SQLException;

	public class InsercaoDeDados {

		public static void main(String[] args) throws SQLException {
			Connection con = criarConexao();
			addAutor(con, "Nassor Paulino da Silva", "Brasil");
			addAutor(con, "John Boyne", "Irlanda");
		}

		private static void addAutor(Connection con, String autor, String pais) throws SQLException {
			// SQL para inserir valores
			String insertSQL = "INSERT INTO autores" + "(nome, pais) VALUES" + "(?,?)";

			PreparedStatement preparedStatement = con.prepareStatement(insertSQL);
			preparedStatement.setString(1, autor);
			preparedStatement.setString(2, pais);
			preparedStatement.executeUpdate();
		}

		// Criando conexão com a base de dados
		private static Connection criarConexao() throws SQLException {
			Connection con = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/testes", "root", "");
			return con;
		}

	}

