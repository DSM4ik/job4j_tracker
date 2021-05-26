package ru.job4j.collection;

import java.util.*;

public class Departments {
    public static List<String> fillGaps(List<String> deps) {
        List<String> rsl = new ArrayList<>();
        Set<String> depsVal = new LinkedHashSet<>();
        for (String val : deps) {
            String arrDeps[] = val.split("/");
            for(String dep : arrDeps) {
                depsVal.add(dep);
            }
        }
        String addResult = "";
        for(String dep: depsVal) {
            addResult += dep;
            rsl.add(addResult);
            addResult += "/";
        }
        return rsl;
    }

    public static void sortAsc(List<String> orgs) {
        Collections.sort(orgs);
    }

    public static void sortDesc(List<String> orgs) {
        Collections.sort(orgs, new DepDescComp());
    }

}
