package baekjoon.basic0.stack_queue_deck;

/*
  - 정해진 규칙에 따라 스택에 수를 저장하고 스택 안의 수들의 합을 구하자.

  1. 먼저 전체 입력 수를 받는다.
  2. 입력 수에 따라 for문을 돌리고 0이 아닌 숫자가 나오면 스택에 저장, 0이 나오면 스택의 top을 삭제한다.
  3. 모든 연산을 끝내고 스택 안에 있는 모든 수들의 합을 구한다.
 */

import java.io.*;
import java.util.Stack;

public class Problem_10773 {
  public static void main(String[] args) throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    StringBuilder sb = new StringBuilder();

    Stack<Integer> stack1 = new Stack<>();

    int n = Integer.parseInt(br.readLine());
    for (int i = 0; i < n; i++) {
      int x = Integer.parseInt(br.readLine());
      if (x == 0) {
        stack1.pop();
      } else {
        stack1.push(x);
      }
    }

    int sum = 0;
    int size = stack1.size();
    for (int i = 0; i < size; i++) {
      sum += stack1.pop();
    }

    bw.write(String.valueOf(sum));
    bw.close();
  }
}
