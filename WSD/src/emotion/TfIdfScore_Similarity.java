package emotion;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.File;

public class TfIdfScore_Similarity {
	public static void getData() throws FileNotFoundException, IOException {
		File dir = new File("Emotion");
		File[] directoryListing = dir.listFiles();
		if (directoryListing != null) {
			for (File child : directoryListing) {
				File file = new File("Data/"+child.getName());
				String emotion =  child.getName();
				emotion = emotion.replaceAll(".txt", "");
				System.out.println(emotion);
				MoveFile.fileToMove(child,file);
			}
		} 

	}
}