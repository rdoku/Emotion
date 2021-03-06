package emotion;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Class to read documents
 *
 * @author Mubin Shrestha
 */
public class DocumentParser {

    //This variable will hold all terms of each document in an array.
    private List<String[]> termsDocsArray = new ArrayList<>();
    private List<String> allTerms = new ArrayList<>(); //to hold all terms
    private List<double[]> tfidfDocsVector = new ArrayList<>();

    /**
     * Method to read files and store in array.
     * @param filePath : source file path
     * @throws FileNotFoundException
     * @throws IOException
     */
    public void parseFiles(String filePath) throws FileNotFoundException, IOException {
        File[] allfiles = new File(filePath).listFiles();
        BufferedReader in = null;
        for (File f : allfiles) {
            if (f.getName().endsWith(".txt")) {
                in = new BufferedReader(new FileReader(f));
                StringBuilder sb = new StringBuilder();
                String s = "";
                while ((s = in.readLine()) != null) {
                	//   System.out.println(s);
                    sb.append(s);
                    sb.append(" ");
                }
               
                String newStr = sb.toString().replaceAll("\\(.*?\\)", "");
                newStr = newStr.replaceAll("\\[.*?\\]", "");
                String[] tokenizedTerms = newStr.replaceAll("[\\W&&[^\\s]]", "").split("\\W+");   //to get individual terms
                for (String term : tokenizedTerms) {
                    if (!allTerms.contains(term)) {  //avoid duplicate entry
                        allTerms.add(term);
                        
                    }
                }
                termsDocsArray.add(tokenizedTerms);
                in.close();
            }
        }
        

    }

    /**
     * Method to create termVector according to its tfidf score.
     */
    public void tfIdfCalculator() {
        double tf; //term frequency
        double idf; //inverse document frequency
        double tfidf; //term requency inverse document frequency        
        for (String[] docTermsArray : termsDocsArray) {
            double[] tfidfvectors = new double[allTerms.size()];
            int count = 0;
            for (String terms : allTerms) {
                tf = new TfIdf().tfCalculator(docTermsArray, terms);
                idf = new TfIdf().idfCalculator(termsDocsArray, terms);
                tfidf = tf * idf;
                tfidfvectors[count] = tfidf;
                count++;
            }
            tfidfDocsVector.add(tfidfvectors);  //storing document vectors;            
        }
    }

    /**
     * Method to calculate cosine similarity between all the documents.
     * @throws IOException 
     */
    public void getCosineSimilarity() throws IOException {
    	BufferedWriter ang = new BufferedWriter(new FileWriter("Final/MT.txt", true));
        ang.write(new CosineSimilarity().cosineSimilarity(tfidfDocsVector.get(0),
        		tfidfDocsVector.get(1)) + "\n");  
        ang.close();
    }
  
    
}
