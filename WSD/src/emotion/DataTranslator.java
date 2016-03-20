package emotion;

//	File file = new File("data/sentence_demo.txt");
import com.aliasi.chunk.Chunk;
import com.aliasi.chunk.Chunking;

import com.aliasi.sentences.MedlineSentenceModel;
import com.aliasi.sentences.SentenceChunker;
import com.aliasi.sentences.SentenceModel;

import com.aliasi.tokenizer.IndoEuropeanTokenizerFactory;
import com.aliasi.tokenizer.TokenizerFactory;

import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.Set;
import org.apache.commons.io.FileUtils;

/** Use SentenceModel to find sentence boundaries in text */
public class DataTranslator {
	static final TokenizerFactory TOKENIZER_FACTORY = IndoEuropeanTokenizerFactory.INSTANCE;
	static final SentenceModel SENTENCE_MODEL = new MedlineSentenceModel();
	static final SentenceChunker SENTENCE_CHUNKER = new SentenceChunker(TOKENIZER_FACTORY, SENTENCE_MODEL);
	public  void Translate(String cleansedData) throws Exception {
		String text = FileUtils.readFileToString(new File(cleansedData));
		Chunking chunking = SENTENCE_CHUNKER.chunk(text.toCharArray(), 0, text.length());
		Set<Chunk> sentences = chunking.chunkSet();
		if (sentences.size() < 1) {
			System.out.println("No sentence chunks found.");
			return;
		}
		String slice = chunking.charSequence().toString();
		// int i = 1;
		for (Iterator<Chunk> it = sentences.iterator(); it.hasNext();) {
			Chunk sentence = it.next();
			int start = sentence.start();
			int end = sentence.end();
			MicrosoftTranslator1 french = new MicrosoftTranslator1();
			MicrosoftTranslator2 dutch = new MicrosoftTranslator2();
			String text2Translate, frenchTranslated, dutchTranslated;
			// System.out.println("SENTENCE "+(i++)+":");
			text2Translate = slice.substring(start, end);
			text2Translate = text2Translate.replaceAll("\\[.*?\\]", "");
			text2Translate = text2Translate.replaceAll("\\(.*?\\)", "");
			frenchTranslated = french.BingTranslate(text2Translate);
			dutchTranslated = dutch.BingTranslate(text2Translate);
			Stopwords d = new Stopwords();
			String german = MorphaStemmer.detokenize(dutchTranslated);
			String frn = MorphaStemmer.detokenize(frenchTranslated);
		    Stopwords f = new Stopwords();
		    frn = f.removeStemmedStopWords(frn);
		    german = d.removeStemmedStopWords(german);
			PrintWriter frenchWriter = new PrintWriter(new FileWriter("Translated/French.txt", true));
			PrintWriter dutchWriter = new PrintWriter(new FileWriter("Translated/Dutch.txt", true));
			frenchWriter.write(frn);
			dutchWriter.write(german);
			frenchWriter.close();
			dutchWriter.close();

		}

	}
}
