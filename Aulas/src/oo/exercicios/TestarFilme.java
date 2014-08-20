package oo.exercicios;

public class TestarFilme {

	public static void main(String[] args) {
		Filme umFilmeQualquer = new Filme("Os Vingadores", 142);
		umFilmeQualquer.exibirDuracaoEmHoras();
		
		Filme meuFilmeFavorito = new Filme("Pokemon o Filme", 100);
		meuFilmeFavorito.setDuracaoEmMinutos(75);
		meuFilmeFavorito.exibirDuracaoEmHoras();
		
		System.out.printf("Os filmes no catálogo são %s e %s.\n", 
				umFilmeQualquer.getTitulo(), meuFilmeFavorito.getTitulo());
	}

}
