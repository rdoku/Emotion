package emotion;


import java.io.File;
import java.io.IOException;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;

public class BaseLine {
	
	public String baseEmotion(String fileName) throws IOException
	{
	//	String line = "I shadow afraid fear sad happy surprised shock insane mad sick loathe cozy pity sorrow wonder awe amazed";
		Scanner sc = new Scanner(new File(fileName));
		String text = sc.useDelimiter("\\Z").next();
		text = text.toLowerCase();
		sc.close();
		String line2 = MorphaStemmer.detokenize(text);
		return getEmotion(line2);
	}

	public static String getEmotion(String line2) throws IOException {
		KeywordExtractor kw = new KeywordExtractor ();
		Map<String, Integer> map = new HashMap<>();
		map.put("Anger", kw.countAngryWords(line2));
		map.put("Disgust", kw.countDisgustWords(line2));
		map.put("Fear", kw.countFearWords(line2));
		map.put("Happiness", kw.countHappyWords(line2));
		map.put("Sadness", kw.countSadWords(line2));
		map.put("Surprise", kw.countSurpriseWords(line2));
		String result = "";
		int maxValueInMap=(Collections.max(map.values()));  // This will return max value in the Hashmap
        for (Entry<String, Integer> entry : map.entrySet()) {  // Itrate through hashmap
            if (entry.getValue()==maxValueInMap) {
                result = entry.getKey();     // Print the key with max value
            }
        }
		
		
		return result;
	}
	

}
