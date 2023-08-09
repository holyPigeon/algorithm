package baekjoon.stack_queue_deck;

import java.io.*;
import java.util.Stack;

/*
  - 각 괄호들의 쌍이 맞는지 판별하자.

  1. while문으로 입력을 받고 입력 문자열이 "." 이라면 break 한다.
  2. "[", "(" 가 나오면 스택에 push한다.
  3. "]", ")" 가 나오면 스택의 top을 확인해서 짝이 맞는지 확인해보고, 맞으면 pop, 안 맞으면 NO 출력
  4. 마지막에 스택이 비어있다면 YES 출력
 */

public class Problem_4949 {
  public static void main(String[] args) throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    StringBuilder sb = new StringBuilder();

    int pass;

    while(true) {
      pass = 0;
      String s = br.readLine();
      if (s.equals(".")) {
        break;
      }
      Stack<Character> stack = new Stack<>();
      for (int i = 0; i < s.length(); i++) {
        if (pass == 1) {
          continue;
        }
        if (s.charAt(i) == '(' || s.charAt(i) == '[') { // 열린 괄호가 나오면 스택에 저장한다.
          stack.push(s.charAt(i));
        } else if (s.charAt(i) == ')' && !stack.empty()) { // 닫힌 괄호가 나오면 스택의 top과 비교한다.
          if (stack.peek() == '(') { // 스택의 top이 짝이 맞는다면 pop한다.
            stack.pop();
          } else { // 짝이 맞지 않는다면 StringBuilder에 NO를 추가하고 break한다.
            sb.append("no");
            pass = 1;
          }
        } else if (s.charAt(i) == ']' && !stack.empty()) {
          if (stack.peek() == '[') {
            stack.pop();
          } else {
            sb.append("no");
            pass = 1;
          }
        } else if (s.charAt(i) == ')' && stack.empty()) {
          sb.append("no");
          stack.push(')');
          pass = 1;
        } else if (s.charAt(i) == ']' && stack.empty()) {
          sb.append("no");
          stack.push(']');
          pass = 1;
        }
      }
      if (stack.empty()) {
        sb.append("yes");
      } else {
        if (pass == 0) {
          sb.append("no");
        }
      }
      sb.append("\n");
    }
    bw.write(sb.toString());
    bw.close();
  }
}
