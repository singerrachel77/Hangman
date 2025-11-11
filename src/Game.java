import java.util.Scanner;
import java.io.*;

public class Game {

	public static void main(String[] args) throws FileNotFoundException{
		Scanner keyboard = new Scanner(System.in);
		Word word = new Word();
		String go = "yes";
		String input = "y";
		Guess guess;
		
		char[] goal;
		
		do{
			while(input.equalsIgnoreCase("y")) {
				System.out.print("Choose a difficulty: easy, medium, or hard: ");
				input = keyboard.next();
			
				switch(input) {
				case "easy":
					word.load("easy.txt");
					word.chooseWord();	
					break;
				case "medium":
					word.load("medium.txt");
					word.chooseWord();	
					break;
				case "hard":
					word.load("hard.txt");
					word.chooseWord();	
					break;
				default:
					System.out.println("That's not a valid input!");
				 	break;
				
				
				}
				goal = word.generateGoal();
				System.out.print(goal);
				System.out.println();
				guess = new Guess(goal);
				guess.start();
				
				do {
					System.out.println("Enter your guess: ");
					char letter = keyboard.next().charAt(0);
					keyboard.nextLine();
					if (letter == '!') {
						System.out.print("Enter your guess: ");
						String wordGuessed = keyboard.nextLine();
						guess.wordGuess(wordGuessed);
					}
					else {
						guess.letterGuess(letter);
					}
				}while(!guess.isLoss() && !guess.isWin());
			}
			
			word.clearList();

			input = "y";
			
			System.out.print("Play again? Enter 'yes' to play again: ");
			go = keyboard.next();
			
		}while(go.equalsIgnoreCase("yes"));
		
		keyboard.close();
		System.exit(0);

	}

}
