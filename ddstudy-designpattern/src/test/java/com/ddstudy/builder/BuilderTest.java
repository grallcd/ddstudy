package com.ddstudy.builder;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * @Classname BuilderTest
 * @Description TODO
 * @Date 2020/6/28
 * @Author Grain Rain
 */
public class BuilderTest {

    @Test
    void testBuilder() {
        Person java = new Person
                .Builder("Java", Gender.MALE)
                .withDescription("Java is the best language")
                .build();

        Person python = new Person.Builder("Python", Gender.FEMALE).build();

        Assertions.assertThrows(IllegalArgumentException.class, () -> new Person.Builder(null, Gender.MALE).build());
        Assertions.assertThrows(IllegalArgumentException.class, () -> new Person.Builder("PHP", null).build());

        Assertions.assertEquals(Gender.MALE, java.getGender());
        Assertions.assertEquals("Python", python.getName());


    }
}
