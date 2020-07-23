package com.ddstudy.collection;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.Spliterator;

/**
 * @Classname HashSetTest
 * @Description TODO
 * @Date 2020/7/20
 * @Author Grain Rain
 */
public class HashSetTest {

    public static Set<String> set = new HashSet<String>() {{
        add("a");
        add("b");
        add("c");
    }};

    @Test
    void testAdd() {
        boolean a = set.add(null);
        boolean b = set.add(null);

        Assertions.assertTrue(a);
        Assertions.assertFalse(b);
    }

    @Test
    void testRemove() {
        boolean a = set.add(null);
        boolean b = set.remove(null);
        boolean c = set.remove(null);

        Assertions.assertTrue(a);
        Assertions.assertTrue(b);
        Assertions.assertFalse(c);
    }

    @Test
    void testIterator() {
        Iterator<String> iterator = set.iterator();

        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }

    }

    @Test
    void testSpliterator(){
        Spliterator<String> spliterator = set.spliterator();

        spliterator.tryAdvance(System.out::println);

        spliterator.forEachRemaining(System.out::println);
    }
}
