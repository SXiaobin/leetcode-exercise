package org.leetcode.exercise.datamodel.bfs;

import org.junit.Assert;
import org.junit.Test;

public class SolutionTest {

  public static final int INT = Integer.MAX_VALUE;


  @Test
  public void wallsAndGates() {
    int[][] rooms = {{INT, -1, 0, INT},
            {INT, INT, INT, -1},
            {INT, -1, INT, -1},
            {0, -1, INT, INT}};
    int[][] expected = {{3, -1, 0, 1}, {2, 2, 1, -1}, {1, -1, 2, -1}, {0, -1, 3, 4}};
    Solution solution = new Solution();
    solution.wallsAndGates(rooms);
    Assert.assertArrayEquals(rooms, expected);
  }

  @Test
  public void wallsAndGates_A() {
    int[][] rooms = {{INT, -1, 0, INT},
            {INT, INT, INT, -1},
            {INT, -1, INT, -1},
            {0, -1, INT, INT}};
    int[][] expected = {{3, -1, 0, 1}, {2, 2, 1, -1}, {1, -1, 2, -1}, {0, -1, 3, 4}};
    SolutionA solution = new SolutionA();
    solution.wallsAndGates(rooms);
    Assert.assertArrayEquals(rooms, expected);
  }
}