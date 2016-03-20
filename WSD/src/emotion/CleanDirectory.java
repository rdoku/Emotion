package emotion;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;

public class CleanDirectory {

	public static void cleanDirs(File dir) throws IOException
	{
	FileUtils.cleanDirectory(dir); 
	}
}
