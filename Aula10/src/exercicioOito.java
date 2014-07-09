import java.util.*;
public class exercicioOito {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		for(int i = 0; i<100; i++){
		System.out.println(rolar());
		}
	}
	public static int rolar(){
		Random b = new Random();
		return b.nextInt(6)+1;// o random gera um numero de 0 a 5, como é adicionado 1 o zero vira 1 e o 5vira 6(todos sao acrescidos em 1)
		
	}

}
