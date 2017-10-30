package eg.edu.alexu.csd.datastructure.hangman.cs48;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Hangman s = new Hangman();
		String[] words = { "EGYPT", "AWA", "shit", "shityshit" };
		s.setDictionary(words);
		s.setMaxWrongGuesses(10);
		s.selectRandomSecretWord();

		while (s.maxim > 0) {
			System.out.println(s.d);
			Scanner scan = new Scanner(System.in);
			s.guess(scan.nextLine().charAt(0));
		}
	}
}
