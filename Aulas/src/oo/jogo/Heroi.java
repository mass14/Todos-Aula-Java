package oo.jogo;

public class Heroi {
	private String nome;
	private Posicao posicao;
	private int vida;
	private double ataque, defesa;
	private boolean superVelocidade;

	public Heroi(String nome, Posicao posicao, int vida, double ataque,
			double defesa) {
		
		 setNome(nome);
		 setPosicao(posicao);
		 setVida(vida);
		 setAtaque(ataque);
		 setDefesa(defesa);
	}
	
	public Heroi(String nome, int x, int y, int vida, double ataque,
			double defesa) {
		
		 setNome(nome);
		 setPosicao(new Posicao(x, y));
		 setVida(vida);
		 setAtaque(ataque);
		 setDefesa(defesa);
	}

	public void caminha(String direcao) {
		switch(direcao) {
		case "cima":
			posicao.moverCima((isSuperVelocidade() ? 30 : 15));
			break;
		case "baixo":
			posicao.moverBaixo((isSuperVelocidade() ? 30 : 15));
			break;
		case "esquerda":
			posicao.moverEsquerda((isSuperVelocidade() ? 30 : 15));
			break;
		case "direita":
			posicao.moverDireita((isSuperVelocidade() ? 30 : 15));
			break;
		}
		
		setSuperVelocidade(false);
		System.out.printf("O heroi %s caminhou.\n", getNome());
	}

	public void corre(String direcao) {
		switch(direcao) {
		case "cima":
			posicao.moverCima((isSuperVelocidade() ? 300 : 150));
			break;
		case "baixo":
			posicao.moverBaixo((isSuperVelocidade() ? 300 : 150));
			break;
		case "esquerda":
			posicao.moverEsquerda((isSuperVelocidade() ? 300 : 150));
			break;
		case "direita":
			posicao.moverDireita((isSuperVelocidade() ? 300 : 150));
			break;
		}
		
		setSuperVelocidade(false);
		System.out.printf("O heroi %s correu.\n", getNome());
	}

	public void ataca(Heroi inimigo) {
		// int dano = (int) (getAtaque() - inimigo.getDefesa());
		// Ou
		int dano = (int) (this.getAtaque() - inimigo.getDefesa());
		// Ou
		// int dano = (int) (this.ataque - inimigo.defesa);
		// Ou
		// int dano = (int) (ataque - inimigo.getDefesa());
		// Ou
		// int dano = (int) (this.ataque - inimigo.getDefesa());
		// Ou...
		// if(dano > 0) {
		// inimigo.setVida(inimigo.getVida() - dano);
		// } else {
		// inimigo.setVida(inimigo.getVida() - 1);
		// // inimigo.vida -= 1;
		// // inimigo.vida = inimigo.getVida() - 1;
		// // inimigo.vida = inimigo.vida - 1;
		// }

		inimigo.setVida(inimigo.getVida() - Math.max(1, dano));
		System.out.println("O heroi "+ this.getNome() +" atacou ("+ this.getAtaque() +") "
				+ "o heroi " + inimigo.getNome() + " ("+inimigo.getDefesa()+") e "
				+ "o mesmo recebeu "+ dano +" de dano, "
				+ "ficando com "+ inimigo.getVida() +".");

//		inimigo.setVida(inimigo.getVida()
//				- Math.max(1, ((int) (this.getAtaque() - inimigo.getDefesa()))));
	}
	
	public void tomarPocaoVida() {
		this.setVida(this.getVida() + 10);
//		this.vida += 10;
		
		System.out.println("O heroi "+ getNome()+" tomou uma poção de vida e "
				+ "agora está com "+this.getVida()+" pontos de vida.");
	}
	
	public void tomarPocaoVelocidade() {
		setSuperVelocidade(true);
		System.out.println("O heroi "+ getNome() +" tomou uma poção de velocidade.");
	}
	

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Posicao getPosicao() {
		return posicao;
	}

	public void setPosicao(Posicao posicao) {
		this.posicao = posicao;
	}

	public int getVida() {
		return vida;
	}

	public void setVida(int vida) {
		this.vida = vida;
	}

	public double getAtaque() {
		return ataque;
	}

	public void setAtaque(double ataque) {
		this.ataque = ataque;
	}

	public double getDefesa() {
		return defesa;
	}

	public void setDefesa(double defesa) {
		this.defesa = defesa;
	}
	
	// get para o tipo boolean
	public boolean isSuperVelocidade() {
		return superVelocidade;
	}

	public void setSuperVelocidade(boolean superVelocidade) {
		this.superVelocidade = superVelocidade;
	}

}
