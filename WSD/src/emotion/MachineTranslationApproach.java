package emotion;

import java.io.File;
import java.util.Scanner;

public class MachineTranslationApproach {
	public void machineTranslation(String fileName) throws Exception {
		DataCleansing clean = new DataCleansing();   //cleanses data
		System.out.println("Beginining Machine Translation");
		clean.getFileName(fileName);
		String cleansedData = "Translated/data.txt";
		DataTranslator translateData = new DataTranslator(); 
		translateData.Translate(cleansedData);
		MergerFiles.merge(); //Merges translated data with original data
		KeywordExtractor  kw = new KeywordExtractor();
		Scanner sc = new Scanner(new File("Data/merged.txt"));
		String text = sc.useDelimiter("\\Z").next();
		text = text.toLowerCase();
		sc.close();
		kw.angryWords(text);
		kw.happyWords(text);
		kw.disgustWords(text);
		kw.fearWords(text);
		kw.sadWords(text);
		kw.surpriseWords(text);
		TfIdfScore_Similarity.getData();
		File data =new File( "Data");
		File trans =  new File("Translated");
		File affective = new File("Emotion");
	    CleanDirectory.dirClean(affective);
	    CleanDirectory.dirClean(data);
		CleanDirectory.dirClean(trans);
		System.out.println("Machine Translation done.");
	}

	
	

	
	
}
