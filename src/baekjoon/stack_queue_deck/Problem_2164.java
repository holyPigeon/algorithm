package baekjoon.stack_queue_deck;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;

/*
  - N장의 카드를 가지고 특정 동작을 거쳐 마지막에 남는 하나의 카드를 찾자.

  1. N을 입력받는다.
  2. 1부터 N까지의 수를 큐에 저장한 다음 while문을 통해 동작을 거친다.
 */

public class Problem_2164 {
  public static void main(String[] args) throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    int n = Integer.parseInt(br.readLine());
    Queue<Integer> queue = new LinkedList<>();

    for (int i = 1; i <= n; i++) {
      queue.offer(i);
    }

    while(queue.size() != 1) {
      // 제일 위에 있는 카드를 바닥에 버린다.
      queue.remove();

      // 제일 위에 있는 카드를 제일 아래에 있는 카드 밑으로 옮긴다.
      Integer x = queue.poll();
      queue.offer(x);
    }

    bw.write(String.valueOf(queue.peek()));
    bw.close();
  }
}
