package ingresso;

public class CamaroteInferior extends VIP{
	private String localizacao;
	
	public CamaroteInferior(double valor, String localizacao){
		super(valor, 0);
		this.localizacao = localizacao;
		
	}

	public String getLocalizacao(){
		return localizacao;
	}
	public void setLocalizacao(String localizacao){
		this.localizacao = localizacao;
	}
}
