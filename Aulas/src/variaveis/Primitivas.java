package variaveis;

/* http://pt.wikipedia.org/wiki/Vari%C3%A1vel_(programa%C3%A7%C3%A3o)
 * 
 * Na programação, uma variável é um objeto (uma posição, frequentemente localizada na memória) capaz de reter e
 * representar um valor ou expressão. Enquanto as variáveis só "existem" em tempo de execução, elas são associadas a 
 * "nomes", chamados identificadores, durante o tempo de desenvolvimento.
 * 
 * Quando nos referimos à variável, do ponto de vista da programação de computadores, estamos tratando de uma “região 
 * de memória (do computador) previamente identificada cuja finalidade é armazenar os dados ou informações de um 
 * programa por um determinado espaço de tempo”. A memória do computador se organiza tal qual um armário com várias 
 * divisões. Sendo cada divisão identificada por um endereço diferente em uma linguagem que o computador entende.
 * 
 * O computador armazena os dados nessas divisões, sendo que em cada divisão só é possível armazenar um dado e toda vez 
 * que o computador armazenar um dado em uma dessas divisões, o dado que antes estava armazenado é eliminado. O conteúdo
 * pode ser alterado, mas somente um dado por vez pode ser armazenado naquela divisão.
 * 
 */
public class Primitivas {

    public static void main(String[] args) {

        
    	System.out.println("Números Inteiros (int):");
    	
        int numeroInteiro = 30; // Criando uma variável do tipo inteira que possui como valor: 30;
        
        System.out.printf("O valor de numeroInteiro é %d.\n", numeroInteiro); // Imprimindo no console;
        
        System.out.printf("O valor mínimo de um inteiro é %d.\n", Integer.MIN_VALUE);
        System.out.printf("O valor máximo de um inteiro é %d.\n", Integer.MAX_VALUE);
        
        System.out.printf("O tamanho um inteiro na memória é de %d bytes.", Integer.SIZE);
    }
}
