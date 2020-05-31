package com.umbrella;

import java.util.Stack;

/**
 * 用栈来实现队列
 */
public class StackQueue<T> {

    //stack1用来存放元素
    private Stack<T> stack1 = new Stack<>();
    private Stack<T> stack2 = new Stack<>();

    public void push(T t) {
        stack1.push(t);
    }

    //若stack2为空，则将stack1中的元素压入stack2中。因为栈是先进后出（存取数据都在栈顶进行）的数据结构，
    // 而队列为先进先出（队尾存数据，对头取数据）的数据结构，故而从stack1中取数据存入stack2刚好可以模拟队列
    public T poll() {
        if (stack2.isEmpty()) {
            while (stack1.size() > 0) {
                stack2.push(stack1.pop());
            }
            if (stack2.isEmpty()) {
                throw new RuntimeException("queue is empty");
            }
        }
        return stack2.pop();
    }

    public static void main(String[] args) {
        StackQueue<Integer> queue = new StackQueue<>();
//        System.out.println(queue.poll());
        queue.push(3);
        queue.push(2);
        queue.push(1);
        System.out.println(queue.poll());
        System.out.println(queue.poll());
        System.out.println(queue.poll());
        System.out.println(queue.poll());
    }
}
