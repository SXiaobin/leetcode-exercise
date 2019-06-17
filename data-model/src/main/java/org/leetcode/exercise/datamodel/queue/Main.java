package org.leetcode.exercise.datamodel.queue;

import java.util.LinkedList;
import java.util.Queue;

public class Main {
  public static void main(String[] args) {
    MyQueue q = new MyQueue();
    q.enQueue(5);
    q.enQueue(3);
    if (!q.isEmpty()) {
      System.out.println(q.Front());
    }
    q.deQueue();
    if (!q.isEmpty()) {
      System.out.println(q.Front());
    }
    q.deQueue();
    if (!q.isEmpty()) {
      System.out.println(q.Front());
    }

    // 1. Initialize a queue.
    Queue<Integer> queue = new LinkedList<>();
    // 2. Get the first element - return null if queue is empty.
    System.out.println("The first element is: " + queue.peek());
    // 3. Push new element.
    queue.offer(5);
    queue.offer(13);
    queue.offer(8);
    queue.offer(6);
    // 4. Pop an element.
    queue.poll();
    // 5. Get the first element.
    System.out.println("The first element is: " + queue.peek());
    // 7. Get the size of the queue.
    System.out.println("The size is: " + queue.size());
  }
}
