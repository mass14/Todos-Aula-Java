import java.util.*;
public class exercicioOnze {
	
	public static void main (String [] args){
		Scanner k = new Scanner (System.in);
		
		double a, b, c;
		System.out.println("Digite a nota da primeira prova:");
		a = k.nextDouble();
		System.out.println("Digite a nota da segunda prova:");
		b = k.nextDouble();
		System.out.println("Digite a nota da terceira prova");
		c = k.nextDouble();
		
		System.out.print("A media das duas maiores notas é:" + media(a, b, c));
					
		k.close();
	}
	public static double media (double a, double b, double c){
		double mediaTres = (a+b+c)/3;
		System.out.println("A média das três notas é:" + mediaTres);
		
		double maiorUm = Math.max(a, b);
		double maiorDois = Math.max(Math.min(a,b), c);
		
		System.out.println("A maior nota é:" + Math.max(maiorUm, maiorDois));
		System.out.println("A menor nota é:" + Math.min(Math.min(a,b), c));
		
		double mediaDois = (maiorUm + maiorDois)/2;
		
				
		return mediaDois;
		
	}
	
}
