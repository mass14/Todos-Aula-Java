package oo.exercicios;

public class PaisFeliz {
	
	public static void main(String[] args) {
		// a)
		Pais brasil = new Pais("Brasil", "Brasilia", 8515767.049);
		Pais bolivia = new Pais("Bolivia", "Sucre", 1098581);
		Pais chile = new Pais("Chile", "Santiago", 756950);
		Pais colombia = new Pais("Colombia", "Bogotá", 1138914);
		
		// c)
		System.out.println("c)\n");
		System.out.println(brasil.equals(brasil));
		System.out.println(brasil.equals(bolivia));
		System.out.println(chile.equals(chile));
		
		// d)
		brasil.setFronteiras(bolivia, colombia);
		bolivia.setFronteiras(brasil, chile);
		chile.setFronteiras(bolivia, chile);
		colombia.setFronteiras(brasil);
		
		// e)
		System.out.println("e)\n");
		imprimeFronteira(brasil.getFronteiras());
		imprimeFronteira(bolivia.getFronteiras());
		imprimeFronteira(chile.getFronteiras());
		imprimeFronteira(colombia.getFronteiras());
		
		// f)
		System.out.println("f)\n");
		imprimeFronteira(brasil.vizinhosEmComum(chile));
		imprimeFronteira(colombia.vizinhosEmComum(bolivia));
	}	
	
	private static void imprimeFronteira(Pais[] paises) {
		for(Pais pais : paises) {
			System.out.print(pais.getNome() + " ");
		}
		System.out.println();
	}
}
