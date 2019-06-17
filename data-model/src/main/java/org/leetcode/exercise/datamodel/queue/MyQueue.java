package org.leetcode.exercise.datamodel.queue;// "static void main" must be defined in a public class.

import java.util.ArrayList;
import java.util.List;

public class MyQueue {
  // store elements
  private List<Integer> data;
  // a pointer to indicate the start position
  private int p_start;

  public MyQueue() {
    data = new ArrayList<Integer>();
    p_start = 0;
  }

  /**
   * Insert an element into the queue. Return true if the operation is successful.
   */
  public boolean enQueue(int x) {
    data.add(x);
    return true;
  }


  /**
   * Delete an element from the queue. Return true if the operation is successful.
   */
  public boolean deQueue() {
    if (isEmpty()) {
      return false;
    }
    p_start++;
    return true;
  }

  /**
   * Checks whether the queue is empty or not.
   */
  public boolean isEmpty() {
    return p_start >= data.size();
  }

  /**
   * Get the front item from the queue.
   */
  public int Front() {
    return data.get(p_start);
  }
}

