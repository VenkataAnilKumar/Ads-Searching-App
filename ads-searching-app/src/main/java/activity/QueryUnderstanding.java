package activity;

import org.apache.lucene.analysis.CharArraySet;
import org.apache.lucene.analysis.TokenStream;
import org.apache.lucene.analysis.core.StopAnalyzer;
import org.apache.lucene.analysis.tokenattributes.CharTermAttribute;
import org.apache.lucene.util.Version;

import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class QueryUnderstanding {
    private static QueryUnderstanding instance = null;
    private static String stopWords = "a,able,about,across,after,all,almost,also," +
            "am,among,an,and,any,are,as,at,be,because,been,but,by,can,cannot,could," +
            "dear,did,do,does,either,else,ever,every,for,from,get,got,had,has,have," +
            "he,her,hers,him,his,how,however,i,if,in,into,is,it,its,just,least,let,like," +
            "likely,may,me,might,most,must,my,neither,no,nor,not,of,off,often,on,only,or," +
            "other,our,own,rather,said,say,says,she,should,since,so,some,than,that,the,their," +
            "them,then,there,these,they,this,tis,to,too,twas,us,wants,was,we,were,what,when," +
            "where,which,while,who,whom,why,will,with,would,yet,you,your";
    protected QueryUnderstanding() {
    }

    public static QueryUnderstanding getInstance() {
        if (instance == null) {
            instance = new QueryUnderstanding();
        }
        return instance;
    }

    public String[] parseQuery(String query) {

        Reader r = new StringReader(query);

        List<String> words = new ArrayList<String>();

        TokenStream stream = new StopAnalyzer(getStopwords(stopWords)).tokenStream("", r);

        try {
            stream.reset();

            CharTermAttribute termAtt = stream.getAttribute(CharTermAttribute.class);

            while (stream.incrementToken()) {
                words.add(termAtt.toString());
            }
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }

        return deduplicate(words);
    }

    private String[] deduplicate(List<String> words) {
        Set<String> hashSet = new HashSet<String>();
        List<String> dedupedWords = new ArrayList<String>();

        for (String str : words) {
            if (hashSet.add(str)) {
                dedupedWords.add(str);
            }
        }
        return dedupedWords.toArray(new String[dedupedWords.size()]);
    }

    private static CharArraySet getStopwords(String stopwords) {
        List<String> stopwordsList = new ArrayList<String>();
        for (String stop : stopwords.split(",")) {
            stopwordsList.add(stop.trim());
        }
        return new CharArraySet(stopwordsList, true);
    }

}
