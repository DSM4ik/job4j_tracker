package ru.job4j.collection;

import java.util.HashMap;
import java.util.Map;

public class FreezeStr {
    public static boolean eq(String left, String right) {
        char[] arrLeft = left.toCharArray();
        char[] arrRight = right.toCharArray();
        Map<Character, Integer> mapLeft = new HashMap<>();
        Map<Character, Integer> mapRight = new HashMap<>();

        for (Character symb : arrLeft) {
            mapLeft.put(symb, countInput(left, symb));
        }

        for (Character symb : arrRight) {
            mapRight.put(symb, countInput(right, symb));
        }

        for (Character symbLeft : mapLeft.keySet()) {
                if ((!mapRight.containsKey(symbLeft))
                   || (mapLeft.get(symbLeft) != mapRight.get(symbLeft))) {
                    return false;
                }
        }

        return true;
    }

    private static int countInput(String value, Character symbol) {
        int count = 0;
        for (Character val : value.toCharArray()) {
            if (val.equals(symbol)) {
                count++;
            }
        }
        return count;
    }
}
