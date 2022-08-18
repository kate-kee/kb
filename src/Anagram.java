
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Anagram {
    public static void Ana(){
    String[] words = {"bats","tabs","in","cat","act"};
    String[] sentences = {"cat the bats", "in the act", "act tabs in"};
    int[] count = new int[sentences.length];

    HashMap<String, List<String>> map = new HashMap<>();
    HashMap<String, List<String>> mapToUse = new HashMap<>();
    for (String word : words) {
        char[] charArr = word.toCharArray();
        Arrays.sort(charArr);
        String sorted = new String(charArr);

        if (map.get(sorted) != null) {
            List<String> list = map.get(sorted);
            list.add(word);
            map.put(sorted, list);
            mapToUse.put(word, list);
        } else {
            List<String> list = new ArrayList<String>();
            list.add(word);
            map.put(sorted, list);
            mapToUse.put(word, list);
        }

    }
    int index = 0;
    for (String sentence : sentences) {
        int c = 1;
        String[] strArr = sentence.trim().split(" ");
        for (String str : strArr) {
            if (mapToUse.get(str) != null) {
                List<String> list = mapToUse.get(str);
                c = c * list.size();
            }
        }
        count[index++] = c;
    }

    for (int i = 0; i < count.length; i++) {
        System.out.println(count[i] + " ");
    }
    }

    public static final void main(String args[]) {
        Ana();
        
    }

}