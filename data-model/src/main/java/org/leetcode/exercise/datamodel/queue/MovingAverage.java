package org.leetcode.exercise.datamodel.queue;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.atomic.AtomicReference;

public class MovingAverage {
  private Queue<Integer> queue;
  private int movingSize;

  /**
   * Initialize your data structure here.
   */
  public MovingAverage(int size) {
    queue = new LinkedList<>();
    movingSize = size;
  }

  public double next(int val) {
    if (queue.size() >= movingSize)
      queue.remove();
    queue.add(val);
    AtomicReference<Integer> sum = new AtomicReference<>(0);
    queue.forEach(integer -> sum.set(sum.get() + integer));
    return (double) sum.get() / queue.size();
  }
}
