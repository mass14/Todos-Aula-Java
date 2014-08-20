package ingresso;

public class CamaroteSuperior extends VIP {
	private String localizacao;
	public CamaroteSuperior(double valor, double adicional, String localizacao){
		super(valor, adicional);
		this.localizacao = localizacao;
		
	}

	public String getLocalizacao(){
		return localizacao;
	}
	public void setLocalizacao(String localizacao){
		this.localizacao = localizacao;
	}
}
