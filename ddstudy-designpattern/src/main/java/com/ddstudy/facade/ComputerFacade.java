package com.ddstudy.facade;

/**
 * @Classname Robot
 * @Description 外观模式：一台电脑由CPU、Disk、Memory组成，
 * 用户可以不用管底层系统怎么开机，只要控制ComputerFacade类
 * 即可控制电脑的开机和关机。
 * @Date 2020/6/19
 * @Author Grain Rain
 */
public class ComputerFacade {

    Disk disk;
    CPU cpu;
    Memory memory;

    public ComputerFacade() {
        this.disk = new Disk();
        this.cpu = new CPU();
        this.memory = new Memory();
    }

    public void startUp() {
        System.out.println("Computer is starting");

        cpu.start();
        memory.start();
        disk.start();

        System.out.println("Welcome to the computer!");
    }

    public void shutdown() {
        System.out.println("Computer is shutdown");

        cpu.shutdown();
        memory.shutdown();
        disk.shutdown();

        System.out.println("Over!");
    }
}
