package Java.StacknQueue;

import java.util.ArrayList;
import java.util.*;
import Java.StacknQueue.TechBro;

public class Queue<E> {

    public static void main(String[] args) {
        Queue<TechBro> q = new Queue<>();
        q.push(new TechBro("Haskell"));
        q.push(new TechBro("Javascript"));

        TechBro sam = new TechBro("Java");
        TechBro spam = new TechBro("python");

        System.out.println(sam.greaterThan(spam));
        System.out.println(sam.lessThan(spam));

        System.out.println(q);
        q.pop();
        System.out.println(q);
    }

    List<E> queue;
    Queue<E> maxQueue;

    Queue() {
        this.queue = new ArrayList<E>();
    }

    Queue(E entry) {
        this.queue = new ArrayList<E>();
        this.queue.add(entry);
    }

    E peek() {
        return this.queue.get(this.queue.size() - 1);
    }

    void push(E item) {
        this.queue.add(item);
        // if (this.maxQueue.peek().equals(item)) {

        // }
    }

    E pop() {
        return this.queue.remove(0);
    }

    public String toString() {
        return this.queue.toString();
    }
}
