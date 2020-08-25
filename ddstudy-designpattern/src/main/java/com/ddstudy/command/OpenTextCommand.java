package com.ddstudy.command;

/**
 * @Classname OpenCommand
 * @Description 打开文本命令
 * @Date 2020/6/30
 * @Author Grain Rain
 */
public class OpenTextCommand implements TextFileCommand {

    private final TextFile textFile;

    public OpenTextCommand(TextFile textFile) {
        this.textFile = textFile;
    }

    @Override
    public void execute() {
        textFile.open();
    }
}
