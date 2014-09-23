package oficina;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;


public class Veiculos {

	public static void main(String[] args) throws SQLException {
		Connection con = Conexao.criarConexao();
		Calendar aquisicao = Calendar.getInstance();
		aquisicao.set(2013, 04, 20);
		addVeiculos(con, 1, aquisicao.getTime());
		selectVeiculos(con, 1);

		// Finaliza a conexão com a base de dados
		con.close();

	}
	
	private static void addVeiculos(Connection con, int cliente_id,
			Date aquisicao) throws SQLException {
		// SQL para inserir valores
		String insertSQL = "INSERT INTO veiculos(cliente_id, aquisicao) VALUES (?,?)";

		PreparedStatement preparedStatement = con.prepareStatement(insertSQL);
		preparedStatement.setInt(1, cliente_id);
		preparedStatement.setDate(2,new java.sql.Date(aquisicao.getTime()));
		preparedStatement.executeUpdate();
	}

	private static void selectVeiculos(Connection con, int cliente_id)
			throws SQLException {
		String sql = "SELECT * FROM veiculos WHERE cliente_id LIKE ? ";

		// O PreparedStatement permite inserir parametros nas consultas SQL.
		PreparedStatement preparedStatement = con.prepareStatement(sql);
		preparedStatement.setInt(1, cliente_id);

		ResultSet rs = preparedStatement.executeQuery();
		while (rs.next()) { // enquanto houver linhas de resultado, mover para a
							// próxima.
			// Recebe os resultados da coluna com indice 3 ("titulo")
			System.out.println(rs.getString(1) + " " + rs.getString(2) + " "
					+ rs.getString(3));
		}
	}

}
