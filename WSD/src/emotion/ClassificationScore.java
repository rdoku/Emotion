package emotion;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import com.aliasi.classify.Classification;
import com.aliasi.classify.Classified;
import com.aliasi.classify.DynamicLMClassifier;
import com.aliasi.lm.NGramProcessLM;

public class ClassificationScore {
	File mPolarityDir;
	String[] mCategories = { "Anger", "Disgust", "Fear", "Happiness", "Sadness", "Surprise" };
	DynamicLMClassifier<NGramProcessLM> mClassifier;

	ClassificationScore() {
		int nGram = 8;
		mClassifier = DynamicLMClassifier.createNGramProcess(mCategories, nGram);
	}

	void run(String str) throws ClassNotFoundException, IOException {
		FileReader angerTxt = new FileReader("Training/AngerTrainingData.txt");
		FileReader disgustTxt = new FileReader("Training/DisgustTrainingData.txt");
		FileReader fearTxt = new FileReader("Training/FearTrainingData.txt");
		FileReader happinessTxt = new FileReader("Training/HappinessTrainingData.txt");
		FileReader sadnessTxt = new FileReader("Training/SadnessTrainingData.txt");
		FileReader surpriseTxt = new FileReader("Training/SurpriseTrainingData.txt");

		Scanner anger = new Scanner(angerTxt);
		Scanner disgust = new Scanner(disgustTxt);
		Scanner fear = new Scanner(fearTxt);
		Scanner happiness = new Scanner(happinessTxt);
		Scanner sadness = new Scanner(sadnessTxt);
		Scanner surprise = new Scanner(surpriseTxt);

		while (anger.hasNextLine()) {
			train(anger.nextLine(), "Anger");
		}

		while (disgust.hasNextLine()) {
			train(disgust.nextLine(), "Disgust");

		}
		while (fear.hasNextLine()) {
			train(fear.nextLine(), "Fear");

		}
		while (happiness.hasNextLine()) {
			train(happiness.nextLine(), "Happiness");

		}
		while (sadness.hasNextLine()) {
			train(sadness.nextLine(), "Sadness");

		}
		while (surprise.hasNextLine()) {
			train(surprise.nextLine(), "Surprise");

		}

		classify(str);
		anger.close();
		disgust.close();
		fear.close();
		happiness.close();
		sadness.close();
		surprise.close();
	}

	// train
	void train(String text, String category) throws IOException {
		Classification classification = new Classification(category);
		Classified<CharSequence> classified = new Classified<CharSequence>(text, classification);
		mClassifier.handle(classified);
	}

	void classify(String text) throws IOException {
		BufferedWriter bw = new BufferedWriter(new FileWriter("Affective/doc.txt", true));
		System.out.println("\nClassifying: " + text);
		Classification classification = mClassifier.classify(text);
		try {
			if (classification.bestCategory() == "Anger") {
				bw.write("anger");
				bw.newLine();
			}

			if (classification.bestCategory() == "Disgust") {
				bw.write("disgust");
				bw.newLine();
			}
			if (classification.bestCategory() == "Fear") {
				bw.write("fear");
				bw.newLine();
			}

			if (classification.bestCategory() == "Happiness") {
				bw.write("happiness");
				bw.newLine();
			}
			if (classification.bestCategory() == "Sadness") {
				bw.write("sadness");
				bw.newLine();
			}

		} catch (Exception e) {
			System.out.println("error in classifying");
		}
		bw.close();

	}
}