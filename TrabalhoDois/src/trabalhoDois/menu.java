package trabalhoDois;

import java.util.*;

/*Crie um programa para uma tele entrega de pizza.
 O programa deve apresentar dois menus de opcoes a ser escolhido pelo cliente.
 Primeiramente, pergunta quantas pizzas, e apresenta o primeiro  menu no qual o cliente deve 
 esolher as pizzas.
 Apos a escolha da pizza o programa deve perguntar, quantas bebidas e apresentar
 o segundo menu, que o cliente deve escolher a bebida.

 Apos feitas as escolhas, confirme o pedido escolhido(enquanto a resposta do cliente for diferente de s
 peca para o cliente digitar novamente o pedido), peça o  bairro para entrega (caso o bairro para entrega não seja o centro ou agronomica, 
 imprima mensagem que área de entrega não é atendida.) e imprima o tempo previsto de espera de acordo com o bairro.
 Pegue os dados cadastrais para entrega (e escolha a forma de pagamento).  

 */
public class menu {
	public static void main(String[] args) {
		Scanner k = new Scanner(System.in);
		System.out.println("Pizza Delicia Tele Entrega!\n");
		pedidoTotal();

		System.out.println("Digite s para confirmar seu pedido.\n"
				+ "Caso este não seja o seu pedido digite n");
		String pedido = k.nextLine();

		while (!pedido.equalsIgnoreCase("s")) {
			pedidoTotal();
			System.out.println("Digite s para confirmar seu pedido.\n"
					+ "Caso este não seja o seu pedido digite n");
			pedido = k.nextLine();
			break;
		}

		String bairro = bairroEntrega();
		if (bairro.equalsIgnoreCase("centro")
				|| bairro.equalsIgnoreCase("agronomica")) {
			endereco();
			System.out.println("Digite s para confirmar seus dados.\n"
					+ "Caso estes não sejam os seus dados digite n");
			String dados = k.nextLine();

			while (!dados.equalsIgnoreCase("s")) {
				endereco();
				System.out.println("Digite s para confirmar seus dados.\n"
						+ "Caso estes não sejam os seus dados digite n");
				dados = k.nextLine();
				break;
			}
		} else {
			System.out
					.println("Desculpe, em breve estaremos espandindo nossa area de entrega!");

		}
		pagto();
		k.close();
	}

	public static void pedidoTotal() {
		Scanner k = new Scanner(System.in);
		System.out.println("Quantas pizzas?");
		int index = k.nextInt();

		String[] pizza = new String[index];
		for (int i = 0; i < pizza.length; i++) {
			pizza[i] = pedidoPizza();
		}
		System.out.println("Quantas bebidas?");
		int idx = k.nextInt();
		String[] bebida = new String[idx];
		for (int i = 0; i < bebida.length; i++) {
			bebida[i] = pedidoBebida();
		}

		System.out.println("Confirme seu pedido");
		for (int i = 0; i < pizza.length; i++) {
			System.out.print(pizza[i] + "; ");
		}
		System.out.println("\n");
		for (int i = 0; i < bebida.length; i++) {
			System.out.print(bebida[i] + "; ");
		}
		System.out.println("\n");
		k.close();
	}

	public static String pedidoPizza() {
		Scanner k = new Scanner(System.in);

		int menu = 0;
		String pizza = "";
		System.out
				.println("\tCARDAPIO DE PIZZA\n"
						+ "1) Muçarela\n2) Pepperoni\n3) Portuguesa\n4) Marguerita\n5) Escarola com Bacon\n"
						+ "Digiteo número da opção desejada:");
		menu = k.nextInt();
		switch (menu) {
		case 1:
			pizza = "Muçarela";
			break;
		case 2:
			pizza = "Pepperoni";
			break;
		case 3:
			pizza = "Portuguesa";
			break;
		case 4:
			pizza = "Marguerita";
			break;
		case 5:
			pizza = "Escarola com Bacon";
			break;
		default:
			pizza = "Opcao invalida";
		}
		k.close();
		return pizza;
	}

	public static String pedidoBebida() {
		Scanner k = new Scanner(System.in);
		int menu = 0;
		String bebida = " ";
		System.out
				.println("\tCARDAPIO DE Bebida\n"
						+ "1) Coca-cola\n2) Guarana\n3) Suco de Laranja\n4) Vinho\n5) Cerveja\n"
						+ "Digiteo número da opção desejada:");
		menu = k.nextInt();
		switch (menu) {
		case 1:
			bebida = "Coca-cola";
			break;
		case 2:
			bebida = "Guarana";
			break;
		case 3:
			bebida = "Suco Laranja";
			break;
		case 4:
			bebida = "Vinho";
			break;
		case 5:
			bebida = "Cerveja";
			break;
		default:
			bebida = "Opcao invalida";
		}
		k.close();
		return bebida;

	}

	public static String bairroEntrega() {
		Scanner k = new Scanner(System.in);
		System.out.println("Digite o bairro para entrega:");
		String bairro = k.nextLine();

		if (!bairro.equalsIgnoreCase("centro")
				&& !bairro.equalsIgnoreCase("agronomica")) {
			String erro = " não é um bairro valido para entrega.";
			k.close();
			return erro;
		} else if (bairro.equalsIgnoreCase("centro")) {
			System.out.println("O tempo de entrega no bairro " + bairro
					+ " é de aproximadamente 30 minutos.");

		} else if (bairro.equalsIgnoreCase("agronomica")) {
			System.out.println("O tempo de entrega no bairro " + bairro
					+ " é de aproximadamente 35 minutos.");

		}
		k.close();
		return bairro;

	}

	public static void endereco() {
		Scanner k = new Scanner(System.in);
		System.out.println("Cadastro de cliente.\nCPF: ");
		String cpf = k.nextLine();
		System.out.println("Nome Completo: ");
		String nome = k.nextLine();
		System.out.println("CEP: ");
		String cep = k.nextLine();
		System.out.println("Rua, numero e complemento: ");
		String endereco = k.nextLine();
		System.out.println("telefone: ");
		String telefone = k.nextLine();
		System.out.println("Confirmando, CPF " + cpf + ", Nome completo "
				+ nome + ", " + "CEP " + cep + ", Endereço" + endereco
				+ ", telefone" + telefone + ".");
		k.close();
	}

	public static void pagto() {
		Scanner k = new Scanner(System.in);
		System.out.println("Favor informar a forma de pagamento.\n"
				+ "Lembramos que o mesmo será efetuado na entrega.");
		System.out.println("1) Cartao de Credito\n2) Cartão Debito\n"
				+ "3) Cehque\n4) dinheiro");
		int num = k.nextInt();

		switch (num) {
		case 1:

			System.out.println("Obrigda! Bom Apetite!!");
			break;
		case 2:
			System.out.println("Obrigda! Bom Apetite!!");
			break;
		case 3:
			System.out
					.println("Favor apresentar o documento de identificação, " +

					"com foto, do titular do cheque!");
			System.out.println("Obrigda! Bom Apetite!!");
			break;
		case 4:
			System.out.println("Obrigda! Bom Apetite!!");
			break;

		}
		k.close();
	}
}
