package oo.exercicios;

/*
 * 
 Atributos: cor, porta1, porta2, porta3
 
 Método: void pinta(String s), int quantasPortasEstaoAbertas(), int totalDePortas()

Para testar, crie uma casa e pinte‐a. Crie três portas e coloque‐as 
na casa; abra e	 feche as mesmas como desejar. Utilize o método quantasPortasEstaoAbertas
para imprimir o número de portas abertas.
*/
public class Casa {
	private String cor;
	private Porta porta1, porta2, porta3;
	
	public int totalDePortas() {
		int contador = 0;
		
		if(this.porta1 != null) {
			contador++;
		}
		
		if(this.porta2 != null) {
			contador++;
		}
		
		if(this.porta3 != null) {
			contador++;
		}
		
		return contador;
	}
	
	public int quantasPortasEstaoAbertas() {
		int contador = 0;
		
		if(this.porta1 != null && this.porta1.estaAberta()) {
			contador++;
		}
		
		if(this.porta2 != null && this.porta2.estaAberta()) {
			contador++;
		}
		
		if(this.porta3 != null && this.porta3.estaAberta()) {
			contador++;
		}
		
		return contador;
	}
	
	public void pinta(String s) {
		this.cor = s;
	}
	
	public String getCor() {
		return this.cor;
	}
	
	public void setPorta1(Porta porta1) {
		this.porta1 = porta1;
	}
	
	public Porta getPorta1() {
		return this.porta1;
	}

	public Porta getPorta2() {
		return porta2;
	}

	public void setPorta2(Porta porta2) {
		this.porta2 = porta2;
	}

	public Porta getPorta3() {
		return porta3;
	}

	public void setPorta3(Porta porta3) {
		this.porta3 = porta3;
	}
	
	
}
