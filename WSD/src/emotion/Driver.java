package emotion;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Scanner;

public class Driver {
	public static void main(String[] args) throws Exception {
		String fileName = "Other/sample.txt";
		DataCleansing clean = new DataCleansing();   //cleanses data
		System.out.println("Cleansing data... ");
		clean.getFileName(fileName);
		String cleansedData = "Translated/data.txt";
		System.out.println("Translating Data... ");
		DataTranslator translateData = new DataTranslator(); //translates cleansed data into french and dutch and then back to english
		translateData.Translate(cleansedData);
		System.out.println("Merging Files... ");
		MergerFiles.merge(); //Merges translated data with original data
		System.out.println("Getting Emotion Scores... ");
		KeywordExtractor  kw = new KeywordExtractor();
		Scanner sc = new Scanner(new File("Data/merged.txt"));
		String text = sc.useDelimiter("\\Z").next();
		sc.close();
		kw.angryWords(text);
		kw.happyWords(text);
		kw.disgustWords(text);
		kw.fearWords(text);
		kw.sadWords(text);
		kw.surpriseWords(text);
		TfIdfScore_Similarity.getData();
		System.out.println("Cleaning Directories... ");
		File data =new File( "Data");
		File trans =  new File("Translated");
		File affective = new File("Emotion");
	    CleanDirectory.dirClean(affective);
	    CleanDirectory.dirClean(data);
		CleanDirectory.dirClean(trans);
	
		
	}

	
	static String readFile(String path, Charset encoding) 
			  throws IOException 
			{
			  byte[] encoded = Files.readAllBytes(Paths.get(path));
			  return new String(encoded, encoding);
			}



	
	
}
