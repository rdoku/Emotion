package emotion;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;



	public class Test extends BufferedReader {
	    Set<String> lines = new HashSet<String>();

	    public Test(Reader arg0) {
	        super(arg0);
	    }
	

	    @Override
	    public String readLine() throws IOException {
	        String uniqueLine;
	        while (lines.add(uniqueLine = super.readLine()) == false); //read until encountering a unique line
	           
	        return uniqueLine;
	    }

	    public static void main(String args[]) {
	        try {
	            FileInputStream fstream = new FileInputStream(
	                    "Emot/Sadness1.txt");
	            Test br = new Test(new InputStreamReader(fstream));
	            String strLine;
	            BufferedWriter bw = null;
	            bw = new BufferedWriter(new FileWriter("Emot/Sadness2.txt", true));
	            // Read File Line By Line
	            Stopwords f = new Stopwords();    
	            
	         	

	            while ((strLine = br.readLine()) != null) {
	                // Print the content on the console
	            	//    strLine = strLine.replaceAll("\\s+", "\n");
	            	//	strLine = strLine.replaceAll("(?m)^\\s", "");
	            	strLine = MorphaStemmer.detokenize(strLine);
	            	strLine = f.removeStemmedStopWords(strLine);
	            		bw.write(strLine);
	            		bw.newLine();
	                  //  System.out.println(strLine);
	            }
	            // Close the input stream
	            fstream.close();
	            br.close();
	            bw.close();
	        } catch (Exception e) {// Catch exception if any
	            System.err.println("Error: " + e.getMessage());
	        }

	    }
	
}



   

