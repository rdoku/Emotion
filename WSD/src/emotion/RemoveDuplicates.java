package emotion;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

public class RemoveDuplicates {
	
	public static void main(String[] args) throws IOException
	{
		stripDuplicatesFromFile("Emot/Anger1.txt");
	}

	public static void stripDuplicatesFromFile(String filename) throws IOException {
	    BufferedReader reader = new BufferedReader(new FileReader(filename));
	    Set<String> lines = new HashSet<String>(10000); // maybe should be bigger
	    String line;
	    while ((line = reader.readLine()) != null) {
	        lines.add(line);
	    }
	    reader.close();
	    BufferedWriter writer = new BufferedWriter(new FileWriter(filename));
	    for (String unique : lines) {
	    	//unique.replaceAll("\\s+", "\n");
	    //    writer.write(unique.replaceAll("\\s+", "\n"));
	    	//writer.write(unique);
	   //    unique.replaceAll("(?m)^[ \t]*\r?\n", "");
	        writer.newLine();
	    }
	    writer.close();
	}
}
