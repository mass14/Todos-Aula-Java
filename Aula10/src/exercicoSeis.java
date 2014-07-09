import java.util.*;
public class exercicoSeis {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner k = new Scanner(System.in);
		System.out.println("Digite um numero:");
		int z = k.nextInt();
		System.out.println("Digite um numero:");
		int x = k.nextInt();
		System.out.println("Digite um numero:");
		int y = k.nextInt();
		
		System.out.print(maior(z, x, y));
		
		k.close();
	}
	public static int maior(int a, int b, int c){
		return Math.max(Math.max(a, b),c);
		
	}

}
