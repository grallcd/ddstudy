package com.ddstudy.composite;

import java.util.List;

/**
 * @Classname Sentence
 * @Description TODO
 * @Date 2020/7/28
 * @Author Grain Rain
 */
public class Sentence extends LetterComposite {


    public Sentence(List<Word> words) {
        words.forEach(this::add);

    }

    @Override
    protected void printAfter() {
        System.out.println(".");
    }



}
