package baekjoon.basic0.stack_queue_deck;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/*
  - 주어진 명령의 수에 따라 명령을 수행하고 결과를 출력하자.

  1. 명령의 수를 입력받는다.
  2. 명령 수 만큼 for문을 돌려서 List 안에 숫자를 넣고 주어진 명령에 따라 결과를 출력한다.
 */

public class Problem_10828 {
  public static void main(String[] args) throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    StringBuilder sb = new StringBuilder();

    int n = Integer.parseInt(br.readLine());
    ArrayList<Integer> list = new ArrayList<>(n);
    for (int i = 0; i < n; i++) {
      StringTokenizer st = new StringTokenizer(br.readLine(), " ");
      String firstToken = st.nextToken();
      if (firstToken.equals("push")) {
        int x = Integer.parseInt(st.nextToken());
        list.add(x);
      } else if (firstToken.equals("pop")) {
        sb.append(pop(list)).append("\n");
      } else if (firstToken.equals("size")) {
        sb.append(list.size()).append("\n");
      } else if (firstToken.equals("empty")) {
        sb.append(empty(list)).append("\n");
      } else if (firstToken.equals("top")) {
        sb.append(top(list)).append("\n");
      }
    }
    bw.write(sb.toString());
    bw.close();
  }

  static int pop(List<Integer> list) {
    if (!list.isEmpty()) {
      int x = list.get(list.size() - 1);
      list.remove(list.size() - 1);
      return x;
    } else {
      return -1;
    }

  }

  static int empty(List<Integer> list) {
    if (list.isEmpty()) {
      return 1;
    } else {
      return 0;
    }
  }

  static int top(List<Integer> list) {
    if (!list.isEmpty()) {
      return list.get(list.size() - 1);
    } else {
      return -1;
    }
  }
}
