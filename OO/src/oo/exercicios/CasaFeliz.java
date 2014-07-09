package oo.exercicios;

public class CasaFeliz {

	public static void main(String[] args) {
		Casa casa = new Casa();
		casa.pinta("verde");
		
		Porta porta1 = new Porta();
		porta1.pinta("vermelho");
		porta1.abre();
		casa.setPorta1(porta1);
		
		casa.setPorta2(new Porta());
		casa.getPorta2().abre();
		casa.getPorta2().pinta("amarelo");
		
		casa.getPorta1().fecha();
		
		System.out.println(casa.quantasPortasEstaoAbertas());
		System.out.println(casa.totalDePortas());

	}

}
