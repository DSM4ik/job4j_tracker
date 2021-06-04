package ru.job4j.function;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class FunctionDiapazonTest {

    @Test
    public void whenLinearFunctionThenLinearResults() {
        List<Double> result = FunctionDiapazon.diapason(5, 8, x -> 2 * x + 1);
        List<Double> expected = Arrays.asList(11D, 13D, 15D);
        assertThat(result, is(expected));
    }

    @Test
    public void whenSquadFunctionThenSquadResults() {
        List<Double> result = FunctionDiapazon.diapason(1, 3, x -> 2 * Math.pow(x, 2) + 1);
        List<Double> expected = Arrays.asList(3D, 9D);
        assertThat(result, is(expected));
    }

    @Test
    public void whenRateFunctionThenRateResults() {
        List<Double> result = FunctionDiapazon.diapason(2, 5, x -> 2 * Math.pow(2, x) + 1);
        List<Double> expected = Arrays.asList(9D, 17D, 33D);
        assertThat(result, is(expected));
    }

}