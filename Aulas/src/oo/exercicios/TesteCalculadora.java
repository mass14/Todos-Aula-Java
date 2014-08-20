package oo.exercicios;

public class TesteCalculadora {

	public static void main(String[] args) {
		Calculadora c = new Calculadora(10, 30, '+');
		System.out.println(c.calcular());
		
		c = new Calculadora(10, 0, '/');
		System.out.println(c.calcular());
		
		c = new Calculadora(20, 4, '-');
		c.exebirCalculo();
	}

}
