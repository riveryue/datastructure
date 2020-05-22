package com.umbrella;

import java.util.Random;

public class Main {
    private static double testQueue(Queue<Integer> queue, int opCount) {
        long start = System.nanoTime();
        Random random = new Random();
        for (int i = 0; i < opCount; i++) {
            queue.enqueue(random.nextInt(Integer.MAX_VALUE));
        }
        for (int i = 0; i < opCount; i++) {
            queue.dequeue();
        }
        return (System.nanoTime() - start) / 1000000000.0;
    }

    private static double testStack(Stack<Integer> stack, int opCount) {
        long start = System.nanoTime();
        Random random = new Random();
        for (int i = 0; i < opCount; i++) {
            stack.push(random.nextInt());
        }
        for (int i = 0; i < opCount; i++) {
            stack.pop();
        }
        return (System.nanoTime() - start) / 1000000000.0;
    }

    public static void main(String[] args) {
        int opCount = 100000;
        System.out.println(testQueue(new LoopQueue<>(), opCount) +" seconds");
        System.out.println(testQueue(new ArrayQueue<>(), opCount) + " seconds");
        System.out.println(testQueue(new LinkedListQueue<>(), opCount) +" seconds");
//        System.out.println(testStack(new ArrayStack<>(), opCount));
//        System.out.println(testStack(new LinkedListStack<>(), opCount));
    }
}
