package Receita;

import java.util.ArrayList;

public class Receita {
	private ArrayList<Ingrediente> ingredientes;
	String nome;
	
	// Construtor
	public Receita(String nome) { 
		this.nome = nome;
		ingredientes = new ArrayList<>();
	}

	// Retorna uma lista com os ingredientes da receita (lista de
	// instâncias da classe Ingrediente).

	public ArrayList<Ingrediente> ingredientes() {
		return this.ingredientes;

	}

	// Acrescenta um ingrediente à receita

	public void adicionaIngrediente(Ingrediente i) {
		this.ingredientes.add(i);
	}

	// Acrescenta um conjunto de ingredientes à receita

	public void adicionaIngredientes(ArrayList<Ingrediente> ingredientes) {
		this.ingredientes.addAll(ingredientes);

	}

	// Verifica se é possível preparar a receita com um conjunto de ingredientes
	// Retorna verdadeiro se o conjunto passado como parâmetro contiver todos
	// os ingredientes necessários para o preparo, em quantidade suficiente.

	public boolean possoPreparar(ArrayList<Ingrediente> ingredientes) {
		int totalNecessario = this.ingredientes.size();
		int totalDisponiveis = 0;
		if (totalNecessario > ingredientes.size()) {
			return false;
		}
		for (Ingrediente iReceita : this.ingredientes) {
			for (Ingrediente disponiveis : ingredientes) {
				if (iReceita.getNome().equalsIgnoreCase(getNome())) {
					if (disponiveis.getQuantidade() >= iReceita.getQuantidade()) {
						totalDisponiveis++;
					} else {
						return false;
					}
				}
			}
		}

		if (totalNecessario == totalDisponiveis) {
			return true;
		}
		return false;
	}

	// Retorna um string com todos os ingredientes, um por linha, sendo cada
	// ingrediente no formato especificado na classe Ingrediente

	public String toString(){
	String str="";
	for(Ingrediente i : this.ingredientes){
		str+=i.toString()+"\n";
	}
	return str;
	}
	// Retorna o nome

	public String getNome(){
	return this.nome;
	}
	
}