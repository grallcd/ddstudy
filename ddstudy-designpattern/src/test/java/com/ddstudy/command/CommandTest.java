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

        Client client = new Client(new TextFileExecutor());

        TextFile text = new TextFile();

        client.execute(text::open);
        client.execute(text::save);
        client.execute(text::close);

    }

    @Test
    void testMacroCommand(){

        MacroCommandExecutor commandExecutor = new MacroCommandExecutor();
        TextFile textFile = new TextFile();

        commandExecutor.add(textFile::open);
        commandExecutor.add(textFile::addChar);
        commandExecutor.add(textFile::addChar);
        commandExecutor.add(textFile::save);
        commandExecutor.add(textFile::close);

        commandExecutor.execute();

        commandExecutor.clearCommands();
        commandExecutor.execute();
    }

}
