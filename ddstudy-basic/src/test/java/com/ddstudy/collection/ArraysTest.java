package com.ddstudy.collection;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

/**
 * @Classname ArraysTest
 * @Description TODO
 * @Date 2020/7/6
 * @Author Grain Rain
 */
public class ArraysTest {

    @Test
    void testAsList() {

        List<String> strs = Arrays.asList("a", "b", "c");

        System.out.println(strs.getClass());

        System.out.println(strs.toArray().getClass());

    }

    @Test
    public void testSystemArrayCopy() {

        int[] num = new int[]{1, 2, 3, 4, 5};
        int[] newNum = new int[]{0, 0, 0, 0, 0};

        System.arraycopy(num, 1, newNum, 1, 3);

        Assertions.assertArrayEquals(new int[]{0, 2, 3, 4, 0}, newNum);

        System.out.println(Arrays.toString(newNum));

    }

    @Test
    public void testArraysCopyOf() {
        Integer[] num = new Integer[]{1, 2, 3, 4, 5};

        Object[] objs = Arrays.copyOf(num, 4, Object[].class);
        Integer[] ints = Arrays.copyOf(num, 3, Integer[].class);

        Assertions.assertEquals(Object[].class, objs.getClass());
        Assertions.assertEquals(Integer[].class, ints.getClass());

        System.out.println(Arrays.toString(objs));
        System.out.println(Arrays.toString(ints));
    }

    @Test
    void testToArray() {
        List<Integer> ints = Arrays.asList(1, 2, 3);
        Object[] objs = ints.toArray();
        Assertions.assertEquals(Integer[].class, objs.getClass());

        List<Object> list = Arrays.asList(1, 2, 3);
        Object[] objs2 = list.toArray();
        Assertions.assertEquals(Object[].class, objs2.getClass());

        Object[] objs3 = ints.toArray(new Object[0]);
        Assertions.assertEquals(Object[].class, objs3.getClass());

        Object[] objects = Arrays.asList(1, 2, 3).toArray(new Object[0]);

    }
}
