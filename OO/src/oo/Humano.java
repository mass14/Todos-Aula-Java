package oo;

/* http://pt.wikipedia.org/wiki/Orienta%C3%A7%C3%A3o_a_objetos
 * 
 * A orientação a objetos é um paradigma de análise, projeto e programação de sistemas de 
 * software baseado na composição e interação entre diversas unidades de software chamadas 
 * de objetos.
 * 
 * Classe representa um conjunto de objetos com características afins. Uma classe define o
 * comportamento dos objetos através de seus métodos, e quais estados ele é capaz de manter
 * através de seus atributos. Exemplo de classe: Os seres humanos
 */
public class Humano {
	
	/* Atributo são características de um objeto. Basicamente a estrutura de dados que vai 
	 * representar a classe. 
	 * Exemplos:
	 * Funcionário: nome, endereço, telefone, CPF,...;
	 * Carro: nome, marca, ano, cor, …;
	 * Livro: autor, editora, ano.
	 * 
	 * Por sua vez, os atributos possuem valores. Por exemplo, o atributo cor pode conter o 
	 * valor azul. O conjunto de valores dos atributos de um determinado objeto é chamado 
	 * de estado
	 */
	private String nome;
	private int idade;
	private boolean morto;
	
	/* Método definem as habilidades dos objetos. Bidu é uma instância da classe Cachorro, portanto tem habilidade para
	 * latir, implementada através do método deUmLatido. Um método em uma classe é apenas uma definição. A ação só
	 * ocorre quando o método é invocado através do objeto, no caso Bidu. Dentro do programa, a utilização de um método
	 * deve afetar apenas um objeto em particular; Todos os cachorros podem latir, mas você quer que apenas Bidu dê o
	 * latido. Normalmente, uma classe possui diversos métodos, que no caso da classe Cachorro poderiam ser sente, coma 
	 * e morda
	 */
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
