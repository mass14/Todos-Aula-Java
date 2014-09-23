import java.util.Scanner;


public class exercicioSete {

	public static void main(String[] args) {
		
		Scanner k = new Scanner(System.in);
		System.out.println("Digite um numero:");
		int z = k.nextInt();
		System.out.println("Digite um numero:");
		int x = k.nextInt();
		System.out.println("Digite um numero:");
		int y = k.nextInt();
		
		System.out.print(min(min(z,x), y));
		
		k.close();
	}
	public static int min(int a, int b){
		return Math.min(a, b);
	}

}
