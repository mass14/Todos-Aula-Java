package oficina;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class PecasReparos {

	public static void main(String[] args) throws SQLException {
		Connection con = Conexao.criarConexao();
		addPecasReparos(con, 1, 1);
		selectPecasReparos(con, 1);

		// Finaliza a conexão com a base de dados
		con.close();

	}

	private static void addPecasReparos(Connection con,  int peca_id, int reparo_id) throws SQLException {
		// SQL para inserir valores
		String insertSQL = "INSERT INTO pecas_reparos(peca_id, reparo_id) VALUES (?,?)";

		PreparedStatement preparedStatement = con.prepareStatement(insertSQL);
		preparedStatement.setInt(1, peca_id);
		preparedStatement.setInt(2, reparo_id);
		preparedStatement.executeUpdate();
	}

	private static void selectPecasReparos(Connection con, int peca_id)
			throws SQLException {
		String sql = "SELECT * FROM pecas_reparos WHERE peca_id = ? ";

		// O PreparedStatement permite inserir parametros nas consultas SQL.
		PreparedStatement preparedStatement = con.prepareStatement(sql);
		preparedStatement.setDouble(1, peca_id);

		ResultSet rs = preparedStatement.executeQuery();
		while (rs.next()) { // enquanto houver linhas de resultado, mover para a
							// próxima.
			// Recebe os resultados da coluna com indice 3 ("titulo")
			System.out.println(rs.getString(1) + " " + rs.getString(2));
		}
	}
}
