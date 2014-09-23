package conta;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ContaDAOMySQL extends Conexao implements ContaDAO{

	public ContaDAOMySQL () throws SQLException{
		super();
	}
	public void save(Conta c) throws SQLException {
		if (c.getId() == 0){
			String insertSql =  "INSERT INTO contas(saldo, limite, nome) "
					+ "VALUES (?,?,?)";
			PreparedStatement preparedStatement = con.prepareStatement(insertSql);
			preparedStatement.setDouble(1,c.getSaldo());
			preparedStatement.setDouble(2, c.getLimite());
			preparedStatement.setString(3, c.getNome());
			preparedStatement.executeUpdate();
		}else{
			String updateSql = "UPDATE contas"
					+ "SET saldo=?, limite=?, nome=?"
					+ "WHERE id=?";
			PreparedStatement preparedStatement = con.prepareStatement(updateSql);
			preparedStatement.setDouble(1,c.getSaldo());
			preparedStatement.setDouble(2, c.getLimite());
			preparedStatement.setString(3, c.getNome());
		}
	}
	public void delete(int id) throws SQLException{
		String deleteSql= "DELETE FROM contas WHERE id=?";
		PreparedStatement prepareStatement = con.prepareStatement(deleteSql);
	}
	
	public List<Conta> list() throws SQLException {
		String selectSql = "SELECT * FROM contas";
		PreparedStatement prepareStatement  = con.prepareStatement(selectSql);
		
		ResultSet rs = prepareStatement.executeQuery();
		List<Conta> co = new ArrayList<>();
		while(rs.next()){
			co.add(new Conta(rs.getInt("id"), rs.getDouble("saldo"), rs
					.getDouble("limite"), rs.getString("nome")));
		}
		return null;
	}

	public List<Conta> search(String nome) throws SQLException {
		
		return null;
	}

	public Conta find(int id) throws SQLException {
		
		return null;
	}
	
}
