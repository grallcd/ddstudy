package com.ddstudy.facade;

import org.junit.jupiter.api.Test;

/**
 * @Classname FacadeTest
 * @Description TODO
 * @Date 2020/6/19
 * @Author Grain Rain
 */
public class FacadeTest {

    @Test
    public void testFacade() {

        ComputerFacade computer = new ComputerFacade();

        computer.startUp();
        computer.shutdown();

        CPU cpu = new CPU();
        Memory memory = new Memory();
        Disk disk = new Disk();

        cpu.start();
        memory.start();
        disk.start();

    }
}
