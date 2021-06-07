package ru.job4j.stream;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import static org.junit.Assert.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
public class ProfilesTest {

    @Test
    public void getAddressTest() {
        Profiles profiles = new Profiles();

        Address address = new Address("NY", "LongAvenue", 15, 5);
        Address address2 = new Address("LA", "LongAvenue2", 20, 10);
        List<Profile> lstProFiles = new ArrayList<>();
        lstProFiles.add(new Profile(address));
        lstProFiles.add(new Profile(address2));

        List<Address> expected = new ArrayList<>();
        expected.add(new Address("LA", "LongAvenue2", 20, 10));
        expected.add(new Address("NY", "LongAvenue", 15, 5));

        List<Address> rslt = profiles.collect(lstProFiles);
        assertThat(expected, is(rslt));
    }

    @Test
    public void getDistinctAddressTest() {
        Profiles profiles = new Profiles();

        Address address = new Address("NY", "LongAvenue", 15, 5);
        Address address2 = new Address("NY", "LongAvenue", 15, 5);
        Address address3 = new Address("LA", "LongAvenue2", 20, 10);
        List<Profile> lstProFiles = new ArrayList<>();
        lstProFiles.add(new Profile(address));
        lstProFiles.add(new Profile(address2));
        lstProFiles.add(new Profile(address3));

        List<Address> expected = new ArrayList<>();
        expected.add(new Address("LA", "LongAvenue2", 20, 10));
        expected.add(new Address("NY", "LongAvenue", 15, 5));

        List<Address> rslt = profiles.collect(lstProFiles);
        assertThat(expected, is(rslt));
    }
}