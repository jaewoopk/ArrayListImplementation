package kr.kmooc.dataEngineering.homework4_5;

import java.lang.reflect.Array;
import java.util.*;

public class MyHashSet<E> implements Set<E>{

    private LinkedList<E>[] hashTable;
    private int size;
    private int capacity;

    public MyHashSet() {
        capacity = 4096;
        size = 0;
        hashTable = new LinkedList[capacity];
        for (int i = 0; i < capacity; i++) {
            hashTable[i] = new LinkedList<E>();
        }
    }

    public MyHashSet(int capacity) {
        this.capacity = capacity;
        size = 0;
        hashTable = new LinkedList[capacity];
        for (int i = 0; i < capacity; i++) {
            hashTable[i] = new LinkedList<E>();
        }
    }

    public MyHashSet(Collection<? extends E> c) {
        this();
        for (E val : c) {
            this.add(val);
        }
    }
    @Override
    public int size() {
        // TODO Auto-generated method stub
        return this.size;
    }
    @Override
    public boolean isEmpty() {
        // TODO Auto-generated method stub
        return this.size == 0;
    }
    @Override
    public boolean contains(Object o) {
        // TODO Auto-generated method stub
        int idx = o.hashCode() % capacity;
        LinkedList<E> list = hashTable[idx];
        return list.contains(o);
    }
    @Override
    public Iterator<E> iterator() {
        // TODO Auto-generated method stub
        return new MyHashSetIterator<E>(hashTable);
    }
    @Override
    public Object[] toArray() {
        // TODO Auto-generated method stub
        return null;
    }
    @Override
    public <T> T[] toArray(T[] a) {
        // TODO Auto-generated method stub
        if (a.length < size) {
            a = (T[]) Array.newInstance(a.getClass().componentType(), size);
        }

        int idx = 0;
        for (Object val : this) {
            a[idx++] = (T) val;
        }
        return a;
    }
    @Override
    public boolean add(E e) {
        // TODO Auto-generated method stub
        int idx = e.hashCode() % capacity;
        LinkedList<E> list = hashTable[idx];

        if (!list.contains(e)) {
            list.add(e);
            size++;
            return true;
        }
        return false;
    }
    @Override
    public boolean remove(Object o) {
        // TODO Auto-generated method stub
        int idx = o.hashCode() % capacity;
        LinkedList<E> list = hashTable[idx];
        boolean isRemoved = list.remove(o);
        if (isRemoved) size--;
        return isRemoved;
    }
    @Override
    public boolean containsAll(Collection<?> c) {
        // TODO Auto-generated method stub
        return false;
    }
    @Override
    public boolean addAll(Collection<? extends E> c) {
        // TODO Auto-generated method stub
        return false;
    }
    @Override
    public boolean retainAll(Collection<?> c) {
        // TODO Auto-generated method stub
        return false;
    }
    @Override
    public boolean removeAll(Collection<?> c) {
        // TODO Auto-generated method stub
        return false;
    }
    @Override
    public void clear() {
        // TODO Auto-generated method stub
        hashTable = new LinkedList[capacity];
        size = 0;
    }
}
