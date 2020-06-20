package com.ddstudy.state;

import org.junit.jupiter.api.Test;

/**
 * @Classname StateTest
 * @Description TODO
 * @Date 2020/6/20
 * @Author Grain Rain
 */
public class StateTest {

    @Test
    void testState() {
        Door door = new Door();

        door.on();
        door.on();

        door.close();
        door.close();

    }


}
