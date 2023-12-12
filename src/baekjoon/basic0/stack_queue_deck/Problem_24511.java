package baekjoon.basic0.stack_queue_deck;

import java.io.*;
import java.util.StringTokenizer;

/*
  - queuestack 이라는 자료구조에는 queue 또는 stack이 들어가는데 원본 queuestack에 어떠한 수열을 삽입하고 pop한 return 값을 구하자.

  1. queue일 경우 원래 있던 요소를 선택하고, stack일 경우에는 삽입하려 했던 수를 선택한다.
  2. 수열 C의 요소들을 qs에 규칙에 따라 순회공연을 돌리고 결과값을 sb.append 한다.
 */

public class Problem_24511 {
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

    int[] qs = new int[n];

    StringTokenizer st2 = new StringTokenizer(br.readLine(), " ");
    for (int i = 0; i < n; i++) {
      qs[i] = Integer.parseInt(st2.nextToken());
    }

    int n2 = Integer.parseInt(br.readLine());
    int[] input = new int[n2];

    StringTokenizer st3 = new StringTokenizer(br.readLine(), " ");

    // 핵심 로직
    int x;

    for (int i = 0; i < n2; i++) {
      input[i] = Integer.parseInt(st3.nextToken());
      x = input[i];
      for (int j = 0; j < n; j++) {
        if (state[j] == 0) {
          int temp = qs[j];
          qs[j] = x;
          x = temp;
        }
      }
      sb.append(x).append(" ");
    }

    bw.write(sb.toString());
    bw.close();
  }
}
