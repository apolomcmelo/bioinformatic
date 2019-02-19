package bioinformatic;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class KMers {
    private static int BASE_4 = 0x4;

    public static int patternCount(String g, String p) {
        int c = 0x0, i = g.indexOf(p, 0x0);

        while (i != -1) {
            c++;
            i++;
            i = g.indexOf(p, i);
        }

        return c;
    }

    public static List<Integer> getPatternMatching(String p, String g) {
        List<Integer> lInd = new ArrayList<Integer>();
        int i = g.indexOf(p, 0x0);

        while (i != -1) {
            lInd.add(i);
            i++;
            i = g.indexOf(p, i);
        }

        return lInd;
    }
    

    public static List<String> frequentWords(String g, int k) {
        HashMap<String, Integer> pats = new HashMap<String, Integer>();
        List<String> lp = new ArrayList<String>();
        int max = 0x0, s = g.length() - k;
        
        for (int i = 0; i <= s; i++) {
            String p = g.substring(i, i+k);
            if (!pats.containsKey(p)) {
                pats.put(p, 1);
            }
            pats.put(p, pats.get(p) + 1);
            if(pats.get(p) > max) {
                max = pats.get(p);
            }
        }
        
        for(String p : pats.keySet()){
            if(pats.get(p) == max){
                lp.add(p);
            }
        }
        
        return lp;
    }

    public static int[] computingFrequencies(String text, int k) {
        int[] frequencyArray = new int[(int) Math.pow(BASE_4, k)];

        for (int i = 0; i < text.length() - (k - 1); i++) {
            long j = patternToNumber(text.substring(i, k + i));
            frequencyArray[(int) j] = frequencyArray[(int) j] + 1;
        }

        return frequencyArray;
    }

    public static long patternToNumber(String p) {
        String b = "ACGT";
        long pn = 0x0;
        int l = p.length() - 0x1;
        for (int i = 0; i <= l; i++) {
            pn += b.indexOf(p.charAt(l - i)) * Math.pow(BASE_4, (i));
        }

        return pn;
    }

    public static String numberToPattern(int in, int k) {
        String b = "ACGT";
        StringBuilder p = new StringBuilder();
        
        for (int i = 0; i < k; i++) {
            p.insert(0, b.charAt(in % BASE_4));
            in /= BASE_4;
        }
        
        return p.toString();
    }
}
