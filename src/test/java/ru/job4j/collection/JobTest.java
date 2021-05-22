package ru.job4j.collection;

import org.junit.Test;

import java.util.Comparator;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.greaterThan;
import static org.hamcrest.Matchers.lessThan;

public class JobTest {

    @Test
    public void whenCompatorByNameAsc() {
        Comparator<Job> ascByName = new JobAscByName();
        int rsl = ascByName.compare(new Job("Impl task", 0),
                                    new Job("Fix bug", 1)
        );
        assertThat(rsl, greaterThan(0));
    }

    @Test
    public void whenCompatorByPriorirtyAsc() {
        Comparator<Job> ascByName = new JobAscByPriority();
        int rsl = ascByName.compare(new Job("Impl task", 0),
                new Job("Fix bug", 1)
        );
        assertThat(rsl, lessThan(0));
    }

    @Test
    public void whenCompatorByNamePriorirtyAsc() {
        Comparator<Job> ascByNamePriority = new JobAscByName().thenComparing(
                                                                new JobAscByPriority()
        );
        int rsl = ascByNamePriority.compare(new Job("A", 0),
                                            new Job("C", 1)
        );
        assertThat(rsl, lessThan(0));
    }

    @Test
    public void whenCompatorByNameAndPrority() {
        Comparator<Job> cmpNamePriority = new JobDescByName().thenComparing(
                                                              new JobDescByPriority()
                                                               );
        int rsl = cmpNamePriority.compare(
                new Job("Impl task", 0),
                new Job("Fix bug", 1)
        );
        assertThat(rsl, lessThan(0));
    }
}