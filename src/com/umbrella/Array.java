package com.umbrella;

import java.util.Arrays;

public class Array<E> {

    private E[] data;
    //数组中的元素个数
    private int size;

    public Array(int capacity) {
        data = (E[]) new Object[capacity];
        size = 0;
    }

    public Array() {
        this(10);
    }

    @Override
    public String toString() {
        return Arrays.toString(data);
    }

    public int getSize() {
        return size;
    }

    public int getCapacity() {
        return data.length;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void addLast(E e) {
        add(e, size);
    }

    public void addFirst(E e) {
        add(e, 0);
    }

    public void add(E e, int index) {
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("index must to be >= 0 and < size");
        }
        if (size == data.length) {
//            throw new IllegalArgumentException("数组已满");
            resize(2 * data.length);
        }
        for (int a = size - 1; a >= index; a--) {
            data[a + 1] = data[a];
        }
        data[index] = e;
        size++;
    }

    private void resize(int newCapacity) {
        E[] newData = (E[]) new Object[newCapacity];
        for (int j = 0; j < size; j++) {
            newData[j] = data[j];
        }
        data = newData;
    }

    public E get(int index) {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("下标过大或过小");
        }
        return data[index];
    }

    public E getLast() {
        return get(size - 1);
    }

    public E getFirst() {
        return get(0);
    }

    public void set(int index, E e) {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("下标过大或过小");
        }
        data[index] = e;
    }

    public boolean contains(E e) {
        for (int i = 0; i < size; i++) {
            if (data[i].equals(e)) {
                return true;
            }
        }
        return false;
    }

    public int findIndex(E e) {
        for (int i = 0; i < size; i++) {
            if (data[i] == e) {
                return i;
            }
        }
        return -1;
    }

    //删除下标为index的元素，并返回被删除的元素
    public E remove(int index) {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("下标过大或过小");
        }
        E res = data[index];
        for (int i = index + 1; i < size; i++) {
            data[i - 1] = data[i];
        }
        size--;
        data[size] = null;
        //避免复杂度震荡
        if (size == data.length / 4 && data.length / 2 != 0) {
            resize(data.length / 2);
        }
        return res;
    }

    public E removeFirst() {
        return remove(0);
    }

    public E removeLast() {
        return remove(size - 1);
    }

    public void removeElement(E e) {
        int index = findIndex(e);
        if (index != -1) {
            remove(index);
        }
    }

    public static void main(String[] args) {
        Array<Integer> array = new Array<>(10);
        array.addLast(1);
        array.addLast(2);
        array.addLast(3);
        array.addLast(4);
        array.addLast(5);
        array.addLast(6);
        array.addLast(7);
        array.addLast(8);
        array.addLast(9);
        array.addLast(10);
        System.out.println(array);
        array.removeElement(2);
        System.out.println(array);
        System.out.println(array.remove(3));
        System.out.println(array);
        System.out.println(array.removeLast());
        System.out.println(array);
        array.addFirst(11);
        System.out.println(array);
        array.add(99, 3);
        System.out.println(array);
        array.removeFirst();
        System.out.println(array);
        boolean contains = array.contains(99);
        System.out.println(contains);
        array.set(2, 100);
        System.out.println(array);
        System.out.println(array.get(2));


    }
}
