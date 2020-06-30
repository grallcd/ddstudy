package com.ddstudy.command;

/**
 * @Classname TextFileExecutor
 * @Description Invoker, 负责调用命令对象执行请求，知道怎么执行，但不知道具体命令如何实现
 * 实际上就相当于是命令对象和使用者中间的抽象层
 * @Date 2020/6/30
 * @Author Grain Rain
 */
public class TextFileExecutor {

    private TextFileCommand textFileCommand;

    public void setTextFileCommand(TextFileCommand textFileCommand) {
        this.textFileCommand = textFileCommand;
    }

    /**
     * 执行单个命令
     */
    public void executeCommand() {
        textFileCommand.execute();
    }


}
