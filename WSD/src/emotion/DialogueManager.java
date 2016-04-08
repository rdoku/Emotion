package emotion;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Scanner;
import com.aliasi.chunk.Chunk;
import com.aliasi.chunk.Chunking;
import com.aliasi.dict.DictionaryEntry;
import com.aliasi.dict.ExactDictionaryChunker;
import com.aliasi.dict.MapDictionary;
import com.aliasi.tokenizer.IndoEuropeanTokenizerFactory;

public class DialogueManager {

	private static final double CHUNK_SCORE = 1.0;

	public static void main(String[] args) throws IOException {
		MapDictionary<String> dictionary = new MapDictionary<String>();
		{
			try {
				FileInputStream angerStream = new FileInputStream("Emot/Anger1.txt");
				FileInputStream disgustStream = new FileInputStream("Emot/Disgust1.txt");
				FileInputStream fearStream = new FileInputStream("Emot/Fear1.txt");
				FileInputStream happinessStream = new FileInputStream("Emot/Happiness1.txt");
				FileInputStream sadStream = new FileInputStream("Emot/Sadness1.txt");
				FileInputStream surpriseStream = new FileInputStream("Emot/Surprise1.txt");
				BufferedReader angerSt = new BufferedReader(new InputStreamReader(angerStream));
				BufferedReader disgustSt = new BufferedReader(new InputStreamReader(disgustStream));
				BufferedReader fearSt = new BufferedReader(new InputStreamReader(fearStream));
				BufferedReader happySt = new BufferedReader(new InputStreamReader(happinessStream));
				BufferedReader sadSt = new BufferedReader(new InputStreamReader(sadStream));
				BufferedReader surpriseSt = new BufferedReader(new InputStreamReader(surpriseStream));
				String anger;
				String disgust;
				String fear;
				String happy;
				String sad;
				String surprise;
				while ((anger = angerSt.readLine()) != null) {
					dictionary.addEntry(new DictionaryEntry<String>(anger, "Anger", CHUNK_SCORE));
				}
				while ((disgust = disgustSt.readLine()) != null) {
					dictionary.addEntry(new DictionaryEntry<String>(disgust, "Disgust", CHUNK_SCORE));
				}
				while ((fear = fearSt.readLine()) != null) {
					dictionary.addEntry(new DictionaryEntry<String>(fear, "Fear", CHUNK_SCORE));
				}
				while ((happy = happySt.readLine()) != null) {
					dictionary.addEntry(new DictionaryEntry<String>(happy, "Happy", CHUNK_SCORE));
				}
				while ((sad = sadSt.readLine()) != null) {
					dictionary.addEntry(new DictionaryEntry<String>(sad, "Sad", CHUNK_SCORE));
				}
				while ((surprise = surpriseSt.readLine()) != null) {
					dictionary.addEntry(new DictionaryEntry<String>(surprise, "Surprise", CHUNK_SCORE));
				}
				angerStream.close();
				disgustStream.close();
				fearStream.close();
				happinessStream.close();
				sadStream.close();
				surpriseStream.close(); 
			} catch (Exception e) {// Catch exception if any
				System.err.println("Error: " + e.getMessage());
			}
		}
		System.out.println("Enter something: ");
		Scanner scan = new Scanner(System.in);
		String input = scan.nextLine();
		input = input.toLowerCase();
		input = input.trim();


		ExactDictionaryChunker dictionaryChunkerTT = new ExactDictionaryChunker(dictionary,
				IndoEuropeanTokenizerFactory.INSTANCE, true, true);
		Chunking chunking = dictionaryChunkerTT.chunk(input);

        ArrayList<String> angerArray = new ArrayList<String>();
        ArrayList<String> happyArray = new ArrayList<String>();
        ArrayList<String> disgustArray = new ArrayList<String>();
        ArrayList<String> fearArray = new ArrayList<String>();
        ArrayList<String> sadnessArray = new ArrayList<String>();
        ArrayList<String> surpriseArray = new ArrayList<String>();
		for (Chunk chunk : chunking.chunkSet()) {
			int start = chunk.start();
			int end = chunk.end();
			String type = chunk.type();
			String phrase = input.substring(start, end);
			if (type == "Anger") {
				angerArray.add(phrase);
				System.out.println("Anger " +phrase);
			}
			if (type == "Happy") {
				happyArray.add(phrase);
			}
			if (type == "Fear") {
				fearArray.add(phrase);
			}
			if (type == "Disgust") {
				disgustArray.add(phrase);
			}
			if (type == "Surprise") {
				surpriseArray.add(phrase);
			}
			if (type == "Sadness") {
				sadnessArray.add(phrase);
			}	
		}
		StringBuilder ang = new StringBuilder();
		for (String s : angerArray)
		{
		    ang.append(s);
		    ang.append("\t");
		}
		StringBuilder hap = new StringBuilder();
		for (String s : happyArray)
		{
		    hap.append(s);
		    hap.append("\t");
		}

		 BufferedWriter bw = null;
         bw = new BufferedWriter(new FileWriter("Emot/Disgust1.txt", true));
         bw.write(ang.toString());
 		bw.newLine();
	//	attach ang.string to anger.txt to compare with merged. (work with movefile) ps..an
		System.out.println(ang.toString());
		System.out.println(angerArray.size());
		System.out.println(hap.toString());
		System.out.println(happyArray.size());
		bw.close();
		scan.close();
	}
}
