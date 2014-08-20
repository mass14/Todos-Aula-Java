package matrizesExercicio;

public class matrizMain {

	public static void main(String[] args) {
		Matrizes m = new Matrizes();
		m.somaItenMtriz();
		for (double a: m.minMaxMed()){
			System.out.println(a);
		}
		m.contatos();

	}

}
