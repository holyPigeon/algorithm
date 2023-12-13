package baekjoon.basic1.data_structure_1;

import java.io.*;
import java.util.Stack;

/*
- 편집기 프로그램을 만들자

- 커서 기능을 만들어서, 주어진 문자열에 대하여 문자 삭제 및 추가 기능을 수행한다.
    - 커서를 구현한다. 커서가 위치할 수 있는 곳은 문자열의 길이 + 1의 곳이며, 이에 대한 리스트를 따로 구현한다.
 */

public class Problem_1406 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        String input = br.readLine();
        Stack<String> stack1 = new Stack<>();
        Stack<String> stack2 = new Stack<>();

        for (char text : input.toCharArray()) {
            stack1.push(String.valueOf(text));
        }

        int count = Integer.parseInt(br.readLine());

        for (int i = 0; i < count; i++) {
            String[] tokens = br.readLine().split(" ");
            if (tokens[0].equals("L")) {
                moveCursorLeft(stack1, stack2);
            }
            if (tokens[0].equals("D")) {
                moveCursorRight(stack1, stack2);
            }
            if (tokens[0].equals("B")) {
                deleteText(stack1);
            }
            if (tokens[0].equals("P")) {
                stack1.push(tokens[1]);
            }
        }

        while (!stack2.isEmpty()) {
            stack1.push(stack2.pop());
        }

        stack1.forEach(sb::append);
        bw.write(sb.toString());
        bw.close();
        br.close();
    }

    private static void moveCursorLeft(Stack<String> stack1, Stack<String> stack2) {
        if (!stack1.empty()) {
            stack2.push(stack1.pop());
        }
    }

    private static void moveCursorRight(Stack<String> stack1, Stack<String> stack2) {
        if (!stack2.empty()) {
            stack1.push(stack2.pop());
        }
    }

    private static void deleteText(Stack<String> stack1) {
        if (!stack1.empty()) {
            stack1.pop();
        }
    }
}
