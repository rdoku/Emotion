package emotion;

import java.io.File;

public class Main {
	public static void main(String[] args) throws Exception
	{
		String fileName =  "Other/firstout.txt";
		MachineTranslationApproach mta =  new MachineTranslationApproach();
		mta.machineTranslation(fileName);
		LMClassifier lmc = new LMClassifier();
		lmc.lm(fileName);
		GetScores gs = new GetScores();
		System.out.println("Getting scores");
		System.out.println(gs.getEmotion());
		GetScores.getEmotionScores();
		File fin = new File("Final");
		CleanDirectory.dirClean(fin);
	}

}
