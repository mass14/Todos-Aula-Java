package com.thegruu.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.thegruu.entidades.Usuario;

public class UsuarioDAO {
	
	private Connection con = Conexao.getConnection();
	
	public void cadastrar(Usuario usuario){
		//monta sql
		String sql = "INSERT INTO USUARIOS (nome, login, senha) values (?, ?, md5(?))";
		//constroi preparestatment com sql
		try {
			PreparedStatement preparador = con.prepareStatement(sql);
			preparador.setString(1, usuario.getNome());
			preparador.setString(2, usuario.getLogin());
			preparador.setString(3, usuario.getSenha());
			
			preparador.execute();
			preparador.close();
			
			System.out.println("Cadastrado!");
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
	}
	
	public void alterar(Usuario usuario){
		//monta sql
		String sql = "UPDATE USUARIOS SET nome=?, login=?, senha=md5(?) WHERE id=?";
		//constroi preparestatment com sql
		try {
			PreparedStatement preparador = con.prepareStatement(sql);
			preparador.setString(1, usuario.getNome());
			preparador.setString(2, usuario.getLogin());
			preparador.setString(3, usuario.getSenha());
			preparador.setInt(4, usuario.getId());
			
			preparador.execute();
			preparador.close();
			
			System.out.println("Alterado!");
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
	}
	
	public void excluir(Usuario usuario){
		//monta sql
		String sql = "DELETE FROM USUARIOS WHERE id=?";
		//constroi preparestatment com sql
		try {
			PreparedStatement preparador = con.prepareStatement(sql);
			preparador.setInt(1, usuario.getId());
			
			preparador.execute();
			preparador.close();
			
			System.out.println("Excluído!");
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
	}
	
	public List<Usuario> buscarTodos(){
		//monta sql
		String sql = "SELECT * FROM USUARIOS";
		//constroi preparestatment com sql
		List<Usuario> lista = new ArrayList<Usuario>();
		
		try {
			PreparedStatement preparador = con.prepareStatement(sql);
			
			ResultSet resultado = preparador.executeQuery();
			
			while(resultado.next()){
				
				Usuario usu = new Usuario();
				usu.setId(resultado.getInt("id")); //valor da coluna id
				usu.setNome(resultado.getString("nome")); //valor da coluna nome
				usu.setLogin(resultado.getString("login")); //valor da coluna login
				usu.setSenha(resultado.getString("senha")); //valor da coluna senha
				
				lista.add(usu);
			}
			
			preparador.close();
			
			System.out.println("Lista de Usuários");
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		return lista;
	}
	
	public Usuario buscaPorId(Integer id){
		String sql = "SELECT * FROM Usuarios WHERE ID=?";
		Usuario usu = null;
		try {
			PreparedStatement preparador = con.prepareStatement(sql);
			preparador.setInt(1, id);
			
			ResultSet resultado = preparador.executeQuery();
			
			if(resultado.next()){
				
				usu = new Usuario();
				usu.setId(resultado.getInt("id")); //valor da coluna id
				usu.setNome(resultado.getString("nome")); //valor da coluna nome
				usu.setLogin(resultado.getString("login")); //valor da coluna login
				usu.setSenha(resultado.getString("senha")); //valor da coluna senha
				
			}
			
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return usu;
		
	}

}
