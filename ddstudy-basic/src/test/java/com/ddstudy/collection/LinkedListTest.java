package com.ddstudy.collection;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.LinkedList;
import java.util.List;
import java.util.Spliterator;

/**
 * @Classname LinkedListTest
 * @Description TODO
 * @Date 2020/7/8
 * @Author Grain Rain
 */
public class LinkedListTest {


    public static int NUM = 10;

    public static List<Integer> list = new LinkedList<Integer>() {{
        for (int i = 0; i < NUM; i++) {
            add(i);
        }
    }};

    @Test
    void testSpliterator() {
        Spliterator<Integer> spliterator = list.spliterator();


        boolean b = spliterator.tryAdvance(System.out::println);
        Assertions.assertTrue(b);

        long value = spliterator.estimateSize();
        Assertions.assertEquals(9,value);

        spliterator.forEachRemaining(System.out::println);

    }

    @Test
    void testTrySplit(){

        Spliterator<Integer> spliterator = list.spliterator();

        long estimateSize = spliterator.estimateSize();
        Assertions.assertEquals(10,estimateSize);

        Spliterator<Integer> spliterator2 = spliterator.trySplit();
        Spliterator<Integer> spliterator3 = spliterator.trySplit();

        System.out.println(spliterator2.estimateSize());
        System.out.println(spliterator3.estimateSize());


    }
}
