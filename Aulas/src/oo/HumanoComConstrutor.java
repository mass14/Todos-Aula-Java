package oo;

public class HumanoComConstrutor {
	private String nome;
	private int idade;
	private boolean morto;
	
	/*
	 * O construtor de uma determinada classe é constituído por uma função (método, subprograma) 
	 * sem um tipo primitivo definido. Este tipo de função não tem uma funcionalidade direta de 
	 * programação nas atuais linguagens orientadas à objeto, sendo de fato, somente para a 
	 * inicialização de variáveis com um valor default.
	 */
	public HumanoComConstrutor(String nome, int idade) {
		this.nome = nome;
		this.idade = idade;
	}
	
	// A classe pode ter quantos métodos construtores forem necessários.
	public HumanoComConstrutor(String nome, int idade, boolean morto) {
		this.nome = nome;
		this.idade = idade;
		this.morto = morto;
	}
	
	public HumanoComConstrutor() {}
	
	public boolean isMorto() {
		return this.morto;
	}
	
	public String isMortoStr() {
		return this.morto ? "Morto" : "Vivo";
	}
	
	public String getNome() {
		return this.nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public void setIdade(int idade) {
		this.idade = idade;
	}
	
	public int getIdade() {
		return this.idade;
	}
	
	public void fazerAniversario() {
		this.idade += 1;
	}
	
	public void matar() {
		this.morto = true;
	}
	
	public void ressucitar() {
		this.morto = false;
	}

}
