package conta;

import java.sql.SQLException;
import java.util.List;
import conta.Conta;

public interface ContaDAO {

	public void save(Conta c) throws SQLException;
	public void delete(int id) throws SQLException;
	public List<Conta> list() throws SQLException;
	public List<Conta> search(String nome) throws SQLException;
	public Conta find(int id) throws SQLException;
	
}
