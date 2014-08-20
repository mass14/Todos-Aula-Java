package oo;

public class Static {
	private static int numeroObjetos;
	private static int contador;
	private static final int VALOR_CONSTANTE = 10;
	
	public Static() {
		numeroObjetos++;
	}
	
	public void contarParaTodos() {
		contador++;
	}
	
	public static void contarParaTodosIgual() {
		contador++;
	}
	
//	public void setValor(int valor) {
//		this.VALOR_CONSTANTE = valor;
//	}
	
	public int getValor() {
		return this.VALOR_CONSTANTE;
	}
	
	
}
