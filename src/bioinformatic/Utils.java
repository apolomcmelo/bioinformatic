package bioinformatic;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Utils {
    public static <T, E> Set<T> getKeysByValue(Map<T, E> map, E value) {
//        return map.entrySet().stream().filter(entry -> Objects.equals(entry.getValue(), value)).map(Map.Entry::getKey).collect(Collectors.toSet());
        List<T> keys = new ArrayList<T>(map.keySet());
        Set<T> filteredKeys = new HashSet<>();
        for(int i=0; i<keys.size(); i++) {
            if(map.get(keys.get(i)).equals(value)) {
                filteredKeys.add(keys.get(i));
            }
        }
        
        return filteredKeys;
    }
    
    @SuppressWarnings("hiding")
    public static <T, Boolean> Set<T> getKeysByBooleanValue(Map<T, Boolean> map, Boolean value) {
//      return map.entrySet().stream().filter(entry -> Objects.equals(entry.getValue(), value)).map(Map.Entry::getKey).collect(Collectors.toSet());
      List<T> keys = new ArrayList<T>(map.keySet());
      Set<T> filteredKeys = new HashSet<>();
      for(int i=0; i<keys.size(); i++) {
          if(map.get(keys.get(i)).equals(value)) {
              filteredKeys.add(keys.get(i));
          }
      }
      
      return filteredKeys;
  }

    public static int getMaximumValueInMap(Map<String, Integer> m) {
        List<Integer> v = new ArrayList<Integer>(m.values());
        int max = v.get(0);
        for (int i = 1; i < v.size(); i++) {
            if (v.get(i).intValue() > max) {
                max = v.get(i);
            }
        }

        return max;
    }

    public static String reverseString(String string) {
        return new StringBuilder(string).reverse().toString();
    }

    @SuppressWarnings("finally")
    public static String readFile(String fileName) {
        StringBuilder sb = new StringBuilder();

        try {
            FileReader fr = new FileReader(fileName);
            BufferedReader br = new BufferedReader(fr);

            String line = br.readLine();
            
            while (line != null) {
                sb.append(line);

                line = br.readLine();
            }

            fr.close();
        } catch (IOException e) {
            System.err.printf("Error opening file: %s.\n", e.getMessage());
        } finally {
            return sb.toString();
        }
    }
    
    public static void printIntArray(int[] arr) {
        StringBuilder sb = new StringBuilder();
        
        for(int i=0; i<arr.length; i++) {
            sb.append(arr[i] + " ");
        }
        
        System.out.println(sb.toString());
    }
    
    public static void printIntegerList(List<Integer> arr) {
        StringBuilder sb = new StringBuilder();
        
        for(int i=0; i<arr.size(); i++) {
            sb.append(arr.get(i));
            
            if(i<arr.size()-1) {
                 sb.append(" ");
            }
        }
        
        System.out.println(sb.toString());
    }
    
    public static void printStringList(List<String> arr) {
        StringBuilder sb = new StringBuilder();
        
        for(int i=0; i<arr.size(); i++) {
            sb.append(arr.get(i));
            
            if(i<arr.size()-1) {
                 sb.append(" ");
            }
        }
        
        System.out.println(sb.toString());
    }
    
}