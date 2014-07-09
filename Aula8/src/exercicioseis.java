/*Escreva um programa que lê um array de inteiros de tamanho
10 a e imprime um array de boolean onde, cada posição indique
true se o elemento da posição correspondente de a é positivo e
false caso seja negativo ou zero.
*/
public class exercicioseis {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a[] = {1,2,3,4,-5,-6,-6,-6,-6,-6,};
		boolean b[] = new boolean[10];
		int i;
		for (i = 0; i < 9; i++) {
			if (a[i] <= 0) {
				b[i] = false;
			} else {
				b[i] = true;
			}
			System.out.println(b[i]);
		}
		
/*		boolean[] c = new boolean[a.length];
		for (int j = 0; j <a.length; i++){
			if(a[i]>0){
				c[j] = true;}}
		for (int j = 0; j<a.length; j++){
			System.out.println(a[i] + ":" + (c[j]? "verdadeiro" : "falso"));
		}
				
				*/
			}
			}


