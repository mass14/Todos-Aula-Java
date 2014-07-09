
public class Operacoes {
	public static void main(String[] args) {
		ContaBancaria conta = new ContaBancaria();
		conta.saldo = 10000;
		conta.credito(20.30, 12, 54);
		conta.credito(20.30, 12, 54, 43, 2);
		System.out.println(conta.saldo);
		
		ContaBancaria contaRealNassor = new ContaBancaria();
		contaRealNassor.saldo = -300000.00;
		contaRealNassor.debito(300.43, 1200.54);
		contaRealNassor.credito(3000.49);
		System.out.println(contaRealNassor.getSaldo());
	}

}
