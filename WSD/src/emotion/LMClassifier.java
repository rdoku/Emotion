package emotion;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.commons.io.FileUtils;

import com.aliasi.chunk.Chunk;
import com.aliasi.chunk.Chunking;
import com.aliasi.sentences.MedlineSentenceModel;
import com.aliasi.sentences.SentenceChunker;
import com.aliasi.sentences.SentenceModel;
import com.aliasi.tokenizer.IndoEuropeanTokenizerFactory;
import com.aliasi.tokenizer.TokenizerFactory;


public class LMClassifier {
	
	static final TokenizerFactory TOKENIZER_FACTORY = IndoEuropeanTokenizerFactory.INSTANCE;
	static final SentenceModel SENTENCE_MODEL = new MedlineSentenceModel();
	static final SentenceChunker SENTENCE_CHUNKER = new SentenceChunker(TOKENIZER_FACTORY, SENTENCE_MODEL);
	
	
	public static void main(String[] args) throws ClassNotFoundException, IOException, InterruptedException
	{
		String fileName ="Other/sample.txt";
		getClassification(fileName);
		File affective = new File("Affective");
		CleanDirectory.dirClean(affective);
		
	}
	
	public static void getClassification(String fileName) throws IOException, ClassNotFoundException, InterruptedException {
		String text = FileUtils.readFileToString(new File(fileName));
		Chunking chunking = SENTENCE_CHUNKER.chunk(text.toCharArray(), 0, text.length());
		Set<Chunk> sentences = chunking.chunkSet();
		ClassificationScore cs = new ClassificationScore();
		if (sentences.size() < 1) {
			System.out.println("No sentence chunks found.");
			return;
		}
		String slice = chunking.charSequence().toString();
		for (Iterator<Chunk> it = sentences.iterator(); it.hasNext();) {
			Chunk sentence = it.next();
			int start = sentence.start();
			int end = sentence.end();
			String text2 = slice.substring(start, end);
			cs.run(text2);
				
		}
		FileInputStream Stream = new FileInputStream("Affective/Doc.txt");
		BufferedReader St = new BufferedReader(new InputStreamReader(Stream));
		String emotion;
		List<String> emotionList = new ArrayList<String>();
		while ((emotion = St.readLine()) != null) {
		    emotionList.add(emotion);
		    }
		tf(emotionList);
		St.close();
		
	}
	
	
	 public static void tf(List<String> words) throws IOException, InterruptedException {
		 int len = words.size();
		 Integer n = 0;
		 Map<String, Integer> map = new HashMap<>();
		    for (String w : words) {
		         n = map.get(w);
		        n = (n == null) ? 1 : ++n;
		        map.put(w, n); 
		    }
		  calculateTf(map, len);
		  

	    }
	 
	 public static void calculateTf(Map<String, Integer> mp, int l) {
		    Iterator<?> it = mp.entrySet().iterator();
		    while (it.hasNext()) {
		        Map.Entry pair = (Map.Entry)it.next();
		        Integer i = new Integer((int) pair.getValue());
		        double d = i.doubleValue();
		        System.out.println(pair.getKey() + " = " + (d/l));
		        it.remove(); // avoids a ConcurrentModificationException
		    }
		}
	 
	

		
	}
 
  


