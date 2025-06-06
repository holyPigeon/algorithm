package baekjoon.solutio.study_05_23_stack.practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

/**
 * input의 길이만큼  반복문을 돌림
 * 스택에 계속 넣는다
 * 넣다가 "("나 "["가 보이면 별도의 스택에 넣기
 * input을 계속 읽다가 ")"나 "]"가 나오면 별도 스택 확인 -> peek 해봤는데 짝이 맞으면 -> () or [] -> pop
 * 맨 마지막에 온점이 찍혀있는지 확인
 */

public class Problem_4949_Stack_S4 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = "";

        while ((input = br.readLine()) != null) {
            String result = "yes";
            Stack<Character> stack = new Stack<>();
            for (int i = 0; i < input.length(); i++) {
                char ch = input.charAt(i);
                if (ch == '(' || ch == '[') {
                    stack.push(ch);
                }
                if (ch == ')' && !stack.isEmpty() && stack.peek() == '(') {
                    stack.pop();
                }
                if (ch == ']' && !stack.isEmpty() && stack.peek() == '[') {
                    stack.pop();
                }
            }

            if (!stack.isEmpty()) {
                result = "no";
            }
            if (input.charAt(input.length() - 1) != '.') {
                result = "no";
            }
            System.out.println(result);
        }

    }
}
