package baekjoon.stack_queue_deck;

import java.io.*;
import java.sql.Array;
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
    int tempSize = n;
    int last = -1;
    int resultIndex = (last + k) % tempSize;
    ArrayList<Integer> list = new ArrayList<>();
    ArrayList<Integer> result = new ArrayList<>();

    for (int i = 1; i <= n; i++) {
      list.add(i);
    }

    for (int i = 1; i <= n; i++) {
      result.add(list.get(resultIndex));
      list.remove(resultIndex);
      tempSize--;
      if (i == n) {
        continue;
      }
      last = (resultIndex + tempSize - 1) % tempSize;
      resultIndex = (last + k) % tempSize;
    }

    // 1 2--- 3- 4 5---- 6-- 7
    // 1 2 4 5 6 7

    sb.append("<");
    sb.append(result.get(0));
    for (int i = 1; i < n; i++) {
      sb.append(", ").append(result.get(i));
    }
    sb.append(">");

    bw.write(sb.toString());
    bw.close();
  }
}
