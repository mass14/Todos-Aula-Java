package Receita;

import java.util.ArrayList;

public class TesteReceita {
	public static void main(String[] args) {
		Receita bolo = new Receita("Bolo");
		
		bolo.adicionaIngrediente(new Ingrediente("Farinha com fermento", 1000.0f));
		bolo.adicionaIngrediente(new Ingrediente("Ovos", 9));
		bolo.adicionaIngrediente(new Ingrediente("Leite", 1.0f));
		bolo.adicionaIngrediente(new Ingrediente("Chocolate", 500.0f));
		
		
		ArrayList<Ingrediente> dispensa = new ArrayList<>();
		dispensa.add(new Ingrediente("farinha com fermento", 1100.0f));
		dispensa.add(new Ingrediente("Ovos", 9));
		dispensa.add(new Ingrediente("Leite", 1.0f));
		dispensa.add(new Ingrediente("Chocolate", 500.0f));
		dispensa.add(new Ingrediente("Caramelo", 5000.0f));
		
		System.out.println(bolo.possoPreparar(dispensa) ? "Pronto" : "Não dá para fazer");
		
	}
}
