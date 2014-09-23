
public class exercicioNove {

	public static void main(String[] args) {
	
		int[] rolagens = new int [6];
		
			
		for(int i=0; i<1000000; i++){
			//Uma forma reduzida de usar o codigo abaixo rolagens[exercicioOito.rolar()-1]++;
			int sorteio = exercicioOito.rolar();
			int posicao = sorteio - 1;
			rolagens [posicao] = rolagens [posicao] +1;
			
		}
		for (int i = 0; i < rolagens.length; i++){
			System.out.printf("Face %d foi sorteada %d vezes\n", i + 1, rolagens[i]);
		
		}
	}
	
}