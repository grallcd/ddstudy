package com.ddstudy.command;

import java.util.ArrayList;
import java.util.List;

/**
 * @Classname MacroCommandExecutor
 * @Description 宏命令执行器
 * @Date 2020/6/30
 * @Author Grain Rain
 */
public class MacroCommandExecutor {

    private static final List<TextFileCommand> commands = new ArrayList<>(5);

    public void add(TextFileCommand textFileCommand) {
        checkSize();
        commands.add(textFileCommand);
    }

    private void checkSize() {
        if (MacroCommandExecutor.commands.size() >= 5) {
            throw new UnsupportedOperationException("You can't add command more than 5 ");
        }
    }

    public void clearCommands() {
        commands.clear();
    }

    public void execute(){
        commands.forEach(TextFileCommand::execute);
    }


}
