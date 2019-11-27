package esi.atl.lambda;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;

public class ComparatorExample {

    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("Welcome");
        list.add("to the ");
        list.add("hellHole");
        
        Collections.sort(list, new Comparator<String>() {
            @Override
            public int compare(String word1, String word2) {
                return word1.length() - word2.length();
            }
        });
        System.out.println(list);
        
        Collections.sort(list, (String word1, String word2)->{return word1.length() - word2.length();});
        Collections.sort(list, (word1, word2)->{return word1.length() - word2.length();});
        Collections.sort(list, (word1, word2)->word1.length() - word2.length());
        
        list.forEach(elem -> System.out.println(elem));
        
        Predicate<String> p2 = new MyPredicate();
        Predicate<String> p3 = word -> word.length()==1;
    }        
}
