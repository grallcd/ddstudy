package com.ddstudy.iterator;

/**
 * @Classname Container
 * @Description TODO
 * @Date 2020/7/9
 * @Author Grain Rain
 */
public class Container<E> {

    private Object[] elements;

    public Container() {

    }

    public Container(E[] e) {
        this.elements = e;
    }

    public Iterator<E> iterator() {
        return new ObjectIterator();
    }


    private class ObjectIterator implements Iterator<E> {

        int index;

        @Override
        public boolean hasNext() {
            return index < elements.length;
        }

        @Override
        @SuppressWarnings("unchecked")
        public E next() {
            return hasNext() ? (E)elements[index++] : null;
        }
    }

}
