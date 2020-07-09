package com.ddstudy.iterator;

import org.junit.jupiter.api.Test;

/**
 * @Classname IteratorTest
 * @Description TODO
 * @Date 2020/7/9
 * @Author Grain Rain
 */
public class IteratorTest {

    @Test
    void testIterator() {

        Item[] items = new Item[]{
                new Item("Java"),
                new Item("Python"),
                new Item("C#")
        };

        Container<Item> itemContainer = new Container<>(items);

        Iterator<Item> iterator = itemContainer.iterator();

        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }

}
