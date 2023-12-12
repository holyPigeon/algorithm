package baekjoon.basic0.stack_queue_deck;

import java.io.*;
import java.util.Stack;

/*
  - 입력으로 주어진 괄호 문자열의 여는 쌍과 닫는 쌍의 수가 맞는지 판별하자.

  1. 먼저 전체 입력 수를 받는다.
  2. 문자열을 받아서 "("가 나오면 스택에 넣고 "}"가 나오면 기존 스택에서 pop한다.
  3. 마지막에 스택에 아무것도 남아있지 않으면 VPS가 맞다.
  4. 그 외에 무언가 남아있거나 size가 0인데 pop하려는 경우, VPS가 아니다.
 */

public class Problem_9012 {
  public static void main(String[] args) throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    StringBuilder sb = new StringBuilder();

    int n = Integer.parseInt(br.readLine());
    int pass = 0;

    for (int i = 0; i < n; i++) {
      pass = 0;
      String s = br.readLine();
      Stack<String> stack1 = new Stack<>();
      for (int j = 0; j < s.length(); j++) {
        if (pass == 1) {
          continue;
        }
        char c = s.charAt(j);
        if (c == '(') {
          stack1.push("(");
        } else if (c == ')' && stack1.size() != 0) {
          stack1.pop();
        } else if (c == ')' && stack1.empty()) {
          sb.append("NO\n");
          pass = 1;
        }
      }
      if (pass == 1) {
        continue;
      }
      if (stack1.empty()) {
        sb.append("YES\n");
      } else {
        sb.append("NO\n");
      }
    }

    bw.write(sb.toString());
    bw.close();
  }
}
