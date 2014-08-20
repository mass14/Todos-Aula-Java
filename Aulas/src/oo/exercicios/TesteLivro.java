package oo.exercicios;

public class TesteLivro {

	public static void main(String[] args) {
		Livro pequenoPrincipe = new Livro("O Pequeno Príncipe");
		pequenoPrincipe.setQtdPaginas(98);
		
		System.out.printf("O livro %s possui %d páginas.\n", 
				pequenoPrincipe.getTitulo(), pequenoPrincipe.getQtdPaginas());
		
		pequenoPrincipe.setPaginasLidas(20);
		pequenoPrincipe.verificarProgresso();
		
		pequenoPrincipe.setPaginasLidas(50);
		pequenoPrincipe.verificarProgresso();
		
		Livro meuLivro = new Livro("Sonho Grande", 245, 111);
		meuLivro.verificarProgresso();
		
		System.out.printf("O livro %s possui %d páginas.\n", 
				meuLivro.getTitulo(), meuLivro.getQtdPaginas());
	}

}
