package bancoDeDados;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class LeBanco {

	public void leBanco(){
File arquivo = new File("res/base_pessoas.txt");

		
		try {
			
			int i = 0;
			do {
				Scanner k = new Scanner(System.in);
				FileWriter dt = new FileWriter(arquivo, true);
				BufferedWriter bw = new BufferedWriter(dt);
				bw.newLine();
				System.out.println("Digite o nome:");
				String nome = k.nextLine();
				System.out.println("Digite a idade de" + nome + ":");
				String idade = k.next();
				bw.write("nome " + nome + " idade " + idade + " ");
				bw.close();
				i++;
			} while (i < 5);

		} catch (IOException e) {

			e.printStackTrace();
		}
	}
}
