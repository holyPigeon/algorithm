package baekjoon.basic0.stack_queue_deck;

import java.io.*;
import java.util.*;

/*
  - 연산을 자세히 살펴보면 사실 스택은 그냥 건너뛰어도 상관없는 구조
  - 애초에 state == 1인 항목은 패스하고, 나머지를 가지고 큐 연산을 조지면 결과가 동일하게 나옴
 */

public class Problem_24511_2 {

  public static void main(String[] args) throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    StringBuilder sb = new StringBuilder();

    int n = Integer.parseInt(br.readLine());

    int[] state = new int[n];

    StringTokenizer st = new StringTokenizer(br.readLine(), " ");
    for (int i = 0; i < n; i++) {
      state[i] = Integer.parseInt(st.nextToken());
    }

    Deque<Integer> deque = new ArrayDeque<>();

    StringTokenizer st2 = new StringTokenizer(br.readLine(), " ");
    for (int i = 0; i < n; i++) {
      if (state[i] == 0) {
        deque.addLast(Integer.parseInt(st2.nextToken()));
      } else {
        st2.nextToken();
      }

    }

    int n2 = Integer.parseInt(br.readLine());
    int[] input = new int[n2];

    StringTokenizer st3 = new StringTokenizer(br.readLine(), " ");

    // 핵심 로직
    for (int i = 0; i < n2; i++) {
      input[i] = Integer.parseInt(st3.nextToken());
      deque.addFirst(input[i]);
      sb.append(deque.pollLast()).append(" ");
    }

    bw.write(sb.toString());
    bw.close();
  }
}
