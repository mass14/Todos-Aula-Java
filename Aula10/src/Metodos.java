
public class Metodos {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String stUm = "Métodos são divertidos";
		String stDois = ", mas talvez você não ache!!";
		
		String concatenado = concatenar(stUm, stDois);
		
		//String concatenado = StrUm + StrDois;
		System.out.println(concatenado);

	}
	public static String concatenar(String um, String dois){
		String  stringConcatenada = um + dois;
		return stringConcatenada;
	}
}
