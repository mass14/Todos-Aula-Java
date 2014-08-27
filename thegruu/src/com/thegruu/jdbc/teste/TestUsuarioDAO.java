package com.thegruu.jdbc.teste;

import java.util.List;
import java.util.Scanner;

import com.thegruu.entidades.Usuario;
import com.thegruu.jdbc.UsuarioDAO;

public class TestUsuarioDAO {

	public static void main(String[] args) {
		
		Scanner o = new Scanner(System.in);
		System.out.print("\nEscolha uma opção: \n"
				+ "1 - Inserir\n"
				+ "2 - Alterar\n"
				+ "3 - Excluir\n"
				+ "4 - Listar\n\n"
				+ "Opção: ");
		
		int op = o.nextInt();

		switch(op){
		
		case 1:
			testCadastrar();
			break;
		case 2:
			testAlterar();
			break;
		case 3:
			testExcluir();
			break;
		case 4:
			testBuscarTodos();
			break;
		default:
			System.out.println("Opção inválida");
		
		}
		
//		testCadastrar();
//		testAlterar();
//		testExcluir();
//		testBuscarTodos();		

	}

	private static void testCadastrar() {
		
		Scanner k = new Scanner(System.in);
		System.out.println("Digite o nome: ");
		String nome = k.nextLine();
		System.out.println("Digite o Login: ");
		String login = k.nextLine();
		System.out.println("Digite a senha: ");
		String senha = k.nextLine();
		
		k.close();
		
		Usuario usu = new Usuario();
		usu.setNome(nome);
		usu.setLogin(login);
		usu.setSenha(senha);
		
		UsuarioDAO usuDao = new UsuarioDAO();
		usuDao.cadastrar(usu);
	}
	
	private static void testAlterar(){
		
		System.out.println("ALTERAÇÃO DE CADASTRO");
		System.out.println("===========================================\n");
		
		Scanner ka = new Scanner(System.in);
		System.out.print("Digite o código: ");
		int id = ka.nextInt();
	
		Scanner ka2 = new Scanner(System.in);
		System.out.print("Digite o nome: ");
		String nome = ka2.nextLine();
		System.out.print("Digite o Login: ");
		String login = ka2.nextLine();
		System.out.print("Digite a senha: ");
		String senha = ka2.nextLine();
	
		Usuario usu = new Usuario();
		usu.setId(id);
		usu.setNome(nome);
		usu.setLogin(login);
		usu.setSenha(senha);
		
		UsuarioDAO usuDao = new UsuarioDAO();
		usuDao.alterar(usu);
		
		
	}
	
	private static void testExcluir(){
		
		System.out.println("EXCLUSAO DE CADASTRO");
		System.out.println("===========================================\n");
		
		Scanner ke = new Scanner(System.in);
		System.out.print("Digite o código: ");
		int id = ke.nextInt();
		
		Usuario usu = new Usuario();
		usu.setId(id);

		UsuarioDAO usuDao = new UsuarioDAO();
		usuDao.excluir(usu);
		
	}
	
	private static void testBuscarTodos(){
		
		UsuarioDAO usuDao = new UsuarioDAO();
		List<Usuario> listaResultado = usuDao.buscarTodos();
		
		System.out.println("LISTAGEM DE CADASTROS");
		System.out.println("======================================================================================\n");
	
		for(Usuario u : listaResultado){
			System.out.println(u.getId() + " - " + u.getNome() + " - " + u.getLogin() + " - " + u.getSenha());
		}
		

		
	}

}