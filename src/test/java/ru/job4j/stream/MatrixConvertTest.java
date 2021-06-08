package ru.job4j.stream;

import org.junit.Test;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class MatrixConvertTest {
    @Test
    public void convertMatrixToList() {
        Integer[][] elements = {
                                {1, 2, 3},
                                {8, 8, 0},
                                {9, 5, 12}
        };

        List<Integer> expected = List.of(1, 2, 3, 8, 8, 0, 9, 5, 12);
        List<Integer> rslt = MatrixConvert.convert(elements);
        assertThat(expected, is(rslt));
    }
}