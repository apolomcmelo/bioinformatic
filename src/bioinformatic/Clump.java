package bioinformatic;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;

public class Clump {

    public static SortedSet<String> getClumps(String gen, int k, int L, int t) {
        SortedSet<String> cl = new TreeSet<String>();
        Map<String, Integer> map = new HashMap<String, Integer>();

        String fP = "";

        // Analyze first window
        int iS = L - k;
        for (int i = 0; i <= iS; i++) {
            String pat = gen.substring(i, i + k);
            if (i == 0) {
                fP = pat;
            }

            if (!map.containsKey(pat)) {
                map.put(pat, 1);
            } else {
                map.put(pat, map.get(pat) + 1);
            }

            if (map.get(pat) == t) {
                cl.add(pat);
            }
        }

        iS = gen.length() - L;

        for (int i = 1; i <= iS; i++) {
            map.put(fP, (map.get(fP) - 1));
            fP = gen.substring(i, i + k);
            String pat = gen.substring(i + L - k, i + L);

            if (!map.containsKey(pat)) {
                map.put(pat, 1);
            } else {
                map.put(pat, map.get(pat) + 1);
            }

            if (map.get(pat) == t) {
                cl.add(pat);
            }
        }

        for (String p : cl) {
            System.out.println(p + " ");
        }

        return cl;
    }

    public static List<String> getClumpsNEW(String g, int k, int L, int t) {
        Set<String> cl = new HashSet<String>();
        Map<String, Integer> map = new HashMap<String, Integer>();

        String fP = g.substring(0, k);
        map.put(fP, 1);

        // Analyze first window
        int iS = L - k;
        for (int i = 1; i <= iS; i++) {
            String pat = g.substring(i, i + k);

            if (!map.containsKey(pat)) {
                map.put(pat, 0);
            }

            map.put(pat, map.get(pat) + 1);

            if (map.get(pat) == t) {
                cl.add(pat);
            }
        }

        iS = g.length() - L;

        for (int i = 1; i <= iS; i++) {
            map.put(fP, (map.get(fP) - 1));
            fP = g.substring(i, i + k);
            String pat = g.substring(i + L - k, i + L);

            if (!map.containsKey(pat)) {
                map.put(pat, 0);
            }

            map.put(pat, map.get(pat) + 1);

            if (map.get(pat) == t) {
                cl.add(pat);
            }
        }

        List<String> sortedList = new ArrayList<String>(cl);
        Collections.sort(sortedList);

        for (String p : sortedList) {
            System.out.print(p + " ");
        }

        return sortedList;
    }

    // Funciona para numeros pequenos
    // @SuppressWarnings("unused")
    // private long[] solveChallengeOLD(int[] arr) {
    //
    // long[] miniMax = new long[2];
    // Arrays.fill(miniMax, 0);

    // Compute sum of first window of size k
    // for (int i = 0; i < arr.length - 1; i++) {
    // miniMax[0] += arr[i];
    // }
    //
    // miniMax[1] = miniMax[0];

    // Compute sums of remaining windows by
    // removing first element of previous
    // window and adding last element of
    // current window.
    // long curr_sum = miniMax[0];
    // for (int i = arr.length - 1; i < arr.length; i++) {
    // curr_sum += arr[i] - arr[i - (arr.length - 1)];
    // miniMax[0] = Math.min(miniMax[0], curr_sum);
    // miniMax[1] = Math.max(miniMax[1], curr_sum);
    //
    // }
    //
    // return miniMax;
    // }
}
