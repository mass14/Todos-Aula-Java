import java.util.*;
public class exercicioDois {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner k = new Scanner(System.in);
		int valDelta;
		int a, b, c;
		System.out.println("Digite o numero da variavel a:");
		a = k.nextInt();
		System.out.println("Digite o numero da variavel b:");
		b = k.nextInt();
		System.out.println("Digite o numero da variavel c:");
		c = k.nextInt();
		
		valDelta = calcDelta(a, b, c);
		System.out.println("O valor do Delta para os valores informados é: ");
		System.out.println(valDelta);
		
		k.close();
	}
	public static int calcDelta(int a, int b, int c){
		int del = b*b-4*a*c;
		return del;
	}
}
