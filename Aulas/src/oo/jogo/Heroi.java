package oo.jogo;

public class Heroi {
	private String nome;
	private int posicao, vida;
	private double ataque, defesa;
	private boolean superVelocidade;

	public Heroi(String nome, int posicao, int vida, double ataque,
			double defesa) {
		this.nome = nome;
		this.posicao = posicao;
		this.vida = vida;
		this.ataque = ataque;
		this.defesa = defesa;

		// Ou
		// setNome(nome);
		// setPosicao(posicao);
		// setVida(vida);
		// setAtaque(ataque);
		// setDefesa(defesa);
	}

	public void caminha() {
		setPosicao(getPosicao() + (isSuperVelocidade() ? 30 : 15));
		setSuperVelocidade(false);
		System.out.printf("O heroi %s caminhou.\n", getNome());
	}

	public void corre() {
		setPosicao(getPosicao() + (isSuperVelocidade() ? 300 : 150));
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
		System.out.printf("O heroi "+ this.getNome() +" atacou ("+ this.getAtaque() +") "
				+ "o heroi " + inimigo.getNome() + " ("+inimigo.getDefesa()+") e "
				+ "o mesmo recebeu "+ dano +" de dano, "
				+ "ficando com "+ inimigo.getVida() +".\n");

//		inimigo.setVida(inimigo.getVida()
//				- Math.max(1, ((int) (this.getAtaque() - inimigo.getDefesa()))));
	}
	
	public void tomarPocaoVida() {
		this.setVida(this.getVida() + 10);
//		this.vida += 10;
		
		System.out.printf("O heroi "+ getNome()+" tomou uma poção de vida e "
				+ "agora está com "+this.getVida()+" pontos de vida.\n");
	}
	
	public void tomarPocaoVelocidade() {
		setSuperVelocidade(true);
		System.out.printf("O heroi "+ getNome() +" tomou uma poção de velocidade.\n");
	}
	

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getPosicao() {
		return posicao;
	}

	public void setPosicao(int posicao) {
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
