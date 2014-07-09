package heroi;

public class Heroi {
	private String nome;
	private Posicao posicao;
	private int vidaAtual;
	private double poderAtaque;
	private double poderDefesa;
	private boolean velocidade = false;

	public Heroi(String nome, Posicao posicao, int vidaRestante,
			double poderAtaque, double poderDefesa) {
		this.nome = nome;
		this.posicao = posicao;
		this.vidaAtual = vidaRestante;
		this.poderAtaque = poderAtaque;
		this.poderDefesa = poderDefesa;
	}

	public boolean tomaPocaoVelocidade() {
		this.velocidade = true;
		System.out
				.println("Heroi " + this.nome + " tomou pocao de velocidade.");
		return velocidade;

	}

	public void tomaPocaoVida() {
		this.setVidaAtual(this.getVidaAtual() + 10);
		System.out.println("O heroi " + this.nome
				+ " tomou pocao de vida e agora sua vida �: " + this.vidaAtual);

	}

	public void caminhaUnidades(String direcao) {
		
		int caminhada = 15;
		int caminhadaPocao = caminhada * 2;
		if (velocidade) {
			switch(direcao) {
			case "cima":
				posicao.moverCima(caminhadaPocao);
				System.out.println("O heroi " + nome + " caminhou "
						+ caminhadaPocao + " posicoes para cima.");
				break;
			case "baixo":
				posicao.moverBaixo(caminhadaPocao);
				System.out.println("O heroi " + nome + " caminhou "
						+ caminhadaPocao + " posicoes para baixo.");
				break;
			case "esquerda":
				posicao.moverEsquerda(caminhadaPocao);
				System.out.println("O heroi " + nome + " caminhou "
						+ caminhadaPocao + " posicoes para esquerda.");
				break;
			case "direita":
				posicao.moverDireita(caminhadaPocao);
				System.out.println("O heroi " + nome + " caminhou "
						+ caminhadaPocao + " posicoes para direita.");
				break;
			default:
					System.out.println("erro de posicao");
			}
			
		} else {
			switch(direcao) {
			case "cima":
				posicao.moverCima(caminhada);
				System.out.println("O heroi " + nome + " caminhou "
						+ caminhada + " posicoes para cima.");
				break;
			case "baixo":
				posicao.moverBaixo(caminhada);
				System.out.println("O heroi " + nome + " caminhou "
						+ caminhada + " posicoes para baixo.");
				break;
			case "esquerda":
				posicao.moverEsquerda(caminhada);
				System.out.println("O heroi " + nome + " caminhou "
						+ caminhada + " posicoes para esquerda.");
				break;
			case "direita":
				posicao.moverDireita(caminhada);
				System.out.println("O heroi " + nome + " caminhou "
						+ caminhada + " posicoes para direita.");
				break;
			default:
					System.out.println("erro de posicao");
		}
		}
		velocidade = false;

	}

	public void correUnidade(String direcao) {
		int corrida = 150;
		int corridaPocao = 300; 
		if (velocidade) {
			switch(direcao) {
			case "Cima":
				posicao.moverCima(corridaPocao);
				System.out.println("O heroi " + nome + " caminhou "
						+ corridaPocao + " posicoes para cima.");
				break;
			case "baixo":
				posicao.moverBaixo(corridaPocao);
				System.out.println("O heroi " + nome + " caminhou "
						+ corridaPocao + " posicoes para baixo.");
				break;
			case "esquerda":
				posicao.moverEsquerda(corridaPocao);
				System.out.println("O heroi " + nome + " caminhou "
						+ corridaPocao + " posicoes para esquerda.");
				break;
			case "direita":
				posicao.moverDireita(corridaPocao);
				System.out.println("O heroi " + nome + " caminhou "
						+ corridaPocao + " posicoes para direita.");
				break;
			default:
					System.out.println("erro de posicao");
			}
			
		} else {
			switch(direcao) {
			case "Cima":
				posicao.moverCima(corrida);
				System.out.println("O heroi " + nome + " caminhou "
						+ corrida + " posicoes para cima.");
				break;
			case "baixo":
				posicao.moverBaixo(corrida);
				System.out.println("O heroi " + nome + " caminhou "
						+ corrida + " posicoes para baixo.");
				break;
			case "esquerda":
				posicao.moverEsquerda(corrida);
				System.out.println("O heroi " + nome + " caminhou "
						+ corrida + " posicoes para esquerda.");
				break;
			case "direita":
				posicao.moverDireita(corrida);
				System.out.println("O heroi " + nome + " caminhou "
						+ corrida + " posicoes para direita.");
				break;
			default:
					System.out.println("erro de posicao");
		}
		}
		velocidade = false;

	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public double getPoderAtaque() {
		return poderAtaque;
	}

	public void setPoderAtaque(double poderAtaque) {
		this.poderAtaque = poderAtaque;
	}

	public double getPoderDefesa() {
		return poderDefesa;
	}

	public void setPoderDefesa(double poderDefesa) {
		this.poderDefesa = poderDefesa;
	}

	public void setVidaAtual(int vidaAtual) {
		this.vidaAtual = vidaAtual;
	}

	public int getVidaAtual() {
		return this.vidaAtual;
	}

	public boolean isVelocidade() {
		return velocidade;
	}

	public void setVelocidade(boolean velocidade) {
		this.velocidade = velocidade;
	}

	public void ataca(Heroi outro) {
		int danoTotal = (int) (this.getPoderAtaque() - outro.getPoderDefesa());
		if (danoTotal > 0) {
			outro.setVidaAtual(outro.getVidaAtual() - danoTotal);
		} else {
			outro.setVidaAtual(outro.getVidaAtual() - 1);
		}

		System.out.println("O heroi " + this.nome + " atacou o heroi "
				+ outro.nome + "\nA defesa do heroi " + outro.nome + " � "
				+ outro.poderDefesa + "\nO ataque do heroi " + this.nome
				+ " � " + this.poderAtaque + " \no dano total recebido foi "
				+ danoTotal + "\na vida restante do heroi " + outro.nome
				+ " apos o ataque � " + outro.vidaAtual + ".");
	}
}