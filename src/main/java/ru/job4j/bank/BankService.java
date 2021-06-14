package ru.job4j.bank;

import java.util.*;

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
        Optional<User> userFind = findByPassport(passport);
        if (userFind.isPresent() && !users.get(userFind.get()).contains(account)) {
            users.get(userFind.get()).add(account);
        }
    }

    /**
     * Метод принимает на вход пасспорт
     * По пасспорту ищем польз-ля и возвращаем его
     * @param passport пасспорт
     * @return User - пользователь
     */
    public Optional<User> findByPassport(String passport) {
        return users.keySet()
                .stream()
                .filter(u -> u.getPassport().equals(passport))
                .findFirst();
    }

    /**
     * Метод принимает на вход польз-ля и реквизит
     * Сначала ищем польз-ля по пасспорту.
     * Затем по коллекции аккаунта польз-ля ищем аккаунт
     * @param passport - пасспорт
     * @param requisite - реквизит
     * @return - возвращает Accaunt польз-ля
     */
    public Optional<Account> findByRequisite(String passport, String requisite) {
        Optional<User> userFind = findByPassport(passport);
        if (userFind.isPresent()) {
            return users.get(userFind.get())
                     .stream()
                     .filter(s -> s.getRequisite().equals(requisite))
                     .findFirst();
        }
        return  null;
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
        Optional<Account> accSrc = findByRequisite(srcPassport, srcRequisite);
        Optional<Account> accDest = findByRequisite(destPassport, destRequisite);

        if (accSrc.isPresent() && accDest.isPresent() && accSrc.get().getBalance() >= amount) {
            accSrc.get().setBalance(accSrc.get().getBalance() - amount);
            accDest.get().setBalance(accDest.get().getBalance() + amount);
            rsl = true;
        }
        return rsl;
    }
}
