package baekjoon.stack;

import java.io.*;
import java.util.Stack;
import java.util.StringTokenizer;

public class Problem_28278 {
  public static void main(String[] args) throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    StringBuilder sb = new StringBuilder();

    int n = Integer.parseInt(br.readLine());
    Stack<Integer> stack = new Stack<>();
    for (int i = 0; i < n; i++) {
      StringTokenizer st = new StringTokenizer(br.readLine(), " ");
      int x1 = Integer.parseInt(st.nextToken());
      if (x1 == 1) {
        int x2 = Integer.parseInt(st.nextToken());
        stack.push(x2);
      } else if (x1 == 2) {
        if (stack.empty()) {
          sb.append("-1\n");
        } else {
          sb.append(stack.pop()).append("\n");
        }
      } else if (x1 == 3) {
        sb.append(stack.size()).append("\n");
      } else if (x1 == 4) {
        if (stack.empty()) {
          sb.append(1).append("\n");
        } else {
          sb.append(0).append("\n");
        }
      } else if (x1 == 5) {
        if (stack.empty()) {
          sb.append("-1\n");
        } else {
          sb.append(stack.peek()).append("\n");
        }
      }
    }
    bw.write(sb.toString());
    bw.close();
  }
}
