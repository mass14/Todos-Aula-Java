package oficina;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Categorias {

	public static void main(String[] args) throws SQLException {
		Connection con = Conexao.criarConexao();
		addCategorias(con, "motor", 10.60);
		selectCategorias(con, 10.60);

		// Finaliza a conexão com a base de dados
		con.close();

	}

	private static void addCategorias(Connection con, String nome,
			Double custo_hora) throws SQLException {
		// SQL para inserir valores
		String insertSQL = "INSERT INTO clientes(designacao, custo_hora) VALUES (?,?,?)";

		PreparedStatement preparedStatement = con.prepareStatement(insertSQL);
		preparedStatement.setString(1, nome);
		preparedStatement.setDouble(2, custo_hora);

		preparedStatement.executeUpdate();
	}

	private static void selectCategorias(Connection con, Double custo_hora)
			throws SQLException {
		String sql = "SELECT * FROM categoras WHERE custo_hora > ? ";

		// O PreparedStatement permite inserir parametros nas consultas SQL.
		PreparedStatement preparedStatement = con.prepareStatement(sql);
		preparedStatement.setDouble(1, custo_hora);

		ResultSet rs = preparedStatement.executeQuery();
		while (rs.next()) { // enquanto houver linhas de resultado, mover para a
							// próxima.
			// Recebe os resultados da coluna com indice 3 ("titulo")
			System.out.println(rs.getString(1) + " " + rs.getString(2) + " "
					+ rs.getString(3));
		}

	}

}
