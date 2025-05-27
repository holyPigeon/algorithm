package baekjoon.solutio.study_05_23.study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Problem_4949_Stack_S4_Retry {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = "";

        while(!(input = br.readLine()).equals(".")) {
            if (isInputBalanced(input)) {
                System.out.println("yes");
            } else {
                System.out.println("no");
            }
        }
    }

    private static boolean isInputBalanced(String input) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < input.length(); i++) {
            char ch = input.charAt(i);

            if (isOpenBracket(ch)) {
                stack.push(ch);
            }
            if (isCloseBracket(ch)) {
                if (stack.isEmpty()) { // )
                    return false;
                }
                if (!isMatchedBracket(ch, stack.pop())) { // [)
                    return false;
                }
                // 이상적인 경우는 스택 안에 짝이 맞는 괄호가 존재
                // 그 외의 경우는 모두 반례
                // 1. 스택이 그냥 비어있다
                // 2. 스택이 비어있진 않은데 짝이 맞는 괄호가 아니다
            }
        }
        if (!stack.isEmpty()) {
            return false;
        }

        return true;
    }

    private static boolean isOpenBracket(Character ch) {
        return ch == '(' || ch == '[';
    }

    private static boolean isCloseBracket(Character ch) {
        return ch == ')' || ch == ']';
    }

    private static boolean isMatchedBracket(Character ch, Character bracketInStack) {
        if (ch == ')' && bracketInStack == '(') {
            return true;
        }
        if (ch == ']' && bracketInStack == '[') {
            return true;
        }

        return false;
    }
}
