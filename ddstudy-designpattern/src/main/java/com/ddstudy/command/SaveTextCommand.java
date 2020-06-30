package com.ddstudy.command;

/**
 * @Classname SaveTextCommand
 * @Description 保存文本命令
 * @Date 2020/6/30
 * @Author Grain Rain
 */
public class SaveTextCommand implements TextFileCommand{

    private final TextFile textFile;

    public SaveTextCommand(TextFile textFile) {
        this.textFile = textFile;
    }

    @Override
    public void execute() {
        textFile.save();
    }
}
