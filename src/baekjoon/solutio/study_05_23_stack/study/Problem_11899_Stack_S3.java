package baekjoon.solutio.study_05_23_stack.study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Problem_11899_Stack_S3 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();

        int matchedBracket = 0; // 매칭된 총 괄호 수

        Stack<Character> openBrackets = new Stack<>();
        for (int i = 0; i < input.length(); i++) {
            Character ch = input.charAt(i);

            if (isOpenBracket(ch)) {
                openBrackets.push(ch);
            }
            if (isCloseBracket(ch)) {
                if (!openBrackets.isEmpty()) {
                    openBrackets.pop();
                    matchedBracket += 2;
                }
            }
        }

        int result = input.length() - matchedBracket; // 기존 문자열에서 매칭되지 못한 괄호들의 수를 계산
        System.out.println(result);
    }

    private static boolean isOpenBracket(Character ch) {
        if (ch == '(') {
            return true;
        }

        return false;
    }

    private static boolean isCloseBracket(Character ch) {
        if (ch == ')') {
            return true;
        }

        return false;
    }
}
