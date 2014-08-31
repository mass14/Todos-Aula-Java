package oficina;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Funcionarios {

	public static void main(String[] args) throws SQLException{
		Connection con = Conexao.criarConexao();
		addFuncionarios(con, "Mariá Sumienski", "rua blablabla", "12341908", 1);
		selectFuncionarios(con, "%bla%");
		// Finaliza a conexão com a base de dados
		con.close();

	}

	private static void addFuncionarios(Connection con, String nome,
			String endereco, String telefone, int categoria_id) throws SQLException {
		// SQL para inserir valores
		String insertSQL = "INSERT INTO funcionarios(nome, endereco, telefone, categoria_id) VALUES (?,?,?,?)";

		PreparedStatement preparedStatement = con.prepareStatement(insertSQL);
		preparedStatement.setString(1, nome);
		preparedStatement.setString(2, endereco);
		preparedStatement.setString(3, telefone);
		preparedStatement.setInt(4, categoria_id);
		preparedStatement.executeUpdate();
	}

	private static void selectFuncionarios(Connection con, String endereco) 
			throws SQLException {
		String sql = "SELECT * FROM funcionarios WHERE endereco LIKE ? ";

		// O PreparedStatement permite inserir parametros nas consultas SQL.
		PreparedStatement preparedStatement = con.prepareStatement(sql);
		preparedStatement.setString(1, endereco);

		ResultSet rs = preparedStatement.executeQuery();
		while (rs.next()) { // enquanto houver linhas de resultado, mover para a
							// próxima.
			// Recebe os resultados da coluna com indice 3 ("titulo")
			System.out.println(rs.getString(1) + " " + rs.getString(2) + " "
					+ rs.getString(3));
		}
	}
}
