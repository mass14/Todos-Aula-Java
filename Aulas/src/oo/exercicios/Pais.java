package oo.exercicios;

/*
 * Pais

 Escreva uma classe que represente um país. Um país tem como atributos o seu nome, 
 o nome da capital, sua dimensão em Km2 e uma lista de países com os quais ele faz 
 fronteira. Represente a classe e forneça os seguintes construtores e método:
 a) Construtor que inicialize o nome, capital e a dimensão do país;	 
 b) Métodos de acesso (set/get) para as propriedades indicadas no item (a); 
 c) Um método que permita verificar se dois países são iguais. Dois países são 
 iguais se tiverem mesmo nome e a mesma capital. A assinatura deste método deve ser:
 public boolean equals(Pais outro);

 d) Um método que define quais outros países fazem fronteira (note que um país não
 pode fazer fronteira com ele mesmo);	 
 e) Um método que retorne a lista de países que fazem fronteira;
 f) Um método que receba um outro país como parâmetro e retorne uma lista de
 vizinhos comuns aos dois países.
 */
public class Pais {
	private String nome, capital;
	private double dimensao;
	private Pais[] fronteiras;

	// a)
	public Pais(String nome, String capital, double dimensao) {
		this.nome = nome;
		this.capital = capital;
		this.dimensao = dimensao;
	}

	// c)
	public boolean equals(Pais outro) {
		return this.nome.equals(outro.getNome())
				&& this.capital.equals(outro.getCapital());
	}

	// d)
	public void setFronteiras(Pais... paises) {
		
		int quantidadePaisesIguais = 0;
		for(int i = 0; i < paises.length; i++) {
			if(this.equals(paises[i])) {
				quantidadePaisesIguais++;
			}
		}
		
		this.fronteiras = new Pais[paises.length - quantidadePaisesIguais];
		int idxFronteira = 0;
		for(int i = 0; i < paises.length; i++) {
			if(!this.equals(paises[i])) {
				this.fronteiras[idxFronteira] = paises[i];
				idxFronteira++;
			}
		}
		
	}
	
	// e)
	public Pais[] getFronteiras() {
		return this.fronteiras;
	}
	
	// f)
	public Pais[] vizinhosEmComum(Pais outro) {
		int totaisIguais = 0;
		for(Pais fronteiraPais: this.fronteiras) {
			for(Pais fronteiraOutro: outro.fronteiras) {
				if(fronteiraPais.equals(fronteiraOutro)) {
					totaisIguais++;
				}
			}
		}
		
		if(totaisIguais > 0) {
			int idxVizinhos = 0;
			Pais[] mesmosVizinhos = new Pais[totaisIguais];
			for(Pais fronteiraPais: this.fronteiras) {
				for(Pais fronteiraOutro: outro.fronteiras) {
					if(fronteiraPais.equals(fronteiraOutro)) {
						mesmosVizinhos[idxVizinhos] = fronteiraOutro;
						idxVizinhos++;
					}
				}
			}
			
			return mesmosVizinhos;
		}
		
		return null;
	}
	

	// b) 
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCapital() {
		return capital;
	}

	public void setCapital(String capital) {
		this.capital = capital;
	}

	public double getDimensao() {
		return dimensao;
	}

	public void setDimensao(double dimensao) {
		this.dimensao = dimensao;
	}

}
