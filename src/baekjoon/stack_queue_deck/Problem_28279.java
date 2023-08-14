package baekjoon.stack_queue_deck;

import java.io.*;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;
import java.util.StringTokenizer;

public class Problem_28279 {
  public static void main(String[] args) throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    StringBuilder sb = new StringBuilder();

    int n = Integer.parseInt(br.readLine());
    Deque<Integer> deque = new LinkedList<>();

    for (int i = 0; i < n; i++) {
      StringTokenizer st = new StringTokenizer(br.readLine(), " ");
      int x1 = Integer.parseInt(st.nextToken());
      if (x1 == 1) {

        int x2 = Integer.parseInt(st.nextToken());
        deque.offerFirst(x2);

      } else if (x1 == 2) {

        int x2 = Integer.parseInt(st.nextToken());
        deque.offerLast(x2);

      } else if (x1 == 3) {

        Integer integer = deque.pollFirst();
        if (integer == null) {
          sb.append("-1").append("\n");
        } else {
          sb.append(integer).append("\n");
        }

      } else if (x1 == 4) {

        Integer integer = deque.pollLast();
        if (integer == null) {
          sb.append("-1").append("\n");
        } else {
          sb.append(integer).append("\n");
        }

      } else if (x1 == 5) {

        sb.append(deque.size()).append("\n");

      } else if (x1 == 6) {

        if (deque.isEmpty()) {
          sb.append(1).append("\n");
        } else {
          sb.append(0).append("\n");
        }

      } else if (x1 == 7) {

        Integer integer = deque.peekFirst();
        if (integer == null) {
          sb.append("-1").append("\n");
        } else {
          sb.append(integer).append("\n");
        }

      } else if (x1 == 8) {

        Integer integer = deque.peekLast();
        if (integer == null) {
          sb.append("-1").append("\n");
        } else {
          sb.append(integer).append("\n");
        }

      }
    }

    bw.write(sb.toString());
    bw.close();
  }
}
