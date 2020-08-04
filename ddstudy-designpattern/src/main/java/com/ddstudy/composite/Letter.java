package com.ddstudy.composite;

/**
 * @Classname Letter
 * @Description TODO
 * @Date 2020/7/28
 * @Author Grain Rain
 */
public class Letter extends LetterComposite{

    private char character;

    public Letter(char character) {
        this.character = character;
    }

    @Override
    protected void printBefore() {
        System.out.print(character);
    }

}
