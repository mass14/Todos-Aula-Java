import java.util.*;

public class exercicioQuatro {

	public static void main(String[] args) {
		
		Scanner k = new Scanner(System.in);
		int a, b;

		System.out.println("Digite o primeiro numero:");
		a = k.nextInt();
		System.out.println("Digite o segundo numero:");
		b = k.nextInt();

		if (maiorValor(a, b) != Integer.MIN_VALUE) {
			System.out.println("O maior numero digitado � " + maiorValor(a, b));
		} else {
			System.out.println("Os numeros s�o iguais!");
		}

		k.close();

	}

	public static int maiorValor(int a, int b) {
		int maiorVal = 0;
		if (a > b) {
			maiorVal = a;
		} else if (a < b) {
			maiorVal = b;
		} else {
			maiorVal = Integer.MIN_VALUE;
		}
		return maiorVal;
	}
}
