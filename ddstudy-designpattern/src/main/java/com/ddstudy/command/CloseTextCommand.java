package com.ddstudy.command;

/**
 * @Classname CloseTextCommand
 * @Description 关闭文本命令
 * @Date 2020/6/30
 * @Author Grain Rain
 */
public class CloseTextCommand implements TextFileCommand {

    private final TextFile textFile;

    public CloseTextCommand(TextFile textFile) {
        this.textFile = textFile;
    }

    @Override
    public void execute() {
        textFile.close();
    }
}
