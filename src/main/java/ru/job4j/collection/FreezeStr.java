package ru.job4j.collection;

import java.util.HashMap;
import java.util.Map;

public class FreezeStr {
    public static boolean eq(String left, String right) {
        char[] arrLeft = left.toCharArray();
        char[] arrRight = right.toCharArray();
        Map<Character, Integer> mapLeft = new HashMap<>();

        for (Character symb : arrLeft) {
            mapLeft.put(symb, countInput(left, symb));
        }

        for (char rihgtChar : arrRight) {
            if (!mapLeft.containsKey(rihgtChar)) {
                return false;
            }

            if (mapLeft.containsKey(rihgtChar) && mapLeft.get(rihgtChar) == 1) {
                mapLeft.remove(rihgtChar);
            } else {
                mapLeft.put(rihgtChar, mapLeft.get(rihgtChar) - 1);
            }

        }

        return mapLeft.isEmpty();
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
