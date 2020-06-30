package com.ddstudy.command;

import java.util.ArrayList;
import java.util.List;

/**
 * @Classname TextFileExecutor
 * @Description Invoker,负责调用命令对象执行请求，知道怎么执行，但不知道具体命令如何实现
 * 实际上就相当于是命令对象和使用者中间的抽象层
 * @Date 2020/6/30
 * @Author Grain Rain
 */
public class TextFileExecutor {

    private final List<TextFileCommand> commands = new ArrayList<>(5);

    /**
     * 执行单个命令
     * @param textFileCommand concreteCommand
     */
    public void executeCommand(TextFileCommand textFileCommand) {
        textFileCommand.execute();
    }

    public void remove(TextFileCommand textFileCommand){
        commands.remove(textFileCommand);
    }

    /**
     * 添加命令
     * @param textFileCommand concreteCommand
     */
    public void addCommand(TextFileCommand textFileCommand){
        commands.add(textFileCommand);
    }

    /**
     * 宏命令，可以一次执行多个命令
     */
    public void execute(){
        for (TextFileCommand command : commands) {
            command.execute();
        }
    }


}
