package baekjoon.solutio.study.date_06_18;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Problem_4889_S1_Stack {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input;
        int index = 0;

        while (!(input = br.readLine()).contains("-")) {
            index++;

            Stack<Character> openBrackets = new Stack<>();
            int result = 0;

            for (int i = 0; i < input.length(); i++) {
                Character ch = input.charAt(i);

                if (ch == '{') {
                    // 여는 괄호면 스택에 넣는다.
                    openBrackets.push('{');
                } else if (ch == '}') {
                    // 닫는 괄호인데 스택 안에 여는 괄호가 있다면, 뽑아서 없앤다.
                    if (!openBrackets.isEmpty()) {
                        openBrackets.pop();
                    // 닫는 괄호인데 스택이 비었다면, 해당 닫는 괄호를 여는 괄호로 바꾸고 변경 횟수를 하나 올린다.
                    } else {
                        openBrackets.push('{');
                        result++;
                    }
                }
            }

            // 동일한 괄호가 2개 남았을 경우, 괄호 하나를 바꾸면 안정적인 문자열이 되므로 스택 크기에서 2를 나눠 더해준다.
            result += openBrackets.size() / 2;
            System.out.println(index + ". " + result);
        }
    }
}
