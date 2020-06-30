package com.ddstudy.command;

/**
 * @Classname TextFile
 * @Description 命令接收者，负责具体执行某一个命令
 * @Date 2020/6/30
 * @Author Grain Rain
 */
public class TextFile {

    public void open(){
        System.out.println("Open the text file ");
    }

    public void save(){
        System.out.println("Save the text file ");
    }

    public void addChar(){
        System.out.println("Add a char ");
    }

    public void removeChar(){
        System.out.println("Remove a char ");
    }

    public void close(){
        System.out.println("Close the text file ");
    }
}
