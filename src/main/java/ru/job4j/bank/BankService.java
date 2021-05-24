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
 * @author Den Mitskevich
 * @version 1.0
 */

public class BankService {
    /**
     * Хранение задания осуществляется в коллекции типа HashMap
     */
    private Map<User, List<Account>> users = new HashMap<>();

    /**
     * Метод принимает на вход пользователя и добавляет его в коллекцию     *
     * @param user - пользователь
     */
    public void addUser(User user) {
        users.putIfAbsent(user, new ArrayList<Account>());
    }

    /**
     * Метод принимает на вход пасспорт и аккаунт польз-ля
     * По пасспорту мы ищем пользователя:
     * если пользователь найден и не содержит такого аккаунта,
     * то идет добавление аккаунта к найденному пользователю
     * @param passport - пасспорт
     * @param account - Аккаунт (реквизит и баланс)
     */
    public void addAccount(String passport, Account account) {
        User userFind = findByPassport(passport);
        if (userFind != null && !users.get(userFind).contains(account)) {
            users.get(userFind).add(account);
        }
    }

    /**
     * Метод принимает на вход пасспорт
     * По пасспорту ищем польз-ля и возвращаем его
     * @param passport пасспорт
     * @return User - пользователь
     */
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

    /**
     * Метод принимает на вход польз-ля и реквизит
     * Сначала ищем польз-ля по пасспорту.
     * Затем по коллекции аккаунта польз-ля ищем аккаунт
     * @param passport - пасспорт
     * @param requisite - реквизит
     * @return - возвращает Accaunt польз-ля
     */
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

    /**
     * Метод осуществляет перевод ден. средств между 2-мя польз-ми
     * Сначала ищем аккаунты для обмена
     * При успешном нахождении аакаунтов и
     * балансе счета отправителя >= суммы перевода
     * осуществляем перевод
     *
     * @param srcPassport - пасспорт от кого идет перевод
     * @param srcRequisite - аккаунт с которого осущ-ся перевод
     * @param destPassport - пасспорт кому идет перевод
     * @param destRequisite - аккаунт на который осущ-ся перевод
     * @param amount - сумма перевода
     * @return - если перевод успешен возвращает True
     */
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
