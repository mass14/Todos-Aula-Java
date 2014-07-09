
public class TestaFuncionario {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Funcionario f1 = new Funcionario();
		Funcionario f2 = new Funcionario();
		Funcionario f3 = f1;
		/*
		 * private String nome;
	private String departamento;
	private double salario;
	private String dataAdmissao;
	private String rg;
	private boolean admitido;
		 */
		
		
		f1.setNome("Joao");
		f1.setSalario(1500.00);
		f1.setDepartamento("Vendas");
		f1.setRg("1230000834");
		f1.setAdmissao(new Data(21, 03, 2013));
		f1.mostra();
		
	
		f1.mostra();
		
		f2.setNome("Joao");
		f2.setSalario(1500.00);
		f2.setDepartamento("Vendas");
		f2.setRg("1230000834");
		f2.setAdmissao(new Data(21, 03, 2013));
		f2.mostra();
		
		if(f1 == f3){
			System.out.println("funcionario ja cadastrado!");
		}
		f1.VerificaDuplicidade(f2);
		f1.bonifica(350);
		f1.demite();
	}

}
