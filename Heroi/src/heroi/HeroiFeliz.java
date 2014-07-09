package heroi;

public class HeroiFeliz {

	public static void main(String[] args) {
		Posicao direcaoEu = new Posicao(0, 0);
		Posicao direcaoTu = new Posicao (1, 2);
		
		Heroi eu = new Heroi ("Paty", direcaoEu, 100, 10.00, 9.00);
		Heroi tu = new Heroi ("Typa", direcaoTu, 100, 6.00, 5.00);
		
		System.out.println(eu.getNome() + " posicao X " + direcaoEu.getPosicaoX() + ", posicao Y " + direcaoEu.getPosicaoY() );
		
		eu.caminhaUnidades("cima");
		System.out.println(eu.getNome() + " posicao X " + direcaoEu.getPosicaoX() + ", posicao Y " + direcaoEu.getPosicaoY() );

		eu.correUnidade("esquerda");
		System.out.println(eu.getNome() + " posicao X " + direcaoEu.getPosicaoX() + ", posicao Y " + direcaoEu.getPosicaoY() );
		
		System.out.println("\n");
		eu.ataca(tu);
		
		System.out.println("\n");
		tu.tomaPocaoVida();
		
		System.out.println("\n");
		eu.tomaPocaoVelocidade(); 
		System.out.println("\n");
		eu.caminhaUnidades("baixo");
		System.out.println( eu.getNome() + " posicao X " + direcaoEu.getPosicaoX() + ", posicao Y " + direcaoEu.getPosicaoY() );
		
		eu.caminhaUnidades("esquerda");
		System.out.println(eu.getNome() + " posicao X " + direcaoEu.getPosicaoX() + ", posicao Y " + direcaoEu.getPosicaoY() );
		
		System.out.println("\n");
		eu.tomaPocaoVelocidade(); 
		
		System.out.println("\n");
		eu.caminhaUnidades("baixo");
		System.out.println( eu.getNome() + " posicao X " + direcaoEu.getPosicaoX() + ", posicao Y " + direcaoEu.getPosicaoY() );
		
		eu.caminhaUnidades("direita");
		System.out.println(eu.getNome() + " posicao X " + direcaoEu.getPosicaoX() + ", posicao Y " + direcaoEu.getPosicaoY() );
		
	}

}
