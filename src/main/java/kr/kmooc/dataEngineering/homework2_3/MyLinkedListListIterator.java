package kr.kmooc.dataEngineering.homework2_3;

import java.util.ListIterator;

public class MyLinkedListListIterator<E> implements ListIterator<E> {

    private MyLinkedList<E> data;
    private int cursor;
    private MyNode<E> lastReturned;

    public MyLinkedListListIterator(MyLinkedList<E> data, int index) {
        this.data = data;
        this.cursor = index -1;
    }

    @Override
    public boolean hasNext() {
        if (cursor + 1 < data.size())
            return true;
        return false;
    }

    @Override
    public E next() {
        lastReturned = data.getNode(++cursor);
        return (E) lastReturned.getItem();
    }

    @Override
    public boolean hasPrevious() {
        return false;
    }

    @Override
    public E previous() {
        lastReturned = data.getNode(--cursor);
        return (E) lastReturned.getItem();
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
        lastReturned.setItem(e);
    }

    @Override
    public void add(E e) {

    }
}
