package baekjoon.solutio.study_05_23.study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Problem_12605_Stack_B2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            Stack<String> words = new Stack<>();
            StringTokenizer st = new StringTokenizer(br.readLine());

            while (st.hasMoreTokens()) {
                words.push(st.nextToken());
            }

            System.out.print("Case #" + (i + 1) + ": ");
            while(!words.isEmpty()) {
                System.out.print(words.pop() + " ");
            }
            System.out.println();
        }
    }
}
