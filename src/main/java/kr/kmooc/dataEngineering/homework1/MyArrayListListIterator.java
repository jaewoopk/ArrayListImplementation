package kr.kmooc.dataEngineering.homework1;

import java.util.ListIterator;

public class MyArrayListListIterator<E> implements ListIterator<E> {

    private Object[] data;
    private int cursor;

    public MyArrayListListIterator(Object[] data, int index) {
        this.data = data;
        this.cursor = index - 1;
    }


    @Override
    public boolean hasNext() {
        if (cursor + 1 < data.length)
            return true;
        return false;
    }

    @Override
    public E next() {
        return (E) data[++cursor];
    }

    @Override
    public boolean hasPrevious() {
        if (cursor >= 0)
            return true;
        return false;
    }

    @Override
    public E previous() {
        return (E) data[cursor--];
    }

    @Override
    public int nextIndex() {
        return 0;
    }

    @Override
    public int previousIndex() {
        return 0;
    }

    @Override
    public void remove() {

    }

    @Override
    public void set(E e) {

    }

    @Override
    public void add(E e) {

    }
}
