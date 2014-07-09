import java.util.*;

public class exercicoDez {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner k = new Scanner(System.in);
		String unidade;
		double t = 0;
		System.out.println("A temperatura está em Celsius ou Farenheit:");
		unidade = k.next();

		if (unidade.equalsIgnoreCase("Celsius")) {
			System.out.println("Digite a temperatura");
			t = k.nextDouble();
			System.out.println(celsius(t));
		} else if (unidade.equalsIgnoreCase("Farenheit")) {
			System.out.println("Digite a temperatura");
			t = k.nextDouble();
			System.out.println(farenheit(t));
		} else {
			System.out.println("Unidade digitada não é valida! ");
			
		}
		k.close();

	}

	public static double celsius(double f) {
		double c = 5 * (f - 32) / 9;
		return c;
	}

	public static double farenheit(double c) {
		double f = (9 * c / 5) + 32;
		return f;
	}
}