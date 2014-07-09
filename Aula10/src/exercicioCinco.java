import java.util.Scanner;


public class exercicioCinco {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner k = new Scanner(System.in);
		int a, b;

		System.out.println("Digite o primeiro numero:");
		a = k.nextInt();
		System.out.println("Digite o segundo numero:");
		b = k.nextInt();

		if (menorValor(a, b) != 0) {
			System.out.println("O menor numero digitado é " + menorValor(a, b));
		} else {
			System.out.println("Os numeros são iguais!");
		}

		k.close();

	}

	public static int menorValor(int a, int b) {
		int menorVal = 0;
		if (a > b) {
			menorVal = b;
		} else if (a < b) {
			menorVal = a;
		} else {
			menorVal = 0;
		}
		return menorVal;
	}

}
