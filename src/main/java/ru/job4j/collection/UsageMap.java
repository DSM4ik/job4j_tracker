package ru.job4j.collection;

import java.util.HashMap;

public class UsageMap {
    public static void main(String[] args) {
        HashMap<String, String> map = new HashMap<>();
        map.put("123@gmail.com", "Ivanov");
        map.put("456@gmail.com", "Sidorova");
        for (String key: map.keySet()) {
            System.out.println(key + "=" + map.get(key));
        }
    }
}
