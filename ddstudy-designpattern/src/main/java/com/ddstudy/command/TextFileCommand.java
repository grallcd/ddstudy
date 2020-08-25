package com.ddstudy.command;

/**
 * @Classname TextFileCommand
 * @Description 命令角色：声明一个所有命令的抽象接口
 * @Date 2020/6/30
 * @Author Grain Rain
 */
@FunctionalInterface
public interface TextFileCommand {

    /**
     * 给接收者调用的命令
     */
    void execute();
}
