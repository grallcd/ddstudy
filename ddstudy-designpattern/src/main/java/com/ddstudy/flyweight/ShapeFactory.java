package com.ddstudy.flyweight;

import java.util.EnumMap;
import java.util.Map;

/**
 * @Classname ShapeFactory
 * @Description TODO
 * @Date 2020/7/7
 * @Author Grain Rain
 */
public class ShapeFactory {

    private final Map<ShapeType, Shape> shapeMap;

    public ShapeFactory() {
        shapeMap = new EnumMap<>(ShapeType.class);
    }

    public Shape getShape(ShapeType type) {
        Shape shape = shapeMap.get(type);
        if (shape == null) {
            shape = type.get();
            shapeMap.put(type, shape);
        }
        return shape;

    }

}
