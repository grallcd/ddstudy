package com.ddstudy.collection;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.*;

/**
 * @Classname ArrayListTest
 * @Description TODO
 * @Date 2020/6/30
 * @Author Grain Rain
 */
public class ArrayListTest {

    public static int NUM = 10;

    public static List<Integer> list = new ArrayList<Integer>() {{
        for (int i = 0; i < NUM; i++) {
            add(i);
        }
    }};

    @Test
    void testGetByIndex() {
        Integer value;
        int size = list.size();
        long start = System.nanoTime();

        for (int j = 0; j < size; j++) {
            value = list.get(j);
        }

        long end = System.nanoTime();
        System.out.println("Get by index :" + (end - start));
    }

    @Test
    void testGetByForEach() {
        Integer value;
        long start = System.nanoTime();

        for (Integer i : list) {
            value = i;
        }

        long end = System.nanoTime();
        System.out.println("Get by for :" + (end - start));
    }

    @Test
    void testGetByIterator() {

        Iterator<Integer> iterator = list.iterator();
        Integer value;
        long start = System.nanoTime();

        while (iterator.hasNext()) {
            value = iterator.next();
        }

        long end = System.nanoTime();
        System.out.println("Get by iterator :" + (end - start));
    }

    @Test
    void testByForEach() {
        final Integer[] i = new Integer[1];
        long start = System.nanoTime();

        list.forEach(p -> i[0] = p);

        long end = System.nanoTime();
        System.out.println("Get by forEach :" + (end - start));
    }

    @Test
    void testSpliterator() {

        // 获取可分割迭代器
        Spliterator<Integer> spliterator = list.spliterator();

        // 计算迭代器的特征值
        /*int i = spliterator.characteristics();
        System.out.println(i);*/

        // 计算还剩下多少个元素需要遍历
        long size = spliterator.estimateSize();
        Assertions.assertEquals(10, size);

        //当迭代器拥有SIZED特征时，返回剩余元素个数；否则返回-1
        /*long known = spliterator.getExactSizeIfKnown();
        System.out.println(known);*/

        // 对每个剩余元素执行给定动作，依次处理
        spliterator.forEachRemaining(System.out::print);

        // 对单个元素执行给定动作，执行成功则返回true，否则返回false
        boolean b = spliterator.tryAdvance(System.out::println);
        System.out.println(b);
        // Assertions.assertFalse(b);

        // 计算还有多少个元素未处理
        long size2 = spliterator.estimateSize();
        Assertions.assertEquals(0, size2);

    }

    @Test
    void testSubList() {

        List<Integer> subList = list.subList(0, 5);

        subList.add(10);
        List<Integer> array = Arrays.asList(0, 1, 2, 3, 4, 10, 5, 6, 7, 8, 9);
        Assertions.assertEquals(new ArrayList<>(array), list);

        ArrayListTest.list.add(1);
        Assertions.assertThrows(ConcurrentModificationException.class, subList::size);
        Assertions.assertThrows(ConcurrentModificationException.class, () -> subList.add(1));

    }

    @Test
    void testToArray() {

        Object[] array = list.toArray();
        Assertions.assertEquals(Object[].class, array.getClass());

        Integer[] array1 = list.toArray(new Integer[0]);
        Assertions.assertEquals(Integer[].class, array1.getClass());

        Assertions.assertThrows(ArrayStoreException.class, ()->list.toArray(new String[0]));

    }

    @Test
    void testAddAll(){
        List<Integer> asList = Arrays.asList(null,null);

        boolean b = list.addAll(asList);
        Assertions.assertTrue(b);
        System.out.println(list);


        boolean b2 = list.addAll(1, asList);
        Assertions.assertTrue(b2);
        System.out.println(list);
    }

    @Test
    void testRemoveAll(){

        List<Integer> asList = Arrays.asList(1, 2,9,10);

        boolean b = list.removeAll(asList);

        System.out.println(list);


    }

    @Test
    void testRetainAll(){

        List<Integer> asList = Arrays.asList(1,2,3);

        boolean b = list.retainAll(asList);
        System.out.println(list);

    }
}
