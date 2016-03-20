package emotion;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Scanner;

public class getSentimentScore {

private static int getSentimentScore(String input) {
	Scanner scan = new Scanner(System.in);
    input = scan.nextLine();
	input = input.toLowerCase();
	input = input.trim();
	// remove all non alpha-numeric non whitespace chars
	input = input.replaceAll("[0-9]", "");
	input = input.replaceAll("n[.]", "");
	input = input.replaceAll("v[.]", "");
	
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int negCounter = 0;
		int posCounter = 0;
		String st = input;
		st = st.replaceAll(" ", "");
		String[] posWords  = null;
	//	FileInputStream fstream = new FileInputStream("Emotion/Anger.txt");
//		DataInputStream min = new DataInputStream(fstream);
	//	BufferedReader brm = new BufferedReader(new InputStreamReader(min));
/*	    posWords = brm;

		for (int i = 0; i < posWords.size(); i++) {
			if (input.contains("not " + posWords.get(i))
					|| (input.contains("no")) || (st.contains("n't")) || (st.contains("n't"+ posWords.get(i)))) {
				negCounter = negCounter + 5;
			}
		}

		for (int i = 0; i < negWords.size(); i++) {
			if (input.contains("not " + negWords.get(i))
					|| (input.contains("yes")) || (st.contains("n't"+ negWords.get(i)))) {
				    negCounter = negCounter - 5;
			}
		}
		input = input.toLowerCase();
		input = input.trim();
		// remove all non alpha-numeric non whitespace chars
		input = input.replaceAll("[^a-zA-Z0-9\\s]", "");
		// so what we got?
		String[] words = input.split(" ");
		
		input = input.replaceAll(".n", "");

		// check if the current word appears in our reference lists...
		for (int i = 0; i < words.length; i++) {

			if (posWords.contains(words[i])) {
				posCounter++;
			}
			if (negWords.contains(words[i])) {

				negCounter++;
			}
		}

		// positive matches MINUS negative matches
		int result = (posCounter - negCounter);

		// negative?
		if (result < 0) {
			return -1;
			// or positive?
		} else if (result > 0) {
			return 1;
		}

		return 0;
	}

	private static String containsWord(Set<String> words, String sentence) {
		for (String word : words) {
			if (sentence.contains(word)) {
				return "question";
			}
		}
		return "not_question";
	}
*/
return 0;
}
}
