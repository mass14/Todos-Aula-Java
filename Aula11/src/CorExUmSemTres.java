
public class CorExUmSemTres {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
				
		boolean iguais  = true;
		
		int[] a1 = {1,2,3,4,5,6,7,8,9};
		int[] a2 = {1,2,3,4,5,6,7,8,9};
		
		if(a1.length != a2.length){
			iguais = false;
		}else{
		
		for (int i = 0; i< a1.length; i++) {
			if (a1[i] != a2[i]){
				iguais = false;
				break;
			}
		}
		if(iguais) {
			System.out.println("Os arrays são iguais");
		}else { 
			System.out.println("Os arrays são diferentes");
		}
		}
	}

}
