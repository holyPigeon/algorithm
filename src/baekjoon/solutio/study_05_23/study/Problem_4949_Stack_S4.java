package baekjoon.solutio.study_05_23.study;

import java.io.*;
import java.util.Stack;

public class Problem_4949_Stack_S4 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = "";

        while((input = br.readLine()) != null) {
            if (input.equals(".")) {
                break;
            }

            Stack<Character> stack = new Stack<>();
            String result = "yes";

            for (int i = 0; i < input.length(); i++) {
                // i번째 문자 저장
                Character ch = input.charAt(i);

                // i번쨰 문자가 시작하는 괄호라면, 별도의 스택에 저장
                if (ch == '(' || ch == '[') {
                    stack.push(ch);
                }

                // i번째 문자가 끝나는 괄호라면, 스택의 맨 위에 시작하는 괄호가 있는지 확인한다. 있다면 pop()
                if (ch == ')') {
                    // 만약 별도 스택에 짝이 안 맞는 괄호가 있다면, no -> ex. "[)"
                    if (!stack.isEmpty() && stack.peek() == '[') {
                        result = "no";
                    }
                    // 만약 별도 스택에 아무것도 없다면, no -> ex. "[])"
                    if (stack.isEmpty()) {
                        result = "no";
                    }
                    // 만약 별도 스택에 짝이 맞는 괄호가 있다면, 해당 괄호를 꺼낸다. -> ex. "()"
                    if (!stack.isEmpty() && stack.peek() == '(') {
                        stack.pop();
                    }

                } else if (ch == ']') {
                    if (!stack.isEmpty() && stack.peek() == '(') {
                        result = "no";
                    }
                    if (stack.isEmpty()) {
                        result = "no";
                    }
                    if (!stack.isEmpty() && stack.peek() == '[') {
                        stack.pop();
                    }
                }
            }
            // 혹시 스택에 아직 매칭되지 못한 괄호가 남아있다면 no
            if (!stack.isEmpty()) {
                result = "no";
            }

            System.out.println(result);
        }

        br.close();
    }
}
