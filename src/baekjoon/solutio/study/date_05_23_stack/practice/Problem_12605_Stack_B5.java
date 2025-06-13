package baekjoon.solutio.study.date_05_23_stack.practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

/**
 * 단어들을 반대 순서로 뒤집어라 -> 나중에 들어온 애들이 먼저 나온다 -> LIFO
 *
 */

public class Problem_12605_Stack_B5 {
    public static void main(String[] args) throws IOException {

        // read
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            Stack<String> stack = new Stack<>();

            StringTokenizer st = new StringTokenizer(br.readLine());

            while(st.hasMoreTokens()) {
                stack.push(st.nextToken());
                System.out.println(st.countTokens());
            }

            System.out.print("Case #" + (i + 1) + ": ");
            while (!stack.isEmpty()) {
                System.out.print(stack.pop() + " ");
            }
            System.out.println();
        }
    }
}
