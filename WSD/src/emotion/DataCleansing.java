package emotion;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class DataCleansing {
	public void getFileName(String fileName) throws IOException, FileNotFoundException {
		FileReader fr = new FileReader(fileName);
		BufferedReader br = new BufferedReader(fr);
		FileWriter fw = new FileWriter("Translated/data.txt");
		FileWriter s = new FileWriter("Translated/2nd.txt");
		String line, line2, line3;
		Stopwords f = new Stopwords();
		while ((line = br.readLine()) != null) {
			line = line.trim(); // remove leading and trailing whitespace
			if (!line.equals("")) // don't write out blank lines
			{
				line = line.replaceAll("\\[.*?\\]", "");
				line = line.replaceAll("\\(.*?\\)", "");
				line = line.replaceAll("[0-9]", "");
			 	//line2 = f.removeStemmedStopWords(line);
			 	line2 = MorphaStemmer.detokenize(line);
				line3 = f.removeStemmedStopWords(line2);
				fw.write(line, 0, line.length());
				s.write(line3, 0, line3.length());
			}
		}
		fr.close();
		fw.close();
		s.close();
	}
}
