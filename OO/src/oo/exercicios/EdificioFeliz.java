package oo.exercicios;

public class EdificioFeliz {

	public static void main(String[] args) {
		Edificio edificio = new Edificio(); // criei o edifio
		edificio.pinta("Verde");            // pintei ele de verde
		edificio.setPortas(new Porta[6]);   // Adicionei 6 portas a ele
		edificio.adicionarPorta(new Porta()); // 1
		edificio.adicionarPorta(new Porta()); // 2
		edificio.adicionarPorta(new Porta()); // 3
		edificio.adicionarPorta(new Porta()); // 4
		edificio.adicionarPorta(new Porta()); // 5
		edificio.adicionarPorta(new Porta()); // 6
		edificio.adicionarPorta(new Porta()); // 7 (Não vai se inserida)
		
//		edificio.getPortas()[0].abre();
//		edificio.getPortas()[3].abre();
//		edificio.getPorta(2).abre();
		
		edificio.abrirPortas(3, 0, 2);
		
		System.out.println(edificio.totalDePortas());
		System.out.println(edificio.quantasPortasEstaoAbertas());

	}

}
