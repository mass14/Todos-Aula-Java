package oo;

public class ExemploHumano {

	public static void main(String[] args) {
		/* Objeto / instância de uma classe. Um objeto é capaz de armazenar estados através de seus atributos e reagir 
		 * a mensagens enviadas a ele, assim como se relacionar e enviar mensagens a outros objetos. Exemplo de objetos
		 * da classe Humanos: João, José, Maria
		 */
		Humano manu = new Humano();
		manu.setNome("Emmanuella");
		System.out.println(manu.getNome());
		System.out.println(manu.getIdade());
		System.out.println(manu.isMorto());
		
		HumanoComConstrutor nassor = new HumanoComConstrutor("Nassor", 29);
		
		System.out.println(nassor.getNome());
		System.out.println(nassor.getIdade());
		
		/* Mensagem é uma chamada a um objeto para invocar um de seus métodos, activando um comportamento descrito por
		 * sua classe. Também pode ser direcionada diretamente a uma classe (através de uma invocação a um método
		 * estático)
		 */
		nassor.fazerAniversario();
		System.out.println(nassor.getIdade());
		
		nassor.matar();
		System.out.println(nassor.isMortoStr());
		nassor.ressucitar();
		System.out.println(nassor.isMortoStr());

	}

}
