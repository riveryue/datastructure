package com.umbrella.inter;

public interface Stack<E> {

    int getSize();

    boolean isEmpty();

    void push(E e);

    /**
     * 查看栈顶元素
     *
     * @return
     */
    E peek();

    /**
     * 取出栈顶元素
     *
     * @return
     */
    E pop();
}
