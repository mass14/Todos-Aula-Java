
public class forEach {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//inicializa array de nomes
		String[] nomes = {
				"Mariá",
				"Jonatas",
				"Maria Luiza"
		};
		//Itera entre cada um desses nomes
		for(String nome : nomes){
			System.out.println(nome);
		}
		double[] notas = {8.6, 3.3, 4.4};
		double somaNotas = 0.0;
		
		for (double nota : notas){ 
			somaNotas +=nota;
		}
		System.out.printf("A média é %.2f", somaNotas/notas.length);

	}

}
