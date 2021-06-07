package ru.job4j.stream;

import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class Profiles {
    public List<Address> collect(List<Profile> profiles) {
        return profiles.stream()
                    .map(Profile::getAddress)
                    .sorted((ad1, ad2) -> ad1.getCity().compareTo(ad2.getCity()))
                    .distinct().collect(Collectors.toList());
    }
}
