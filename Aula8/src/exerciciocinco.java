/*Crie um programa que lê um array de inteiros de tamanho 10
e um valor inteiro e imprime a quantidade de vezes que x aparece
no array. */
public class exerciciocinco {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[]={1,2,3,4,5,6,6,6,6,6};
		int i;
		int totalRepete = 0;
		int x = 6;
		
		for(i=0; i < arr.length; i++){
			
			if(arr[i] == x){
				totalRepete++;
			}
		}
		System.out.println(totalRepete);
	}

}
