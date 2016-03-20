package emotion;

import java.io.File;

public class Driver {
	public static void main(String[] args) throws Exception {
		String fileName = "Other/firstout.txt";
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
		TfIdfScore_Similarity.getData();
		System.out.println("Cleaning Directories... ");
		File data =new File( "Data");
		File trans =  new File("Translated");
		CleanDirectory.cleanDirs(data);
		CleanDirectory.cleanDirs(trans);
		
	}



	
	
}
