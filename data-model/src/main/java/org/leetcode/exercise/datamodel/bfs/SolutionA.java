package org.leetcode.exercise.datamodel.bfs;

/**
 * 脱离宽度优先搜索模板的思维惯性，由“门”出发，使用递归实现。这种实现实际上为多次深度优先。
 */
public class SolutionA {
  public void wallsAndGates(int[][] rooms) {
    for (int i = 0; i < rooms.length; i++) {
      for (int j = 0; j < rooms[i].length; j++) {
        if (rooms[i][j] == 0) {
          bfs(rooms, i, j, 0);
        }
      }
    }
  }

  void bfs(int[][] rooms, int x, int y, int val) {
    if (x < 0 || x >= rooms.length)
      return;
    if (y < 0 || y >= rooms[x].length)
      return;
    // 关键语句，这个判定条件决定了多次探索同一节点的终止问题以及远近问题
    if (rooms[x][y] < val)
      return;
    rooms[x][y] = val;

    bfs(rooms, x + 1, y, val + 1);
    bfs(rooms, x, y + 1, val + 1);
    bfs(rooms, x - 1, y, val + 1);
    bfs(rooms, x, y - 1, val + 1);
  }
}
