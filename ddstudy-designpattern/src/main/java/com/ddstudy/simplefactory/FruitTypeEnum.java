package com.ddstudy.simplefactory;

public enum FruitTypeEnum {

    APPLE {
        @Override
        public Fruit get() {
            return new Apple();
        }
    },

    BANANA {
        @Override
        public Fruit get() {
            return new Banana();
        }
    },

    LEMON {
        @Override
        public Fruit get() {
            return new Lemon();
        }
    };

    public abstract Fruit get();

}
