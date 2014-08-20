package banco;

public class GerenteDaConta {

	public boolean usaLimite(Conta conta) {
		boolean usalimite = false;

		if (conta.getSaldo() < 0) {
			usalimite = true;
		}
		return usalimite;
	}

	public void verSaldo(Conta conta) {
		System.out.println(conta.getSaldo());
	}

	public boolean proxLimite(Conta conta) {
		boolean proxLimite;
		if (conta.getSaldo() < 0
				&& (conta.getLimite() * 0.90) < (conta.getSaldo() * -1)) {
			proxLimite = true;
		} else {
			proxLimite = false;
		}
		return proxLimite;
	}

	public double somaContas(Conta... contas) {
		double total = 0;
		for (int i = 0; i < contas.length; i++) {
			total += contas[i].getSaldo();
		}
		return total;
	}

	public void dadosConta(Conta... contas) {
		for (int i = 0; i < contas.length; i++) {
			System.out.println("Dono: " + contas[i].getDono()
					+ ", Identificador: " + contas[i].getIdentificador()
					+ ", limite: " + contas[i].getLimite() + ", saldo: "
					+ contas[i].getSaldo());
		}
	}
}