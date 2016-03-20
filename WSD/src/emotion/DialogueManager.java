package emotion;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Scanner;

import com.aliasi.chunk.Chunk;
import com.aliasi.chunk.Chunking;
import com.aliasi.dict.DictionaryEntry;
import com.aliasi.dict.ExactDictionaryChunker;
import com.aliasi.dict.MapDictionary;
import com.aliasi.tokenizer.IndoEuropeanTokenizerFactory;

public class DialogueManager {

	private static final double CHUNK_SCORE = 1.0;

	public static void main(String[] args) {
		MapDictionary<String> dictionary = new MapDictionary<String>();
		{
			try {
				FileInputStream angerStream = new FileInputStream("Emotion/Anger.txt");
				FileInputStream disgustStream = new FileInputStream("Emotion/Disgust.txt");
				FileInputStream fearStream = new FileInputStream("Emotion/Fear.txt");
				FileInputStream happinessStream = new FileInputStream("Emotion/Happiness.txt");
				DataInputStream angerS = new DataInputStream(angerStream);
				DataInputStream disgustS = new DataInputStream(disgustStream);
				DataInputStream fearS = new DataInputStream(fearStream);
				DataInputStream happyS = new DataInputStream(happinessStream);
				BufferedReader angerSt = new BufferedReader(new InputStreamReader(angerStream));
				BufferedReader disgustSt = new BufferedReader(new InputStreamReader(disgustStream));
				BufferedReader fearSt = new BufferedReader(new InputStreamReader(fearStream));
				BufferedReader happySt = new BufferedReader(new InputStreamReader(happyS));
				String anger;
				String disgust;
				String fear;
				String happy;
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
				angerStream.close();
				disgustStream.close();
				fearStream.close();
				happinessStream.close();
			} catch (Exception e) {// Catch exception if any
				System.err.println("Error: " + e.getMessage());
			}
		}
		Scanner scan = new Scanner(System.in);
		String input = scan.nextLine();
		input = input.toLowerCase();
		input = input.trim();

		ExactDictionaryChunker dictionaryChunkerTT = new ExactDictionaryChunker(dictionary,
				IndoEuropeanTokenizerFactory.INSTANCE, true, true);
		Chunking chunking = dictionaryChunkerTT.chunk(input);
		for (Chunk chunk : chunking.chunkSet()) {
			int start = chunk.start();
			int end = chunk.end();
			String type = chunk.type();
			String phrase = input.substring(start, end);
			String Anger = null, Happy = null, Disgust = null, Fear = null;
			if (type == "Anger") {
				Anger = phrase;
			}
			if (type == "Happy") {
				Happy = phrase;

			}
			if (type == "Fear") {
				Fear = phrase;

			}
			if (type == "Disgust") {
				Disgust = phrase;

			}
			System.out.print(Anger);
			System.out.println(Disgust);
			System.out.println(Happy);
			System.out.println(Fear);
			
		}
		scan.close();
	}
}
