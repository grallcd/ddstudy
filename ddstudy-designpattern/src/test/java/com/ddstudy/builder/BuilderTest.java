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
                .Builder("Java", GenderEnum.MALE)
                .withDescription("Java is the best language")
                .build();

        Person python = new Person.Builder("Python", GenderEnum.FEMALE).build();

        Assertions.assertThrows(IllegalArgumentException.class, () -> new Person.Builder(null, GenderEnum.MALE).build());
        Assertions.assertThrows(IllegalArgumentException.class, () -> new Person.Builder("PHP", null).build());

        Assertions.assertEquals(GenderEnum.MALE, java.getGender());
        Assertions.assertEquals("Python", python.getName());


    }
}
