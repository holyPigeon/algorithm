package baekjoon.basic0.stack_queue_deck;

import java.io.*;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Problem_2346_2 {
  public static void main(String[] args) throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    StringBuilder sb = new StringBuilder();

    int n = Integer.parseInt(br.readLine());
    int move = 0;
    String index;
    StringTokenizer st = new StringTokenizer(br.readLine(), " ");
    Deque<int[]> deque = new ArrayDeque<>();

    sb.append(1).append(" ");
    move = Integer.parseInt(st.nextToken());
    if (move > 0) {
      index = "front";
    } else {
      index = "back";
    }
    deque.pollFirst();

    for (int i = 2; i <= n; i++) {
      deque.addLast(new int[] {i, Integer.parseInt(st.nextToken())});
    }

    while(!deque.isEmpty()) {

      if (move > 0) {
        for (int i = 0; i < Math.abs(move) - 1; i++) {
          deque.addLast(deque.pollFirst());
        }
        index = "front";
      } else {
        for (int i = 0; i < Math.abs(move) - 1; i++) {
          deque.addFirst(deque.pollLast());
        }
        index = "back";
      }

      int[] balloon;

      if (index.equals("front")) {
        balloon = deque.pollFirst();
      } else {
        balloon = deque.pollLast();
      }

      sb.append(balloon[0]).append(" ");
      move = balloon[1];
    }

    bw.write(sb.toString());
    bw.close();
  }
}
