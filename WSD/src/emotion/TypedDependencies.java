package emotion;


import edu.stanford.nlp.parser.lexparser.LexicalizedParser;

public class TypedDependencies {

  public static void main(String[] args) {
	  LexicalizedParser lp = new LexicalizedParser("englishPCFG.ser.gz");
	  String sent = "This is one last test!";
	  lp.apply(sent).pennPrint();
	  System.out.print("hey");
  }

 
}