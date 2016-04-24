package emotion;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Random;

import org.apache.commons.io.IOUtils;
import org.apache.commons.io.LineIterator;

public class ReadLine {
	
	public static void main(String[] args) throws FileNotFoundException
	{
		int maxLines = (randInt(3,9));
		int start = (randInt(1,210));
		int end = start + maxLines;
	//	BufferedWriter toTest = new BufferedWriter(new FileWriter("test.txt"));
		String fn = "Test/Anger.txt";
	
		for (int i = start; i < end; i++)
		{	
			System.out.println(getLine(fn,i));
		}
		 //toTest.close();
	}
	
	public static int randInt(int min, int max) {
	    Random rand = new Random();
	    int randomNum = rand.nextInt((max - min) + 1) + min;
	    return randomNum;
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

}
