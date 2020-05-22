package com.umbrella;

/**
 * 链表
 *
 * @param <E>
 */
public class LinkedList<E> {

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

    //链表中的第一个元素  虚拟头节点（索引为0的节点的前一个节点）
    private Node dummyHead;

    //元素个数
    private int size;

    public LinkedList() {
        dummyHead = new Node(null, null);
        size = 0;
    }

    public int getSize() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public E remove(int index) {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("index too large or too small");
        }
        Node prev = dummyHead;
        for (int i = 0; i < index; i++) {
            prev = prev.next;
        }
        Node del = prev.next;
        prev.next = del.next;
        del.next = null;
        size--;
        return del.e;
    }

    public E removeFirst() {
        return remove(0);
    }

    public E removeLast() {
        return remove(size - 1);
    }

    public void add(int index, E e) {
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("index too large or too small");
        }
        Node prev = dummyHead;
        for (int i = 0; i < index; i++) {
            prev = prev.next;
        }
//            Node node = new Node(e);
//            node.next = prev.next;
//            prev.next = node;
        prev.next = new Node(e, prev.next);
        size++;
    }

    public void addFirst(E e) {
//        Node node = new Node(e);
//        node.next = head;
//        head = node;
        add(0,  e);
    }

    public void addLast(E e) {
        add(size, e);
    }

    public E get(int index) {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("illegal index");
        }
        Node cur = dummyHead.next;
        for (int i = 0; i < index; i++) {
            cur = cur.next;
        }
        return cur.e;
    }

    public E getFirst() {
        return get(0);
    }

    public E getLast() {
        return get(size - 1);
    }

    public void set(int index, E e) {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("illegal index");
        }
        Node cur = dummyHead.next;
        for (int i = 0; i < index; i++) {
            cur = cur.next;
        }
        cur.e = e;
    }

    public boolean contains(E e) {
        Node cur = dummyHead.next;
        while (cur != null) {
            if (cur.e.equals(e)) {
                return true;
            }
            cur = cur.next;
        }
        return false;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("linkedList: [");
        for (Node cur = dummyHead.next; cur != null; cur = cur.next) {
            sb.append(cur + " -> ");
        }
        sb.append("null ]");
        return sb.toString();
    }

    public static void main(String[] args) {
        LinkedList<Integer> linkedList = new LinkedList<>();
        linkedList.addLast(2);
        System.out.println(linkedList);
        linkedList.set(0, 10);
        System.out.println(linkedList);
        linkedList.addFirst(1);
        System.out.println(linkedList);
        linkedList.addLast(11);
        System.out.println(linkedList);
        linkedList.set(1, 3);
        System.out.println(linkedList);
        linkedList.addLast(4);
        linkedList.addLast(5);
        linkedList.addLast(6);
        linkedList.addLast(7);
        System.out.println(linkedList);
        linkedList.add(3, 8);
        System.out.println(linkedList);
        linkedList.set(1, 0);
        System.out.println(linkedList);
        linkedList.set(7, 90);
        System.out.println(linkedList);
        System.out.println(linkedList.getFirst());
        System.out.println(linkedList.getLast());
        System.out.println(linkedList.getSize());
        linkedList.set(3, 18);
        System.out.println(linkedList);
        linkedList.remove(3);
        System.out.println(linkedList);
        System.out.println(linkedList.removeFirst());
        System.out.println(linkedList);
        System.out.println(linkedList.removeLast());
        System.out.println(linkedList);
        System.out.println(linkedList.get(3));
        System.out.println(linkedList.contains(100));
        System.out.println(linkedList.contains(1));
        System.out.println(linkedList.contains(2));
        System.out.println(linkedList.contains(3));
        System.out.println(linkedList.contains(4));
        System.out.println(linkedList.contains(5));
        System.out.println(linkedList.contains(6));
        System.out.println(linkedList.contains(7));
        System.out.println(linkedList.contains(9));
    }
}
