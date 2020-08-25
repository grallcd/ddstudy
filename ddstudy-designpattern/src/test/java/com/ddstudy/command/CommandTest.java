package com.ddstudy.command;

import org.junit.jupiter.api.Test;

/**
 * @Classname CommandTest
 * @Description TODO
 * @Date 2020/6/30
 * @Author Grain Rain
 */
public class CommandTest {

    @Test
    void testCommand() {

        TextFileExecutor executor = new TextFileExecutor();
        Client client = new Client(executor);
        TextFile text = new TextFile();

        executor.setTextFileCommand(text::open);
        client.action();

        executor.setTextFileCommand(text::close);
        client.action();
    }

    @Test
    void testMacroCommand(){

        MacroCommandExecutor commandExecutor = new MacroCommandExecutor();
        TextFile textFile = new TextFile();

        commandExecutor.add(textFile::open);
        commandExecutor.add(textFile::save);
        commandExecutor.add(textFile::close);

        commandExecutor.execute();

        commandExecutor.clearCommands();
        commandExecutor.execute();
    }

}
