package banco;

import java.util.*;

public class TestaBanco {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		System.out.println("digite o limite da conta:");
		double limite = s.nextDouble();
		System.out.println("digite o nome do dono da conta:");
		String dono = s.next();
		ContaCorrente um = new ContaCorrente(limite, dono);
		GerenteDaConta jk = new GerenteDaConta();
		Agencia cinco = new Agencia();

		jk.dadosConta(um);
		um.credito(100);
		System.out.println(um.getSaldo());
		um.debito(150);
		System.out.println(um.getSaldo());
		System.out.println(jk.usaLimite(um));
		jk.verSaldo(um);
		System.out.println(jk.proxLimite(um));
		um.debito(140);
		System.out.println(jk.proxLimite(um));
		jk.dadosConta(um);

		System.out.println("digite o limite da conta:");
		limite = s.nextDouble();
		System.out.println("digite o nome do dono da conta:");
		dono = s.next();
		ContaPoupanca dois = new ContaPoupanca(limite, dono);
		dois.credito(200);
		jk.dadosConta(dois, um);
		System.out.println(jk.somaContas(um, dois));
		um.debito(20);
		System.out.println(um.getSaldo());
		um.credito(9);
		System.out.println(jk.proxLimite(um));
		System.out.println(dois.getSaldo());
		dois.Juros();
		System.out.println(dois.getSaldo());
		System.out.println(um.getSaldo());
		um.CobraTaxa();
		System.out.println(um.getSaldo());
		
		/*cinco.adicionarConta(um);
		cinco.adicionarConta(dois);
		System.out.println(cinco.findIndent(2));
		System.out.println(cinco.findNome("jo"));*/
		

	}
}
