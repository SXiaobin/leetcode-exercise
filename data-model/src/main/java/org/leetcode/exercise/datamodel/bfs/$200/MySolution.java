package org.leetcode.exercise.datamodel.bfs.$200;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 岛屿数量
 */
public class MySolution {
  private static final char ISLAND = 1;
  private static final char SEA = 0;
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
      grid[footprint.x][footprint.y] = EXPLORED;
      footprints.addAll(pickNextSteps(footprint, grid));
    }
  }

  private Queue<Node> pickNextSteps(Node footprint, char[][] grid) {
    /*
     * 因为我们是在从左至右、从上至下遍历图，所以实际上我们在找寻没有遍历过的相邻节点时，只需向右向下遍历即可
     * */
    // 向右走
    Queue<Node> queue = new LinkedList<>();
    int x = footprint.x + 1;
    int y = footprint.y;
    if (x < grid.length && (grid[x][y] != EXPLORED) && (grid[x][y] != SEA)) {
      Node node = new Node();
      node.x = x;
      node.y = y;
      queue.add(node);
    }

    // 向下走
    x = footprint.x;
    y = footprint.y + 1;
    if (y < grid[x].length && (grid[x][y] != EXPLORED)) {
      Node node = new Node();
      node.x = x;
      node.y = y;
      queue.add(node);
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
