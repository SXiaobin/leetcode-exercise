package org.leetcode.exercise.datamodel.bfs;


import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class Solution {
  private static final int GATE = 0;
  private static final int WALL = -1;
  private static final int DEFAULT = Integer.MAX_VALUE;

  public void wallsAndGates(int[][] rooms) {
    for (int i = 0; i < rooms.length; i++) {
      for (int j = 0; j < rooms[i].length; j++) {
        if (rooms[i][j] == DEFAULT) {
          Node node = new Node();
          node.x = i;
          node.y = j;
          bfs(node, rooms);
        }
      }
    }
  }

  void bfs(Node root, int[][] rooms) {
    Queue<Node> queue = new LinkedList<>();
    Set<Node> used = new HashSet<>();
    int step = -1;
    queue.add(root);
    used.add(root);
    while (!queue.isEmpty()) {
      step = step + 1;

      Queue<Node> neighbors = new LinkedList<>();

      while (!queue.isEmpty()) {
        Node current = queue.poll();
        if (rooms[current.x][current.y] == GATE) {
          fillPassedGate(rooms, current, 0);
          return;
        }
        neighbors.addAll(pickNeighbors(current, rooms, used));
      }

      queue.addAll(neighbors);
    }
  }

  private void fillPassedGate(int[][] rooms, Node current, int step) {
    Node from = current.passedFrom;
    if (from == null)
      return;

    if (rooms[from.x][from.y] == DEFAULT)
      rooms[from.x][from.y] = step + 1;
    fillPassedGate(rooms, from, step + 1);
  }

  private Queue<Node> pickNeighbors(Node current, int[][] rooms, Set<Node> used) {
    Queue<Node> queue = new LinkedList<>();
    int[] diffValue = new int[]{-1, 1};
    for (int diffAtX : diffValue) {
      int x = current.x + diffAtX;
      int y = current.y;

      if (x < 0)
        continue;
      if (x >= rooms.length)
        continue;
      if (rooms[x][y] == WALL)
        continue;

      Node node = new Node();
      node.x = x;
      node.y = y;
      node.passedFrom = current;
      if (used.contains(node))
        continue;

      queue.add(node);
      used.add(node);
    }

    for (int diffAtY : diffValue) {
      int x = current.x;
      int y = current.y + diffAtY;

      if (y < 0)
        continue;
      if (y >= rooms[x].length)
        continue;
      if (rooms[x][y] == WALL)
        continue;

      Node node = new Node();
      node.x = x;
      node.y = y;
      node.passedFrom = current;
      if (used.contains(node))
        continue;
      queue.add(node);
      used.add(node);
    }
    return queue;
  }


  static class Node {
    int x;
    int y;
    Node passedFrom;

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
