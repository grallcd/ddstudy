package com.ddstudy.flyweight;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * @Classname FlyweightTest
 * @Description TODO
 * @Date 2020/7/13
 * @Author Grain Rain
 */
public class FlyweightTest {

    @Test
    void testFlyweight(){

        ShapeFactory shapeFactory = new ShapeFactory();

        Shape circle = shapeFactory.getShape(ShapeType.CIRCLE);
        Shape line = shapeFactory.getShape(ShapeType.LINE);
        Shape rectangle = shapeFactory.getShape(ShapeType.RECTANGLE);

        circle.draw();
        line.draw();
        rectangle.draw();

        Shape circle2 = shapeFactory.getShape(ShapeType.CIRCLE);
        Assertions.assertSame(circle, circle2);

    }
}
