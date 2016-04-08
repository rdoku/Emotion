package emotion;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;

public class CleanDirectory {

	public static void cleanDirs(File dir) throws IOException, InterruptedException
	{
		System.gc();//Added this part
        Thread.sleep(2000);//This part gives the Bufferedreaders and the InputStreams time to close Completely
        FileUtils.cleanDirectory(dir); 
	}
	
	public static void dirClean(File directory) throws IOException, InterruptedException
	{
		File[] files = directory.listFiles();
		for (File file : files)
		{
			System.gc();//Added this part
	        Thread.sleep(100);
		   if (!file.delete())
		   {
		       System.out.println("Failed to delete "+file);
		   }
		} 
	}
}
