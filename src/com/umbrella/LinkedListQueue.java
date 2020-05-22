package com.umbrella;

public class LinkedListQueue<E> implements Queue<E> {
    private class Node {
        public E e;
        public Node next;

        public Node(E e, Node next) {
            this.e = e;
            this.next = next;
        }

        public Node(E e) {
            this(e, null);
        }

        public Node() {
            this(null, null);
        }

        @Override
        public String toString() {
            return e.toString();
        }
    }

    private Node head, tail;
    private int size;

    public LinkedListQueue() {
        size = 0;
        head = null;
        tail = null;
    }


    /**
     * 入队
     *
     * @param e
     */
    @Override
    public void enqueue(E e) {
        Node node = new Node(e);
        if (tail == null) {
            tail = node;
            head = tail;
        } else {
            tail.next = node;
            tail = tail.next;
        }
        size++;
    }

    /**
     * 出队
     *
     * @return
     */
    @Override
    public E dequeue() {
        if (isEmpty()) {
            throw new IllegalArgumentException("queue is empty");
        }
        Node res = head;
        head = head.next;
        //将res节点和链表断了关系
        res.next = null;
        if (head == null) {
            tail = null;
        }
        size--;
        return res.e;
    }

    /**
     * 查看队首元素
     *
     * @return
     */
    @Override
    public E getFront() {
        if (isEmpty()) {
            throw new IllegalArgumentException("queue is empty");
        }
        return head.e;
    }

    /**
     * 元素个数
     *
     * @return
     */
    @Override
    public int getSize() {
        return size;
    }

    /**
     * 是否为空
     *
     * @return
     */
    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("queue size = " + size + " head[");
        for (Node cur = head; cur != null; cur = cur.next) {
            sb.append(cur);
            if (cur.next != null) {
                sb.append(" -> ");
            }
        }
        sb.append("-> null] tail");
        return sb.toString();
    }

    public static void main(String[] args) {
        LinkedListQueue<Integer> queue = new LinkedListQueue<>();
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);
        queue.enqueue(4);
        System.out.println(queue);
        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());
        System.out.println(queue);
    }
}
