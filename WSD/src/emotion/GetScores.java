package emotion;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class GetScores {
	
	public  String getEmotion() throws IOException
	{
		String result = " ";
		double anger = 0.00;
		double fear = 0.00;
		double surprise = 0.00;
		double happy = 0.00;
		double sadness = 0.00;
		double disgust = 0.000;
		
		FileInputStream Stream = new FileInputStream("Final/MT.txt");
		BufferedReader mt = new BufferedReader(new InputStreamReader(Stream));
		String emotion;
		HashMap<Integer, String> hmap = new HashMap<Integer, String>();
		int i = 0;
		while (((emotion = mt.readLine()) != null) & i < 6)  {
				hmap.put(i, emotion);
				i++;
		    }
		
		mt.close();
		
		FileInputStream st = new FileInputStream("Final/LM.txt");
		BufferedReader lm = new BufferedReader(new InputStreamReader(st));
		String emo;
		while ((emo = lm.readLine()) != null)  {
			if (emo.contains("anger"))
			{
				String ang = emo.substring(emo.lastIndexOf("=") + 1);
				anger = Double.parseDouble(ang);
				
			}
			if (emo.contains("disgust"))
			{
				String dis = emo.substring(emo.lastIndexOf("=") + 1);
				disgust = Double.parseDouble(dis);
			}
			if (emo.contains("fear"))
			{
				String fr = emo.substring(emo.lastIndexOf("=") + 1);
				fear = Double.parseDouble(fr);
			}
			if (emo.contains("happiness"))
			{
				String hap = emo.substring(emo.lastIndexOf("=") + 1);
				happy = Double.parseDouble(hap);
				
			}
			if (emo.contains("surprise"))
			{
				String sur = emo.substring(emo.lastIndexOf("=") + 1);
				surprise = Double.parseDouble(sur);
			}
			if (emo.contains("sadness"))
			{
				String sad = emo.substring(emo.lastIndexOf("=") + 1);
				sadness = Double.parseDouble(sad);
			}
			
	    } 
	
			double anger2 = Double.parseDouble(hmap.get(0));
			double disgust2 = Double.parseDouble(hmap.get(1));
			double fear2 = Double.parseDouble(hmap.get(2));
			double happy2 = Double.parseDouble(hmap.get(3));
			double sadness2 = Double.parseDouble(hmap.get(4));
			double surprise2 = Double.parseDouble(hmap.get(5));
		
	
			double Anger = anger + anger2;
			double Disgust = disgust + disgust2;
			double Fear =  fear + fear2;
			double Happy = happy + happy2;
			double Sadness = sadness + sadness2;
			double Surprise = surprise + surprise2;
			
		
		Map<String, Double> map = new HashMap<>();
		map.put("Anger", Anger);
		map.put("Disgust", Disgust);
		map.put("Fear", Fear);
		map.put("Happiness", Happy);
		map.put("Sadness", Sadness);
		map.put("Surprise", Surprise);
		
		double maxValueInMap=(Collections.max(map.values()));  // This will return max value in the Hashmap
        for (Entry<String, Double> entry : map.entrySet()) {  // Itrate through hashmap
            if (entry.getValue()==maxValueInMap) {
                result = entry.getKey();     // Print the key with max value
            }
        }
		
		lm.close();
		return result;
	}

	
	public static void  getEmotionScores() throws IOException
	{
		double anger = 0.01;
		double fear = 0.01;
		double surprise = 0.01;
		double happy = 0.01;
		double sadness = 0.01;
		double disgust = 0.01;
		
		FileInputStream Stream = new FileInputStream("Final/MT.txt");
		BufferedReader mt = new BufferedReader(new InputStreamReader(Stream));
		String emotion;
		HashMap<Integer, String> hmap = new HashMap<Integer, String>();
		int i = 0;
		while (((emotion = mt.readLine()) != null) & i < 6)  {
				hmap.put(i, emotion);
				i++;
		    }
		
		mt.close();
		
		FileInputStream st = new FileInputStream("Final/LM.txt");
		BufferedReader lm = new BufferedReader(new InputStreamReader(st));
		String emo;
		while ((emo = lm.readLine()) != null)  {
			if (emo.contains("anger"))
			{
				String ang = emo.substring(emo.lastIndexOf("=") + 1);
				anger = Double.parseDouble(ang);
				
			}
			if (emo.contains("disgust"))
			{
				String dis = emo.substring(emo.lastIndexOf("=") + 1);
				disgust = Double.parseDouble(dis);
			}
			if (emo.contains("fear"))
			{
				String fr = emo.substring(emo.lastIndexOf("=") + 1);
				fear = Double.parseDouble(fr);
			}
			if (emo.contains("happiness"))
			{
				String hap = emo.substring(emo.lastIndexOf("=") + 1);
				happy = Double.parseDouble(hap);
				
			}
			if (emo.contains("surprise"))
			{
				String sur = emo.substring(emo.lastIndexOf("=") + 1);
				surprise = Double.parseDouble(sur);
			}
			if (emo.contains("sadness"))
			{
				String sad = emo.substring(emo.lastIndexOf("=") + 1);
				sadness = Double.parseDouble(sad);
			}
			
	    } 
	
			double anger2 = Double.parseDouble(hmap.get(0));
			double disgust2 = Double.parseDouble(hmap.get(1));
			double fear2 = Double.parseDouble(hmap.get(2));
			double happy2 = Double.parseDouble(hmap.get(3));
			double sadness2 = Double.parseDouble(hmap.get(4));
			double surprise2 = Double.parseDouble(hmap.get(5));
		
	
		
		System.out.print("Anger = ");
		System.out.println(anger2 + anger);
		
		System.out.print("Disgust = ");
		System.out.println(disgust2 + disgust);
		
		System.out.print("Happy = ");
		System.out.println(happy2 + happy);
		
		System.out.print("Fear = ");
		System.out.println(fear2 + fear);
		
		System.out.print("Surprise = ");
		System.out.println(surprise2 + surprise);
		
		System.out.print("Sadness = ");
		System.out.println(sadness2 + sadness);
		
		lm.close();
		
	}
}
