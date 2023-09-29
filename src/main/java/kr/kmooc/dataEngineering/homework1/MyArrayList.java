package kr.kmooc.dataEngineering.homework1;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class MyArrayList<E> implements List<E> {

    private Object[] data;

    public MyArrayList() {
        data = new Object[0];
    }
    @Override
    public int size() {
        return data.length;
    }

    @Override
    public boolean isEmpty() {
        if (data == null || data.length == 0)
            return false;
        return true;
    }

    @Override
    public boolean contains(Object o) {
        for (int i = 0; i < data.length; i++) {
            if (data[i].equals(o)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public Iterator iterator() {
        return new MyArrayListListIterator<E>(data, 0);
    }

    @Override
    public Object[] toArray() {
        return data;
    }

    @Override
    public Object[] toArray(Object[] a) {
        return null;
    }

    @Override
    public boolean add(Object e) {
        Object[] newData = new Object[data.length + 1];

        for (int i = 0; i < data.length; i++) {
            newData[i] = data[i];
        }
        newData[data.length] = e;
        data = newData;
        return true;
    }

    @Override
    public boolean remove(Object o) {
        int ri = indexOf(o);
        if (ri == -1)
            return false;

        Object[] newData = new Object[data.length - 1];

        for (int i = 0; i < ri; i++) {
            newData[i] = data[i];
        }
        for (int i = ri + 1; i < data.length; i++) {
            newData[i - 1] = data[i];
        }
        data = newData;
        return true;
    }

    @Override
    public boolean containsAll(Collection c) {
        return false;
    }

    @Override
    public boolean addAll(Collection c) {
        return false;
    }

    @Override
    public boolean addAll(int index, Collection c) {
        return false;
    }

    @Override
    public boolean removeAll(Collection c) {
        return false;
    }

    @Override
    public boolean retainAll(Collection c) {
        return false;
    }

    @Override
    public void clear() {
        data = new Object[0];
    }

    @Override
    public E get(int index) {
        if (index >= data.length || index < 0) {
            throw new IndexOutOfBoundsException();
        }
        return (E) data[index];
    }

    @SuppressWarnings("unchecked")
    @Override
    public Object set(int index, Object element) {
        if (index >= data.length || index < 0) {
            throw new IndexOutOfBoundsException("Index " + index + "out of bounds for length " + data.length);
        }

        E previous = (E) data[index];
        data[index] = element;

        return previous;
    }

    @Override
    public void add(int index, Object element) {
        if (index > data.length || index < 0) {
            throw new IndexOutOfBoundsException();
        }

        Object[] newData = new Object[data.length + 1];
        for (int i = 0; i < index; i++) {
            newData[i] = data[i];
        }
        newData[index] = element;
        for (int i = index + 1; i < data.length + 1; i++) {
            newData[i] = data[i - 1];
        }
        data = newData;
    }

    @Override
    public E remove(int index) {
        if (index >= data.length || index < 0) {
            throw new IndexOutOfBoundsException("Index " + index + "out of bounds for length " + data.length);
        }

        E previous = (E) data[index];

        Object[] newData = new Object[data.length - 1];

        for (int i = 0; i < index; i++) {
            newData[i] = data[i];
        }
        for (int i = index + 1; i < data.length; i++) {
            newData[i - 1] = data[i];
        }
        data = newData;
        return previous;
    }

    @Override
    public int indexOf(Object o) {
        for (int i = 0; i < data.length; i++) {
            if (data[i].equals(o)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public int lastIndexOf(Object o) {
        for (int i = data.length - 1; i >= 0; i--) {
            if (data[i].equals(o)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public ListIterator listIterator() {
        return new MyArrayListListIterator<E>(data, 0);
    }

    @Override
    public ListIterator listIterator(int index) {
        return new MyArrayListListIterator<E>(data, index);
    }

    @Override
    public List subList(int fromIndex, int toIndex) {
        return null;
    }

    @Override
    public String toString() {
        String result = "[ ";

        for (int i = 0; i < data.length; i++) {
            result += " " + data[i] + " ";
        }
        result += "]";
        return result;
    }
}
