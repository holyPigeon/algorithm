package baekjoon.stack_queue_deck;

import java.io.*;
import java.util.*;

/*
  - 특정 순서대로 번호표를 가진 사람들이 서면 다 통과시킬 수 있는지 판별하자.

  1. input, temp, output 총 3개의 스택을 생성한다.
  2. k = 1부터 시작하여 input의 top이 1이(k가) 될 때까지 pop하고 pop한 수들은 temp에 넣는다.
  3. 만약 1이 나오면 1을 output에 push하며 이후 k++하여 2번 과정을 반복한다.
  4. k = n이 될 때까지 계속하고 만약 마지막에 temp.empty()가 false라면 실패, true라면 성공이다.
 */

public class Problem_12789 {
  public static void main(String[] args) throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    StringBuilder sb = new StringBuilder();

    int n = Integer.parseInt(br.readLine());
    int k = 1;
    StringTokenizer st = new StringTokenizer(br.readLine(), " ");
    List<Integer> input = new ArrayList<>();
    Stack<Integer> temp = new Stack<>();
    Stack<Integer> output = new Stack<>();
    for (int i = 0; i <  n; i++) {
      input.add(Integer.parseInt(st.nextToken()));
    }

    while(output.size() != n) {
      // input에 가득차있고 temp에는 아무도 없음
      if (!input.isEmpty() && temp.empty()) {
        if (input.get(0) == k) {
          output.push(input.get(0));
          input.remove(0);
          k++;
        } else {
          temp.push(input.get(0));
          input.remove(0);
        }
      } // input과 temp에 모두 차있을 때
      else if (!input.isEmpty() && !temp.empty()) {
        if (input.get(0) == k) {
          output.push(input.get(0));
          input.remove(0);
          k++;
        } else {
          temp.push(input.get(0));
          input.remove(0);
        }
        if (temp.peek() == k) {
          output.push(input.get(0));
          input.remove(0);
          k++;
        }
      } // input은 비고 temp에만 차있을 때
      else if (input.isEmpty() && !temp.empty()) {
        if (temp.peek() == k) {
          output.push(input.get(0));
          input.remove(0);
          k++;
        }
      }

//      if (input.get(0) != k) {
//        temp.push(input.get(0));
//        input.remove(0);
//      } else {
//        output.push(input.get(0));
//        input.remove(0);
//        k++;
//      }
    }

    if (temp.empty()) {
      sb.append("Nice");
    } else {
      sb.append("Sad");
    }

    bw.write(sb.toString());
    bw.close();
  }
}
