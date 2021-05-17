package ru.job4j.collection;

import java.util.HashSet;
import java.util.List;

/**
 * 3. Модели данных и HashSet. [#468361]
 *
 */
public class NotifyAccount {
    public static HashSet<Account> sent(List<Account> accounts) {
        HashSet<Account> rsl = new HashSet<>();
        for (Account acc : accounts) {
            rsl.add(acc);
        }
        return rsl;
    }
}
