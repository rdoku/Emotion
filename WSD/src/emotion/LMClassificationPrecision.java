package emotion;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.apache.commons.io.IOUtils;
import org.apache.commons.io.LineIterator;

public class LMClassificationPrecision {
static 	double TP = 0.0, TN = 0.0, FN = 0.0, FP = 0.0;  //declaring variables
	
	/*Get random numbers*/
	
	public static int randInt(int min, int max) {
	    Random rand = new Random();
	    int randomNum = rand.nextInt((max - min) + 1) + min;
	    return randomNum;
	}
	
	/*Method to return random file other than the parameter*/
	
	public static String returnRandomFile(String compare)
	{
		List<String> randFile = new ArrayList<String>();
		randFile.add("Test/Anger.txt");
		randFile.add("Test/Disgust.txt");
		randFile.add("Test/Fear.txt");
		randFile.add("Test/Happiness.txt");
		randFile.add("Test/Sadness.txt");
		randFile.remove(compare);
		Random randomizer = new Random();
		String random = randFile.get(randomizer.nextInt(randFile.size()));
		
		
		return random;
	}
	
	public static String getLine(String fileName, int n) throws FileNotFoundException
	{
		String result = "";
		LineIterator it = IOUtils.lineIterator(
				new BufferedReader(new FileReader(fileName)));
			 for (int lineNumber = 0; it.hasNext(); lineNumber++) {
			    String line = (String) it.next();
			    if (lineNumber == n) {
			        result = line;
			    }
			 }
			 return result;
	}

	
	public static void createTestFile (String fileName) throws IOException
	{
		int maxLines = (randInt(2,11)); // get two to 11 lines
		int start = (randInt(1,210)); // pick a random number to start at
		int end = start + maxLines; //add the maximmum number of lines to know the line to end at
		BufferedWriter toTest = new BufferedWriter(new FileWriter("test.txt"));
		
		for (int i = start; i < end; i++)
		{	
			toTest.write(getLine(fileName,i));
		}
		toTest.close();
	}
	
	
 public static void runActual (String fn) throws Exception
 {
		createTestFile(fn);
		String fileName =  "test.txt";
		String emotion = fn.replaceAll(".txt", "");
	    emotion = emotion.replaceAll("Test/", "");
		
	    LMClassifier lmc = new LMClassifier();
		lmc.lm(fileName);
		GetScores gs = new GetScores();
		String predicted = gs.getLMscore();
		
		File fin = new File("Final");
		CleanDirectory.dirClean(fin);
		
		if (predicted.equals(emotion))
		{
			TP++;
		}
		if (!(predicted.equals(emotion)))
		{
			FP++;
		}
			
 }
 
 

 public static void runNotActual (String fn) throws Exception
 {
	    String not = returnRandomFile(fn);
		createTestFile(not);
		String fileName =  "test.txt";
		String emotion = fn.replaceAll(".txt", "");
	    emotion = emotion.replaceAll("Test/", "");
		
	    LMClassifier lmc = new LMClassifier();
		lmc.lm(fileName);
		GetScores gs = new GetScores();
		String predicted = gs.getLMscore();
		
		File fin = new File("Final");
		CleanDirectory.dirClean(fin);
		
		
		if (predicted.equals(emotion))
		{
			FN++;
		}
		if (!(predicted.equals(emotion)))
		{
			TN++;
		}
 }
	
	public static void main(String[] args) throws Exception
	{
		System.out.println("LM Precision and Recall");
		String fn = "Test/Anger.txt";
		
		for (int i = 0; i < 500; i++)
		{
			System.out.println("Beginning Iteration " + i);
			System.out.println("Checking for actual ");
			runActual(fn);
			System.out.println("Checking for Not actual ");
			runNotActual(fn);
			System.out.println("Ending Iteration " + i);
		}
		
		
		System.out.println("FN " +FN);
		System.out.println("TN " +TN);
		System.out.println("FP " +FP);
		System.out.println("TP "+TP); 
		
		double preci = (TP)/(TP+FP);
		System.out.println("Precision for " + fn + " is " + preci);
		
		double recall = (TP)/(TP+FN);
		System.out.println("Recall for " + fn + " is " + recall); 
		
		double accuracy = ((TP + TN)/(TP + TN + FP + FN));
		System.out.println("Accuracy for " + fn + " is " + accuracy); 
		
		double F1 = ((2 * TP)/ ((2 * TP) + FP + FN));
		System.out.println("F1 measure for " + fn + " is " + F1); 
		
		
	}

}
