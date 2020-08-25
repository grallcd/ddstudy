package com.ddstudy.composite;


import java.util.List;

/**
 * @Classname Word
 * @Description TODO
 * @Date 2020/7/28
 * @Author Grain Rain
 */
public class Word extends LetterComposite {

    public Word(List<Letter> letters) {
        letters.forEach(this::add);
    }


    public Word(char... letters) {
        for (char letter : letters) {
            this.add(new Letter(letter));
        }
    }

    @Override
    protected void printBefore() {
        System.out.print(" ");
    }
}
