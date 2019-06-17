package org.leetcode.exercise.datamodel.queue;

import org.junit.Test;

import static org.junit.Assert.*;

public class MyCircularQueueTest {

  @Test
  public void test() {
    MyCircularQueue circularQueue = new MyCircularQueue(6); // 设置长度为 3

    assertTrue(circularQueue.enQueue(6));

    assertEquals(6, circularQueue.Rear());

    assertEquals(6, circularQueue.Rear());

    assertTrue(circularQueue.deQueue());

    assertTrue(circularQueue.enQueue(5));

    assertEquals(5, circularQueue.Rear());

    assertTrue(circularQueue.deQueue());

    assertEquals(-1, circularQueue.Front());

    assertFalse(circularQueue.deQueue());

    assertFalse(circularQueue.deQueue());

    assertFalse(circularQueue.deQueue());
  }
}