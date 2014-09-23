package jokenpo;

public class Jokenpo {
	
/*	private boolean pedra;
	private boolean papel;
	private boolean tesoura;*/
	
	private String playerOne;
	private String playerTwo;
	
	public Jokenpo(String jogadorOne, String jogadorTwo){
		this.playerOne = playerOne;
		this.playerTwo = playerTwo;
	}
		
	public boolean CheckTie(){
		if (playerOne.equalsIgnoreCase(playerTwo)){
			return true;
		}
		return false;
	}
	
	public String Scissors(){
		if(playerOne.equalsIgnoreCase("scissors") && playerTwo.equalsIgnoreCase("rock")){
				
					
		}
	}
}
