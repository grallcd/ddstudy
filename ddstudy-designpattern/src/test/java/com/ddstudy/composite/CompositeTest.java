package com.ddstudy.composite;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

/**
 * @Classname CompositeTest
 * @Description TODO
 * @Date 2020/7/28
 * @Author Grain Rain
 */
public class CompositeTest {

    @Test
    void testComposite() {


        Word word1 = new Word('h', 'e', 'l', 'l', 'o');
        Word word2 = new Word('w', 'o', 'r', 'l', 'd');

        Sentence sentence = new Sentence(Arrays.asList(word1, word2));

        sentence.print();


    }
}
