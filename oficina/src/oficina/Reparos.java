package oficina;


	import java.sql.Connection;
	import java.sql.ResultSet;
	import java.sql.PreparedStatement;
	import java.sql.SQLException;
	import java.text.SimpleDateFormat;

	public class Reparos{

		public static void main(String[] args) throws SQLException {
			Connection con = Conexao.criarConexao();
			SimpleDateFormat dt = new SimpleDateFormat("dd-MM-yyyy");
			String efetuado_em = dt.format("20/04/2014");
			addReparos(con, 1, efetuado_em);
			selectReparos(con, 1);

			// Finaliza a conexão com a base de dados
			con.close();

		}

		private static void addReparos(Connection con, int veiculo_id,
				String efetuado_em) throws SQLException {
			// SQL para inserir valores
			String insertSQL = "INSERT INTO veiculos(veiculo_id, efetuado_em) VALUES (?,?)";

			PreparedStatement preparedStatement = con.prepareStatement(insertSQL);
			preparedStatement.setInt(1, veiculo_id);
			preparedStatement.setString(2, efetuado_em);
			preparedStatement.executeUpdate();
		}

		private static void selectReparos(Connection con, int veiculo_id)
				throws SQLException {
			String sql = "SELECT * FROM veiculos WHERE cliente_id = ? ";

			// O PreparedStatement permite inserir parametros nas consultas SQL.
			PreparedStatement preparedStatement = con.prepareStatement(sql);
			preparedStatement.setInt(1,veiculo_id);

			ResultSet rs = preparedStatement.executeQuery();
			while (rs.next()) { // enquanto houver linhas de resultado, mover para a
								// próxima.
				// Recebe os resultados da coluna com indice 3 ("titulo")
				System.out.println(rs.getString(1) + " " + rs.getString(2) + " "
						+ rs.getString(3));
			}
		}

	}

