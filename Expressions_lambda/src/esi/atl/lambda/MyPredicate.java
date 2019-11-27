package esi.atl.lambda;

import java.util.function.Predicate;

/**
 *
 * @author leopoldmols
 */
public class MyPredicate implements Predicate<String> {
    String s;

    public MyPredicate() {
    }

    @Override
    public boolean test(String t) {
        return t.length() < 5;
    }
    
    public static void main(String[] args) {
        Predicate<String> s = new MyPredicate();
        System.out.println(s.test("01"));
        Predicate<String> s2 = (word)->word.length() < 5;
        boolean a = s2.test("01234567");
        System.out.println(a);
    }
}
