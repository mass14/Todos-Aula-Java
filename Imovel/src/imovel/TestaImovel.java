package imovel;

public class TestaImovel {

	public static void main(String[] args){
		Novo novo = new Novo("Rua Gen Birtt", 200000, 300);
		Velho velho = new Velho("bla bla", 200000, 300);
		novo.aumentaPreco();
		System.out.println(novo);
	System.out.println(novo.getAddPreco());
	velho.subPreco();
	System.out.println(velho);
	System.out.println(velho.getDecPReco());
	}
}
