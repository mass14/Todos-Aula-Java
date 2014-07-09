import java.util.*;
public class ExercicioDezCorreto {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner k = new Scanner(System.in);
		
		int unidade;
		double t;
		System.out.println("Digite 1 caso a temperatura digitada esteja em Celsius e 2 caso a temperatura digitada esteja em farenheit:");
		unidade = k.nextInt();
		switch (unidade) {
		case 1 : 
			System.out.println(" Digite a temperatura em Celsius:");
			t = k.nextDouble();
			System.out.println(farenheit(t));
			break;
			
		case 2:
			System.out.println(" Digite a temperatura em Fareheit:");
			t = k.nextDouble();
			System.out.println(celsius(t));
			break;
		
		default: 
			System.out.println("Valor digitado invalido");
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
