package org.leetcode.exercise.datamodel.bfs.$200;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 岛屿数量
 */
public class Solution {
  private static final char SEA = '0';
  private static final char EXPLORED = 'Y';

  public int numIslands(char[][] grid) {
    int islandNumber = 0;
    for (int i = 0; i < grid.length; i++) {
      for (int j = 0; j < grid[i].length; j++) {
        if (grid[i][j] == SEA || grid[i][j] == EXPLORED)
          continue;
        Node node = new Node();
        node.x = i;
        node.y = j;
        exploreOneIsland(node, grid);
        islandNumber++;
      }
    }
    return islandNumber;
  }

  private void exploreOneIsland(Node startFrom, char[][] grid) {
    Queue<Node> footprints = new LinkedList<>();
    footprints.add(startFrom);
    /*
     * 从某一个原点开始，走遍一个小岛
     * */
    while (!footprints.isEmpty()) {
      Node footprint = footprints.poll();
      footprints.addAll(pickNextSteps(footprint, grid));
    }
  }

  private Queue<Node> pickNextSteps(Node footprint, char[][] grid) {
    Queue<Node> queue = new LinkedList<>();
    int[] stepForwards = new int[]{-1, 1};

    for (int stepForward : stepForwards) {
      int x = footprint.x + stepForward;
      int y = footprint.y;

      if (x < 0)
        continue;
      if (x >= grid.length)
        continue;
      if (grid[x][y] == EXPLORED || grid[x][y] == SEA)
        continue;
      Node node = new Node();
      node.x = x;
      node.y = y;
      queue.add(node);
      grid[x][y] = EXPLORED;
    }

    for (int stepForward : stepForwards) {
      int x = footprint.x;
      int y = footprint.y + stepForward;

      if (y < 0)
        continue;
      if (y >= grid[x].length)
        continue;
      if (grid[x][y] == EXPLORED || grid[x][y] == SEA)
        continue;
      Node node = new Node();
      node.x = x;
      node.y = y;
      queue.add(node);
      grid[x][y] = EXPLORED;
    }

    return queue;
  }

  static class Node {
    int x;
    int y;

    @Override
    public int hashCode() {
      int result = 17;
      result = result + x;
      result = 32 * result + y;
      return result;
    }

    @Override
    public boolean equals(Object obj) {
      if (obj == null)
        return false;
      if (this == obj)
        return true;
      if (obj instanceof Node) {
        Node node = (Node) obj;
        return this.x == node.x && this.y == node.y;
      }
      return false;
    }
  }
}
