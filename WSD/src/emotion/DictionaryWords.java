package emotion;

import com.aliasi.chunk.Chunk;
import com.aliasi.chunk.Chunker;
import com.aliasi.chunk.Chunking;
import com.aliasi.dict.DictionaryEntry;
import com.aliasi.dict.MapDictionary;
import com.aliasi.dict.ExactDictionaryChunker;

import com.aliasi.tokenizer.IndoEuropeanTokenizerFactory;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;


public class DictionaryWords {
	static ArrayList<String> angerArray = new ArrayList<String>();
    static ArrayList<String> happyArray = new ArrayList<String>();
    static ArrayList<String> disgustArray = new ArrayList<String>();
    static ArrayList<String> fearArray = new ArrayList<String>();
    static ArrayList<String> sadnessArray = new ArrayList<String>();
    static ArrayList<String> surpriseArray = new ArrayList<String>();

    static final double CHUNK_SCORE = 1.0;

    public static void main(String[] args) {

    	MapDictionary<String> dictionary = new MapDictionary<String>();
		{
			try {
				FileInputStream angerStream = new FileInputStream("Emot/Anger2.txt");
				FileInputStream disgustStream = new FileInputStream("Emot/Disgust2.txt");
				FileInputStream fearStream = new FileInputStream("Emot/Fear2.txt");
				FileInputStream happinessStream = new FileInputStream("Emot/Happiness2.txt");
				FileInputStream sadStream = new FileInputStream("Emot/Sadness2.txt");
				FileInputStream surpriseStream = new FileInputStream("Emot/Surprise2.txt");
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

        ExactDictionaryChunker dictionaryChunkerTT
            = new ExactDictionaryChunker(dictionary,
                                         IndoEuropeanTokenizerFactory.INSTANCE,
                                         true,true);

  //      Stopwords f = new Stopwords();    
        String  text = "I saw him by chance.";
        text = MorphaStemmer.detokenize(text);
     //	text = f.removeStemmedStopWords(text);

        
            System.out.println("\n\nTEXT=" + text);
            chunk(dictionaryChunkerTT,text);
            StringBuilder ang = new StringBuilder();
            StringBuilder hap = new StringBuilder();
            StringBuilder dis = new StringBuilder();
            StringBuilder sur = new StringBuilder();
            StringBuilder sad = new StringBuilder();
            StringBuilder fear = new StringBuilder();
            
    		for (String s : angerArray)
    		{
    		    ang.append(s);
    		    ang.append("\n");
    		}
    		
    		for (String s : happyArray)
    		{
    		    hap.append(s);
    		    hap.append("\n");
    		}
    		
    		for (String s : sadnessArray)
    		{
    		    sad.append(s);
    		    sad.append("\n");
    		}
    		
    		for (String s : surpriseArray)
    		{
    		    sur.append(s);
    		    sur.append("\n");
    		}
    		for (String s : fearArray)
    		{
    		    fear.append(s);
    		    fear.append("\n");
    		}
    		
    		for (String s : disgustArray)
    		{
    		    dis.append(s);
    		    dis.append("\n");
    		}
    		
    		
    		System.out.println("Anger");
    		System.out.println(ang.toString());
    		System.out.println("Disgust");
    		System.out.println(dis.toString());
    		System.out.println("Fear");
    		System.out.println(fear.toString());
    		System.out.println("Happiness");
    		System.out.println(hap.toString());
    		System.out.println("Sadness");
    		System.out.println(sad.toString());
    		System.out.println("Surprise");
    		System.out.println(sur.toString());
    		
           

    }

    static void chunk(ExactDictionaryChunker chunker, String text) {
        System.out.println("\nChunker");
        Chunking chunking = chunker.chunk(text);
        String type =  "";
        for (Chunk chunk : chunking.chunkSet()) {
            int start = chunk.start();
            int end = chunk.end();
            type = chunk.type();
          //  double score = chunk.score();
             String phrase = text.substring(start,end);
             if (type == "Anger") {
 				angerArray.add(phrase);
 				//System.out.println("Anger " +phrase);
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
		
    }

}