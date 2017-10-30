package eg.edu.alexu.csd.datastructure.hangman.cs48;

import java.io.File;
import java.util.NoSuchElementException;
import java.util.Random;
import java.util.Scanner;

import eg.edu.alexu.csd.datastructure.hangman.IHangman;

public class Hangman implements IHangman {

	public int maxim;
	public boolean f = false;
	public String[] s;
	char[] aq = null;
	String secretWord = null;
	String d;
	int i, ind, x = 0;
	char h;

	public void setDictionary(String[] words) throws NoSuchElementException {

		s = words;
		// try {
		// File file = new File("test.txt");
		// Scanner input = new Scanner(file);
		//
		// while (input.hasNextLine()) {
		// s[i] = new String();
		// s[i] = input.nextLine();
		// i++;
		// }
		// input.close();
		// } catch (Exception ex) {
		// ex.printStackTrace();
		// }
	}

	public String selectRandomSecretWord() {
		if (s == null || s.length == 0) {
			secretWord = null;
		} else if (s.length > 0) {
			Random rnd = new Random();
			secretWord = s[rnd.nextInt(s.length)];
			aq = new char[secretWord.length()];
			for (int l = 0; l < secretWord.length(); l++) {
				aq[l] = '-';
			}
			d = new String(aq);
		}
		return secretWord;

	}

	public String guess(Character c) {
		ind = i = 0;
		h = c.charValue();
		if ((int) h >= 'a' && (int) h <= 'z' && secretWord.charAt(0) >= 'A'
				&& secretWord.charAt(0) <= 'Z') {
			h = (char) ((int) h - ((int) 'a' - (int) 'A'));
		}
		if ((int) h >= 'A' && (int) h <= 'Z' && secretWord.charAt(0) >= 'a'
				&& secretWord.charAt(0) <= 'z') {
			h = (char) ((int) h + ((int) 'a' - (int) 'A'));
		}

		do {
			if (secretWord.indexOf(h, i) == -1) {
				if (secretWord.indexOf(h) == -1) {
					maxim--;
					if (maxim == 0) {
						d = null;
						break;
					}
				}
				if (secretWord.compareTo(d) == 0) {
					f = true;
					d = secretWord;
					break;
				}
				return d;
			} else {
				ind = secretWord.indexOf(h, i);
				aq[ind] = h;
				i = 1 + ind;
			}
			d = new String(aq);
		} while (true);
		return d;

	}

	public void setMaxWrongGuesses(Integer max) {
		maxim = max.intValue();
	}

}