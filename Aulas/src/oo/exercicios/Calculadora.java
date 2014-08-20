package oo.exercicios;

public class Calculadora {
	private double n1, n2;
	private char operador;
	
	public Calculadora(double n1, double n2, char operador) {
		this.n1 = n1;
		this.n2 = n2;
		this.operador = operador;
	}
	
	public void exebirCalculo() {
		System.out.println(calcular());
	}
	
	public double calcular() {
		if(operador == '+') {
			return n1 + n2;
		}
		
		if(operador == '-') {
			return n1 - n2; 
		}
		
		if(operador == '*') {
			return n1 * n2;
		}
		
		if(operador == '/') {
			if(n2 == 0) {
				System.out.println("Não foi possível realizar uma divisão por zero");
			
			}
			return n1 / n2;
		}
		
		return 0;
	}
}
