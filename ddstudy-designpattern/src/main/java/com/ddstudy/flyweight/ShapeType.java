package com.ddstudy.flyweight;

/**
 * @Classname ShapeType
 * @Description TODO
 * @Date 2020/7/7
 * @Author Grain Rain
 */
public enum ShapeType {

    LINE {
        @Override
        public Shape get() {
            return new Line();
        }
    }, CIRCLE {
        @Override
        public Shape get() {
            return new Circle();
        }
    }, RECTANGLE {
        @Override
        public Shape get() {
            return new Rectangle();
        }
    };

    public abstract Shape get();
}
