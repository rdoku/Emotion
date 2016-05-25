package emotion;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class StopwordList {
	
	public  boolean isStopWord(String word) throws IOException{
		FileInputStream Stream = new FileInputStream("Stopwords.txt");
		BufferedReader St = new BufferedReader(new InputStreamReader(Stream));
		String emotion;
		List<String> emotionList = new ArrayList<String>();
		while ((emotion = St.readLine()) != null) {
			emotion = emotion.trim();
			emotion = MorphaStemmer.stem(emotion);
		    emotionList.add(emotion);
		    }
		St.close();
		String[] emotionArray = emotionList.toArray(new String[0]);
		Set<String> emotionWordSet = new HashSet<String>(Arrays.asList(emotionArray));
		word = MorphaStemmer.stem(word);
		for (String s : emotionWordSet) {
		    if (s.trim().equals(word))
		    {
		    	return true;
		    }
		}
		return false;
	}
	
	
	public  String removeStopWords(String string) throws IOException {
		
		String result = "";
		String[] words = string.split("\\s+");
		for(String word : words) {
			if(word.isEmpty()) continue;
			if(isStopWord(word)) 
				continue; //remove stopwords
			result += (word+" ");
		}
		return result;
	}
}
