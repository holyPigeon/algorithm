package baekjoon.basic0.math;

import java.io.*;
import java.util.*;

public class problem_custom {

  private static int n;
  private static int m;
  private static TreasureMap[][] map;

  private static class TreasureMap {
    int y;
    int x;
    int value;

    public TreasureMap(int y, int x, int value) {
      this.y = y;
      this.x = x;
      this.value = value;
    }
  }

  private static TreasureMap findTreasureMap(int myY, int myX) {
    TreasureMap mine = map[myY][myX];

    int minDis = Integer.MAX_VALUE;
    TreasureMap result = null;

    for (int y = 0; y < n; y++) {
      for (int x = 0; x < m; x++) {
        TreasureMap now = map[y][x];
        if (y == myY && x == myX) continue;
        if (getDis(y, x, myY, myX) <= 3) {
          int dis = getDis(mine.y, mine.x, now.y, now.x);
          if (dis <= minDis) {
            minDis = dis;
            result = now;
          }
        }
      }
    }
    return result;
  }

  private static int getDis(int startY, int startX, int endY, int endX) {
    return Math.abs(startY - endY) + Math.abs(startX - endX);
  }

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    StringTokenizer st = new StringTokenizer(br.readLine());

    n = Integer.parseInt(st.nextToken());
    m = Integer.parseInt(st.nextToken());
    map = new TreasureMap[n][m];

    for (int y = 0; y < n; y++) {
      st = new StringTokenizer(br.readLine());
      for (int x = 0; x < m; x++) {
        int inputY = Integer.parseInt(st.nextToken());
        int inputX = Integer.parseInt(st.nextToken());
        int value = Integer.parseInt(st.nextToken());
        map[y][x] = new TreasureMap(inputY, inputX, value);
      }
    }

    st = new StringTokenizer(br.readLine());
    int myY = Integer.parseInt(st.nextToken());
    int myX = Integer.parseInt(st.nextToken());

    TreasureMap result = findTreasureMap(myY, myX);

    bw.write(String.format("%s %s %s", result.y, result.x, result.value));

    br.close();
    bw.close();
  }
}