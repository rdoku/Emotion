package emotion;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

public class KeywordExtractor {
   static  BufferedWriter ang = null;
   static  BufferedWriter dis = null;
   static  BufferedWriter fr = null;
   static  BufferedWriter hap = null;
   static  BufferedWriter sad = null;
   static  BufferedWriter surp = null;
   
   public static boolean isFearword(String word) throws IOException {
		fr = new BufferedWriter(new FileWriter("Emotion/Fear.txt", true));
		FileInputStream Stream = new FileInputStream("Emot/Fear2.txt");
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
			fr.write(s.trim());
			fr.newLine();
		    if (s.trim().equals(word))
		    {
		    	return true;
		    }
		}
		return false;
	}
	
	
	public void fearWords(String string) throws IOException {
		//fr = new BufferedWriter(new FileWriter("Emotion/Fear.txt", true));
		ArrayList<String> emotionArray = new ArrayList<String>();
		StringBuilder emotion = new StringBuilder();
		String[] words = string.split("\\s+");
		for(String word : words) {
			if(isFearword(word))
			{
				emotionArray.add(word);
			}
		}
		
		for (String s : emotionArray)
		{
		    emotion.append(s);
		    emotion.append("\n");
		}
		fr.write(emotion.toString());
		fr.close();
		
	}
 
  
 	
	
	 public static boolean isAngryword(String word) throws IOException {
			ang = new BufferedWriter(new FileWriter("Emotion/Anger.txt", true));
			FileInputStream Stream = new FileInputStream("Emot/Anger2.txt");
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
				ang.write(s.trim());
				ang.newLine();
			    if (s.trim().equals(word))
			    {
			    	return true;
			    }
			}
			return false;
		}
		
		
		public void angryWords(String string) throws IOException {
		//	ang = new BufferedWriter(new FileWriter("Emotion/Anger.txt", true));
			ArrayList<String> emotionArray = new ArrayList<String>();
			StringBuilder emotion = new StringBuilder();
			String[] words = string.split("\\s+");
			for(String word : words) {
				if(isAngryword(word))
				{
					emotionArray.add(word);
				}
			}
			
			for (String s : emotionArray)
			{
			    emotion.append(s);
			    emotion.append("\n");
			}
			ang.write(emotion.toString());
			ang.close();
			
		}
		
		
		 public static boolean isDisgustword(String word) throws IOException {
				dis = new BufferedWriter(new FileWriter("Emotion/Disgust.txt", true));
				FileInputStream Stream = new FileInputStream("Emot/Disgust2.txt");
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
					dis.write(s.trim());
					dis.newLine();
				    if (s.trim().equals(word))
				    {
				    	return true;
				    }
				}
				return false;
			}
			
			
			public void disgustWords(String string) throws IOException {
			//	dis = new BufferedWriter(new FileWriter("Emotion/Disgust.txt", true));
				ArrayList<String> emotionArray = new ArrayList<String>();
				StringBuilder emotion = new StringBuilder();
				String[] words = string.split("\\s+");
				for(String word : words) {
					if(isDisgustword(word))
					{
						emotionArray.add(word);
					}
				}
				
				for (String s : emotionArray)
				{
				    emotion.append(s);
				    emotion.append("\n");
				}
				dis.write(emotion.toString());
				dis.close();
				
			}
		 
	 
	
	
	
	
	public static boolean isSadword(String word) throws IOException {
		sad = new BufferedWriter(new FileWriter("Emotion/Sadness.txt", true));
		FileInputStream Stream = new FileInputStream("Emot/Sadness2.txt");
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
			sad.write(s.trim());
			sad.newLine();
		    if (s.trim().equals(word))
		    {
		    	return true;
		    }
		}
		return false;
	}
	
	
	public void sadWords(String string) throws IOException {
	//	sad = new BufferedWriter(new FileWriter("Emotion/Sadness.txt", true));
		ArrayList<String> emotionArray = new ArrayList<String>();
		StringBuilder emotion = new StringBuilder();
		String[] words = string.split("\\s+");
		for(String word : words) {
			if(isSadword(word))
			{
				emotionArray.add(word);
			}
		}
		
		for (String s : emotionArray)
		{
		    emotion.append(s);
		    emotion.append("\n");
		}
		sad.write(emotion.toString());
 		sad.close();
	}
	
	public static boolean isSurpriseword(String word) throws IOException {
		surp = new BufferedWriter(new FileWriter("Emotion/Surprise.txt", true)); // read surprise keyword text
		FileInputStream Stream = new FileInputStream("Emot/Surprise2.txt"); // Create a new surprise file
		BufferedReader St = new BufferedReader(new InputStreamReader(Stream));
		String emotion;
		List<String> emotionList = new ArrayList<String>(); //Arraylist to store all words
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
			surp.write(s.trim());  
			surp.newLine();
		    if (s.trim().equals(word))
		    {
		    	return true;
		    }
		}
		return false;
		
	}
	
	
	public void surpriseWords(String string) throws IOException {
		//surp = new BufferedWriter(new FileWriter("Emotion/Surprise.txt", true));
		ArrayList<String> emotionArray = new ArrayList<String>();
		StringBuilder emotion = new StringBuilder();
		String[] words = string.split("\\s+");
		for(String word : words) {
			if(isSurpriseword(word))  //calling isSurprise function to check word is a surprise keyword
			{
				emotionArray.add(word); // add keyword to emotion array
			}
		}
		
		for (String s : emotionArray)
		{
		    emotion.append(s);
		    emotion.append("\n");
		}
		surp.write(emotion.toString()); // append emotion keyword to new created so
 		surp.close();
	}
	
	public static boolean isHappyword(String word) throws IOException {
		hap = new BufferedWriter(new FileWriter("Emotion/Happiness.txt", true));
		FileInputStream Stream = new FileInputStream("Emot/Happiness2.txt");
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
			hap.write(s.trim());
			hap.newLine();
		    if (s.trim().equals(word))
		    {
		    	return true;
		    }
		}
		return false;
		
	}
	
	
	public void happyWords(String string) throws IOException {
	//	hap = new BufferedWriter(new FileWriter("Emotion/Happiness.txt", true));
		ArrayList<String> emotionArray = new ArrayList<String>();
		StringBuilder emotion = new StringBuilder();
		String[] words = string.split("\\s+");
		for(String word : words) {
			if(isHappyword(word))
			{
				emotionArray.add(word);
			}
		}
		
		for (String s : emotionArray)
		{
		    emotion.append(s);
		    emotion.append("\n");
		}
		hap.write(emotion.toString());
 		hap.close();
	}
	
	
	
}