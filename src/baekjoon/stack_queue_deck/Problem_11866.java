package baekjoon.stack_queue_deck;

import java.io.*;
import java.util.*;

/*
  - 요세푸스 법칙에 따라 원에서 사람들이 제거되는 순서를 나열하자.

  1. N과 K를 입력받는다.
  2. 큐에 1부터 N을 입력받는다.
  3. while문을 통해 큐가 empty 상태가 될 때까지 k번째 수를 제거한다.
  4. 제거한 수는 Set에 저장해놓고, 이후 set에 포함된 수라면 큐 생성 시에 포함시키지 않는다.
  5. 그 수부터 시작하는 새로운 큐를 구성해 이어나간다.
 */

public class Problem_11866 {
  public static void main(String[] args) throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    StringBuilder sb = new StringBuilder();

    StringTokenizer st = new StringTokenizer(br.readLine(), " ");
    int n = Integer.parseInt(st.nextToken());
    int k = Integer.parseInt(st.nextToken());
    int first = 1;
    Queue<Integer> queue1 = new LinkedList<>();
    Queue<Integer> queue2 = new LinkedList<>();
    HashSet<Integer> set = new HashSet<>();

    for (int i = 1; i <= n; i++) {
      queue1.offer(i);
    }

    while(true) {
      for (int i = first; i <= n; i++) {
        if (set.contains(i)) {
          continue;
        }
        queue2.offer(i);
      }
      for (int i = 0; i < 3; i++) {
        if (i == 2) {
          Integer x = queue2.poll();
          first = x;
          sb.append(first).append(" ");
          set.add(x);
        } else {
          queue2.poll();
        }
      }
      if (queue2.isEmpty()) {
        break;
      }
    }

    bw.write(sb.toString());
    bw.close();
  }
}
