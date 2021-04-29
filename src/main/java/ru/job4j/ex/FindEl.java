package ru.job4j.ex;

/**
 *  метод indexOf - этот метод проверяет, что в списке есть ключ шаблона сообщения.
 *  Метод может выкинуть исключение ElementNotFoundException.
 *
 * Метод sent отправляет сообщение, если ключ  входит в ключи запрещенных ключей.
 * Метод может выкинуть исключение ElementAbuseException.
 */
public class FindEl {
    public static int indexOf(String[] value, String key) throws ElementNotFoundException {
        int rsl = -1;
        for (int i = 0; i < value.length; i++) {
            if (value[i].equals(key)) {
                rsl = i;
                break;
            }
        }
        if (rsl == -1) {
            throw new ElementNotFoundException("Not find element in array");
        }
        return rsl;
    }

    public static boolean sent(String value, String[] abuses) throws ElementAbuseException {
        for (int i = 0; i < abuses.length; i++) {
            if (abuses[i] == value) {
                throw new ElementAbuseException("Key is Illegal");
            }
        }
        return true;
    }

    public static void process(String[] values, String keys, String[] abuses, String value) {
        try {
            if (indexOf(values, keys) != -1) {
                sent(value, abuses);
            }
        } catch (ElementAbuseException e) {
            e.printStackTrace();
        } catch (ElementNotFoundException e) {
            e.printStackTrace();
        }
    }
}
