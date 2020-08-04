package com.ddstudy.composite;

import java.util.ArrayList;
import java.util.List;

/**
 * @Classname LetterComposite
 * @Description TODO
 * @Date 2020/7/28
 * @Author Grain Rain
 */
public abstract class LetterComposite {

    private List<LetterComposite> composites = new ArrayList<>();


    public void add(LetterComposite letter) {
        composites.add(letter);
    }

    public int count() {
        return composites.size();
    }


    protected void printBefore() {
    }

    protected void printAfter() {
    }

    public final void print() {

        printBefore();
        composites.forEach(LetterComposite::print);
        printAfter();

    }

}
