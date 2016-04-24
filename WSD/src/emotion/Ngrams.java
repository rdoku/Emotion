package emotion;

import java.util.*;

public class Ngrams {

    public static String ngrams(int n, String str) {
        List<String> ngrams = new ArrayList<String>();
        String[] words = str.split(" ");
        for (int i = 0; i < words.length - n + 1; i++)
            {ngrams.add(concat(words, i, i+n));}
        
        return ngrams.get(0);
    }

    public static String concat(String[] words, int start, int end) {
        StringBuilder sb = new StringBuilder();
        for (int i = start; i < end; i++)
            sb.append((i > start ? " " : "") + words[i]);
        return sb.toString();
    }

    public static void main(String[] args) {
    	 try
     {
    	String username = "omg!! he gets on my nerves so bad.";
    	int len = username.length();
        for (int n = 1; n < len-1; n++) {
        	{ System.out.println(ngrams(n,username));}
            System.out.println();
     }
    
    }catch (IndexOutOfBoundsException e)
    {
        System.out.println("jonglyo");
     }
}
}
