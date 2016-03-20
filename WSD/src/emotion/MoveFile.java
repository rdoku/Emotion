package emotion;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class MoveFile {
	public static void fileToMove(File afile, File bfile) {

		InputStream inStream = null;
		OutputStream outStream = null;
		try {

			inStream = new FileInputStream(afile);
			outStream = new FileOutputStream(bfile);
			byte[] buffer = new byte[1024];
			int length;
			// copy the file content in bytes
			while ((length = inStream.read(buffer)) > 0) {
				outStream.write(buffer, 0, length);

			}

			DocumentParser dp = new DocumentParser();
			dp.parseFiles("Data"); // give the location of source file
			dp.tfIdfCalculator(); // calculates tfidf
			dp.getCosineSimilarity(); // calculates cosine similarity

			inStream.close();
			outStream.close();
			bfile.delete();

		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
