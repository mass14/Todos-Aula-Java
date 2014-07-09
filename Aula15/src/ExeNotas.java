import java.util.*;

public class ExeNotas {

	public static void main(String[] args) {
		Scanner k = new Scanner(System.in);
		double[] notas = new double[3];
		for (int i = 0; i < notas.length; i++) {
			System.out.println("Digite a nota da " + (i + 1) + "a prova:");
			notas[i] = k.nextDouble();
		}

		System.out.printf("Media de todas as notas: %.2f", media(notas));
		System.out.println("\n As duas maiores notas sao:");

		double[] restMax = maioresNota(notas);
		System.out.printf("%.2f %.2f", restMax[0], restMax[1]);

		System.out.println("\nA media das duas maiores notas:");
		System.out.println(media(restMax));

		System.out.println("\nA menor nota é:");
		System.out.println(menorNota(notas));

		System.out.println("\nA maior nota é:");
		System.out.println(maiorNota(notas));

		k.close();
	}

	public static double media(double... notas) {
		double mediaNotas = 0;
		double somaNotas = 0;
		for (double nota : notas) {
			somaNotas += nota;
			mediaNotas = somaNotas / notas.length;

		}
		return mediaNotas;
	}

	public static double[] maioresNota(double... notas) {
		double[] maioresNotas = new double[2];

		double MaxUm = Math.max(notas[0], notas[1]);
		double MaxDois = Math.max(Math.min(notas[0], notas[1]), notas[2]);

		maioresNotas[0] = MaxUm;
		maioresNotas[1] = MaxDois;
		return maioresNotas;
	}

	public static double menorNota(double... notas) {

		double minNota = Math.min(Math.min(notas[0], notas[1]), notas[2]);
		return minNota;

	}

	public static double maiorNota(double... notas) {
		double maxNota = Math.max(Math.max(notas[0], notas[1]), notas[2]);
		return maxNota;
	}
}
