package oficina;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Clientes {

	public static void main(String[] args) throws SQLException {
		Connection con = Conexao.criarConexao();
		addClientes(con, "Mariá Sumienski", "rua blablabla", "12341908");
		selectClientes(con, "%ri%");

		// Finaliza a conexão com a base de dados
		con.close();

	}

	private static void addClientes(Connection con, String nome,
			String endereco, String telefone) throws SQLException {
		// SQL para inserir valores
		String insertSQL = "INSERT INTO clientes(nome, endereco, telefone) VALUES (?,?,?)";

		PreparedStatement preparedStatement = con.prepareStatement(insertSQL);
		preparedStatement.setString(1, nome);
		preparedStatement.setString(2, endereco);
		preparedStatement.setString(3, telefone);
		preparedStatement.executeUpdate();
	}

	private static void selectClientes(Connection con, String nome)
			throws SQLException {
		String sql = "SELECT * FROM clientes WHERE nome LIKE ? ";

		// O PreparedStatement permite inserir parametros nas consultas SQL.
		PreparedStatement preparedStatement = con.prepareStatement(sql);
		preparedStatement.setString(1, nome);

		ResultSet rs = preparedStatement.executeQuery();
		while (rs.next()) { // enquanto houver linhas de resultado, mover para a
							// próxima.
			// Recebe os resultados da coluna com indice 3 ("titulo")
			System.out.println(rs.getString(1) + " " + rs.getString(2) + " "
					+ rs.getString(3));
		}
	}
}
