package semanaDois;

import java.util.Random;
import java.util.Scanner;

/*
 Atividade número 2:

 Jogo de Pergunta e Respostas
 - Desenvola programa que tenha uma lista de 10 Perguntas e Respostas 
 (já previamente definidas)
 - Este programa selecionará aleatóriamente uma dessas perguntas e 
 mostrará para o usuário(jogador).
 - O jogador vai possuir 5 chances de acertar a pergunta senão o 
 programa irá selecionar uma nova pergunta a ele.
 - As perguntas não devem se repetir. Caso todas as perguntas tenham sido
 feitas, o programa deve terminar.
 - Digite -1 na resposta para finalizar o programa. 
 */

public class PerguntaResposta {

	public static void main(String[] args) {
		// perguntas a serem selecionadas aleatoriamente
		String[] questions = new String[10];
		questions[0] = "She ______ to school everyday.\n a)walks;\n b)walk";
		questions[1] = "I______ tomatoes.\n a)like\n b)likes";
		questions[2] = "I________ milk.\n a)want\n b)wants";
		questions[3] = "Tomatoes _____ good for you.\n a)are \n b)is";
		questions[4] = "I ________ like her. \n a)don`t \n b)doesn`t";
		questions[5] = "He _______ like you.\n a)doesn`t \n b)don`t";
		questions[6] = "Learning Java ______ great!\n a)is \n b)are";
		questions[7] = "There _____ some milk in the fridge. \n a)is \n b)are";
		questions[8] = "There ______some apples in the fridge. \n a)are \n b) is";
		questions[9] = "This ____ an awesome game. \n a)is \n b) are";

		// Respostas das perguntas
		String[] answers = new String[10];
		answers[0] = "a";
		answers[1] = "a";
		answers[2] = "a";
		answers[3] = "a";
		answers[4] = "a";
		answers[5] = "a";
		answers[6] = "a";
		answers[7] = "a";
		answers[8] = "a";
		answers[9] = "a";
		
		boolean[] used = new boolean[10];

		Random generator = new Random();
		Scanner keyboard = new Scanner(System.in);

		// imprime as instrucoes do jogo
		System.out
				.println("Welcome to \"The Simple Present Game!\"\nAn incomplete sentence "
						+ "will be presented to you along with two options to complete it, please "
						+ "type in the letter that corresponds to the correct option.\n"
						+ "If you wish to leave the game type in -1. Good Luck!!\n");

		String userReply = "";
		int usedQuestions = 0;
		int acertos = 0;
		int erros = 0;

		do {
			int index;
			int counter;
			
			if(usedQuestions != 10) {
				index = generator.nextInt(questions.length);
				while(used[index]) {
					index = generator.nextInt(questions.length);
				}
				
				System.out.println(questions[index]);
				counter = 0;
	
				while (counter < 5 && !userReply.equals("-1")) {
					userReply = keyboard.nextLine();
					if (userReply.equalsIgnoreCase(answers[index])) {
						System.out.print("A resposta está correta");
						acertos++;
						counter = 5;
					} else {
						counter++;
						System.out.print("A resposta está errada (você tem"
								+ " mais " + (5 - counter) + " tentativas");
					}
				}
				
				erros = questions.length - acertos;
				used[index] = true;
				usedQuestions++;
			} else {
				System.out.println("Todas as questões foram respondidas");
				userReply = "-1";
			}
		} while (!userReply.equals("-1"));
		
		System.out.println("Acertos: " + acertos);
		System.out.println("Erros: " + erros);
		
		keyboard.close();
	}
}
