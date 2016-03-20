package emotion;
import com.memetix.mst.language.Language;
import com.memetix.mst.translate.Translate;

public class MicrosoftTranslator2 {
    public String BingTranslate(String text) throws Exception {
        Translate.setClientId("translator_4_WSD");
        Translate.setClientSecret("jUsEQMovNRaJ2AUSxhbUwFZLInYWSghAYPt4huJxlm0=");
        String frenchText = Translate.execute(text, Language.ENGLISH, Language.GERMAN);
        String englishText = Translate.execute(frenchText, Language.GERMAN, Language.ENGLISH);
        return englishText;
    }
}
