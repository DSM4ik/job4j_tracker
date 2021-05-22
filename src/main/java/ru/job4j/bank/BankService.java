package ru.job4j.bank;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * В этом задании вам нужно разработать модель для банковской системы.
 *
 * В системе можно производить следующие действия.
 *
 * 1. Регистрировать пользователя. (addUser)
 * 2. Удалять пользователя из системы.
 * 3. Добавлять пользователю банковский счет. У пользователя системы могут быть несколько счетов.
 * 4. Переводить деньги с одного банковского счета на другой счет.
 */

public class BankService {
    private Map<User, List<Account>> users = new HashMap<>();

    public void addUser(User user) {
        users.putIfAbsent(user, new ArrayList<Account>());
    }

    public void addAccount(String passport, Account account) {
        User userFind = findByPassport(passport);
        if (userFind != null && !users.get(userFind).contains(account)) {
            users.get(userFind).add(account);
        }
    }

    public User findByPassport(String passport) {
        User findUser = null;
        for (User u : users.keySet()) {
            if (u.getPassport().equals(passport)) {
                findUser = u;
                break;
            }
        }
        return findUser;
    }

    public Account findByRequisite(String passport, String requisite) {
        Account findAccount = null;
        User userFind = findByPassport(passport);
        if (userFind != null) {
           List<Account> acc = users.get(userFind);
           for (Account a : acc) {
               if (a.getRequisite().equals(requisite)) {
                   findAccount = a;
                   break;
               }
           }
        }
        return  findAccount;
    }

    public boolean transferMoney(String srcPassport, String srcRequisite,
                                 String destPassport, String destRequisite, double amount) {
        boolean rsl = false;
        Account accSrc = findByRequisite(srcPassport, srcRequisite);
        Account accDest = findByRequisite(destPassport, destRequisite);

        if (accSrc != null && accDest != null && accSrc.getBalance() >= amount) {
            accSrc.setBalance(accSrc.getBalance() - amount);
            accDest.setBalance(accDest.getBalance() + amount);
            rsl = true;
        }
        return rsl;
    }
}
