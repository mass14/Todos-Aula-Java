package banco;

import java.util.ArrayList;

public class Agencia {

	private ArrayList<Conta> contas;

	public Agencia() {
		contas = new ArrayList<>();
	}

	public void adicionarConta(Conta conta) {
		contas.add(conta);
	}

	public void removerConta(Conta conta) {
		contas.remove(conta);
	}

	public void removerConta(int index) {
		contas.remove(index);
	}

	public Conta findIndent(int index) {

		for (Conta conta : contas) {
			if (conta.getIdentificador() == index) {
				return conta;
			}
		}
		return null;
	}

	public void removeIndent(int index) {

		for (Conta conta : contas) {
			if (conta.getIdentificador() == index) {
				contas.remove(index);
			}
		}
	}

	public Conta findNome(String dono) {

		for (Conta conta : contas) {
			if (conta.getDono().equals(dono)) {
				return conta;
			}
		}
		return null;
	}

	public void taxa() {

		for (Conta conta : contas) {
			conta.debito(10);
		}
	}
}
/*
 * 1 - Encontrem uma conta pelo número identificador da conta. E a retornem
 * (conta).
 * 
 * 2 - Removam uma conta pelo número identificador.
 * 
 * 3 - Encontrem uma conta pelo nome do seu dono.
 * 
 * 4 - Crie um método que cobre a taxa administativa de R$10,00 para cada uma
 * das contas
 */

