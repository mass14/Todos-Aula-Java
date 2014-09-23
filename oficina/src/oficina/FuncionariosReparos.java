package oficina;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Time;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class FuncionariosReparos {

	public static void main(String[] args) throws SQLException, ParseException {
		Connection con = Conexao.criarConexao();
		SimpleDateFormat tm = new SimpleDateFormat("hh:mm");
		Date tempo_gasto = tm.parse("01:00");
		addFuncionariosReparos(con, 1, 1, tempo_gasto);
		selectFuncionariosReparos(con, 1);

		// Finaliza a conexão com a base de dados
		con.close();

	}

	private static void addFuncionariosReparos(Connection con, int funcionario_id, int reparo_id,
			Date tempo_gasto) throws SQLException {
		// SQL para inserir valores
		String insertSQL = "INSERT INTO funcionarios_reparos(funcionario_id, reparo_id, tempo_gasto) VALUES (?,?,?)";

		PreparedStatement preparedStatement = con.prepareStatement(insertSQL);
		preparedStatement.setInt(1, funcionario_id);
		preparedStatement.setInt(2, reparo_id);
		preparedStatement.setTime(3, new java.sql.Time(tempo_gasto.getTime()));
		preparedStatement.executeUpdate();
	}

	private static void selectFuncionariosReparos(Connection con, int reparo_id)
			throws SQLException {
		String sql = "SELECT * FROM funcionarios_reparos WHERE reparo_id LIKE ? ";

		// O PreparedStatement permite inserir parametros nas consultas SQL.
		PreparedStatement preparedStatement = con.prepareStatement(sql);
		preparedStatement.setInt(1, reparo_id);

		ResultSet rs = preparedStatement.executeQuery();
		while (rs.next()) { // enquanto houver linhas de resultado, mover para a
							// próxima.
			// Recebe os resultados da coluna com indice 3 ("titulo")
			System.out.println(rs.getString(1) + " " + rs.getString(2) + " "
					+ rs.getString(3));
		}
	}

}
