package emotion;

import edu.stanford.nlp.tagger.maxent.MaxentTagger;
import edu.stanford.nlp.trees.GrammaticalStructure;
import edu.stanford.nlp.trees.GrammaticalStructureFactory;
import edu.stanford.nlp.trees.PennTreebankLanguagePack;
import edu.stanford.nlp.trees.Tree;
import edu.stanford.nlp.trees.TreebankLanguagePack;

import java.io.IOException;

public class StandfordTagger {
	
public static void main(String[] args) throws IOException,
    ClassNotFoundException {

// Initialize the tagger
MaxentTagger tagger = new MaxentTagger("taggers/english-left3words-distsim.tagger");
// The sample string
String sample = "This is not a bad idea";
// The tagged string
String tagged = tagger.tagString(sample);
// Output the result
System.out.println(tagged);
//One time setup

	
	}

}
