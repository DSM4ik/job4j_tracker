package ru.job4j.stream;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class StudentConvertTest {

    @Test
    public void convert() {
        List<Student> studentList = new ArrayList<>();
        studentList.add(new Student(50, "Gregory"));
        studentList.add(new Student(40, "Gregory"));
        studentList.add(new Student(80, "Vyacheslav"));

        Map<String, Student> rslt = StudentConvert.convert(studentList);

        Map<String, Student> expected = new HashMap<>();
        expected.put("Gregory", new Student(50, "Gregory"));
        expected.put("Vyacheslav", new Student(80, "Vyacheslav"));

        assertThat(expected, is(rslt));

    }
}