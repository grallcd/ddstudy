package com.ddstudy.command;

/**
 * @Classname Client
 * @Description 客户端
 * @Date 2020/7/1
 * @Author Grain Rain
 */
public class Client {

    private TextFileExecutor textFileExecutor;

    public Client(TextFileExecutor textFileExecutor) {
        this.textFileExecutor = textFileExecutor;
    }

    public void action(){
        textFileExecutor.executeCommand();
    }
}
