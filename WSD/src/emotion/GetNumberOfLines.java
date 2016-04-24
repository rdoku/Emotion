package emotion;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.LineNumberReader;
import java.io.PrintWriter;
import java.text.Normalizer;
import java.util.Scanner;

import org.apache.commons.io.FileUtils;

public class GetNumberOfLines {
	public static void main(String[] args)
	{	
		try{
			

			//	File file =new File("Testing/IsearAnger.txt");
			File dir = new File("Testing"); //Emotion directory
			File[] directoryListing = dir.listFiles();
			if (directoryListing != null) {
				for (File child : directoryListing) {
					File file = new File("Testing/"+child.getName());
					String emotion =  child.getName();
					//emotion = emotion.replaceAll(".txt", "");
					System.out.println(emotion);
					emotion = "Test/" + emotion;
					if(file.exists()){

						FileReader fr = new FileReader(file);
						LineNumberReader lnr = new LineNumberReader(fr);

						int linenumber = 0;

						while (lnr.readLine() != null){
							linenumber++;
						}

						System.out.println("Total number of lines : " + linenumber);

						lnr.close();
						 Scanner input = new Scanner(file);
						 double newLine =  linenumber * 0.1;
						 int l = (int) newLine;
						 System.out.println(l);
					     int counter = 0;
					     while(input.hasNextLine() && counter < l)
					     {
					    	 BufferedWriter tf = new BufferedWriter(new FileWriter(emotion, true));
					    	 tf.write(input.nextLine() + "\n");
					         counter++;
					         tf.close();
					     }

					     input.close();
					}
					
					else{
						System.out.println("File does not exists!");
					}
				}
			}

				}catch(IOException e){
					e.printStackTrace();
				}
			
		

			}
		}
