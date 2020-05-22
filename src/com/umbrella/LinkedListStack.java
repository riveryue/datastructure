package com.umbrella;

/**
 * 使用链表实现栈
 *
 * @param <E>
 */
public class LinkedListStack<E> implements Stack<E> {

    LinkedList<E> linkedList;

    public LinkedListStack() {
        linkedList = new LinkedList<>();
    }

    @Override
    public int getSize() {
        return linkedList.getSize();
    }

    @Override
    public boolean isEmpty() {
        return linkedList.isEmpty();
    }

    @Override
    public void push(E e) {
        linkedList.addFirst(e);
    }

    /**
     * 查看栈顶元素
     *
     * @return
     */
    @Override
    public E peek() {
        return linkedList.get(0);
    }

    /**
     * 取出栈顶元素
     *
     * @return
     */
    @Override
    public E pop() {
        return linkedList.removeFirst();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("stack top ").append(linkedList).append("tail");
        return sb.toString();
    }

    public static void main(String[] args) {
        LinkedListStack<Integer> stack = new LinkedListStack<>();
        System.out.println(stack.isEmpty());
        System.out.println(stack.getSize());
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        System.out.println(stack);
        System.out.println(stack.peek());
        Integer pop = stack.pop();
        System.out.println(pop);
        System.out.println(stack);
        System.out.println(stack.getSize());
        System.out.println(stack.isEmpty());
        stack.pop();
        stack.pop();
        stack.pop();
        System.out.println(stack);
    }
}
