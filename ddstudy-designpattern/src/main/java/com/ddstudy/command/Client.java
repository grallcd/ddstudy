package com.ddstudy.command;

/**
 * @Classname Client
 * @Description 客户端角色
 * @Date 2020/6/30
 * @Author Grain Rain
 */
public class Client {

    private final TextFileExecutor textFileExecutor;

    public Client(TextFileExecutor textFileExecutor) {
        this.textFileExecutor = textFileExecutor;
    }

    public void execute(TextFileCommand textFileCommand) {
        textFileExecutor.executeCommand(textFileCommand);
    }


}
