package emotion;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;
import java.util.Set;

import org.apache.commons.io.FileUtils;

import com.aliasi.chunk.Chunk;
import com.aliasi.chunk.Chunking;
import com.aliasi.sentences.MedlineSentenceModel;
import com.aliasi.sentences.SentenceChunker;
import com.aliasi.sentences.SentenceModel;
import com.aliasi.tokenizer.IndoEuropeanTokenizerFactory;
import com.aliasi.tokenizer.TokenizerFactory;


public class Chappelle {
	
	static final TokenizerFactory TOKENIZER_FACTORY = IndoEuropeanTokenizerFactory.INSTANCE;
	static final SentenceModel SENTENCE_MODEL = new MedlineSentenceModel();
	static final SentenceChunker SENTENCE_CHUNKER = new SentenceChunker(TOKENIZER_FACTORY, SENTENCE_MODEL);
	public static void main(String[] args) throws ClassNotFoundException, IOException
	{
		String fileName ="Other/sample.txt";
		getClassification(fileName);
	}
	
	public static void getClassification(String fileName) throws IOException, ClassNotFoundException {
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
	}
		
	}
 
  


