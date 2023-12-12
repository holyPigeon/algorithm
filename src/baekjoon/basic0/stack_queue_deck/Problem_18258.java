package baekjoon.basic0.stack_queue_deck;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Problem_18258 {
  public static void main(String[] args) throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    StringBuilder sb = new StringBuilder();

    int n = Integer.parseInt(br.readLine());
    int last = -1;
    Queue<Integer> queue = new LinkedList<>();
    for (int i = 0; i < n; i++) {
      StringTokenizer st = new StringTokenizer(br.readLine(), " ");
      String s = st.nextToken();

      if (s.equals("push")) {
        int x = Integer.parseInt(st.nextToken());
        queue.offer(x);
        last = x;
      } else if (s.equals("pop")) {
        if (queue.isEmpty()) {
          sb.append(-1).append("\n");;
        } else {
          sb.append(queue.poll()).append("\n");
        }
      } else if (s.equals("size")) {
        sb.append(queue.size()).append("\n");;
      } else if (s.equals("empty")) {
        if (queue.isEmpty()) {
          sb.append(1).append("\n");;
        } else {
          sb.append(0).append("\n");;
        }
      } else if (s.equals("front")) {
        if (queue.isEmpty()) {
          sb.append(-1).append("\n");;
        } else {
          sb.append(queue.peek()).append("\n");
        }
      } else if (s.equals("back")) {
        if (queue.isEmpty()) {
          sb.append(-1).append("\n");;
        } else if (last != -1) {
          sb.append(last).append("\n");
        }
      }
    }

    bw.write(sb.toString());
    bw.close();
  }
}
