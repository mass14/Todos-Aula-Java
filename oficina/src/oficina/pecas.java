package oficina;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class pecas {

	public static void main(String[] args) throws SQLException {
		Connection con = Conexao.criarConexao();
		addPeca(con, "vela", 10.60, 5);
		selectPeca(con, 10.60);

		// Finaliza a conexão com a base de dados
		con.close();

	}

	private static void addPeca(Connection con, String designacao,
			Double custo, int estoque) throws SQLException {
		// SQL para inserir valores
		String insertSQL = "INSERT INTO pecas(designacao, custo, estoque) VALUES (?,?,?)";

		PreparedStatement preparedStatement = con.prepareStatement(insertSQL);
		preparedStatement.setString(1, designacao);
		preparedStatement.setDouble(2, custo);
		preparedStatement.setInt(3, estoque);
		preparedStatement.executeUpdate();
	}

	private static void selectPeca(Connection con, Double custo)
			throws SQLException {
		String sql = "SELECT * FROM pecas WHERE custo > ? ";

		// O PreparedStatement permite inserir parametros nas consultas SQL.
		PreparedStatement preparedStatement = con.prepareStatement(sql);
		preparedStatement.setDouble(1, custo);

		ResultSet rs = preparedStatement.executeQuery();
		while (rs.next()) { // enquanto houver linhas de resultado, mover para a
							// próxima.
			// Recebe os resultados da coluna com indice 3 ("titulo")
			System.out.println(rs.getString(1) + " " + rs.getString(2) + " "
					+ rs.getString(3));
		}

	}

}
