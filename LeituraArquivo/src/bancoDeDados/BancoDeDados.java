package bancoDeDados;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class BancoDeDados {
	public static void main(String[] args) {
		File arquivo = new File("res/base_pessoas.txt");

		try {

			int i = 0;
			do {
				Scanner k = new Scanner(System.in);
				FileWriter dt = new FileWriter(arquivo, true);
				BufferedWriter bw = new BufferedWriter(dt);
				
				System.out.println("Digite o nome:");
				String nome = k.nextLine();
				System.out.println("Digite a idade de " + nome + ":");
				String idade = k.next();
				bw.write(nome + "-" + idade);
				bw.newLine();
				bw.close();
				i++;
			} while (i < 5);

		} catch (IOException e) {

			e.printStackTrace();
		}

		// verifica se o arquivo exite ou n�o
		if (arquivo.exists()) {
			try {

				// le o arquivo e imprime cada linha do mesmo no console
				FileReader fr = new FileReader(arquivo);
				BufferedReader br = new BufferedReader(fr);
				while (br.ready()) {
					String str = br.readLine();
					String[] dados = str.split("-");
					int idade = Integer.parseInt(dados[1]);
					if(idade>18){
						System.out.println(idade);
					}
					System.out.println("escreva a letra inicial");
					Scanner k= new Scanner(System.in);
					String letraInicial = k.nextLine();
					String nome  = dados[0];
					nome.startsWith(letraInicial);
					
				}
				br.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		} else {
			System.out.println("Arquivo não encontrado");
		}
	}
	
}