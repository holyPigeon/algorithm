package baekjoon.solutio.study.date_08_20;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Problem_6603_S2_Backtracking {
    static int K;
    static int[] numbers, selectedNumbers;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while(true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            K = Integer.parseInt(st.nextToken());
            if (K == 0) {
                break;
            }

            numbers = new int[K];
            selectedNumbers = new int[6];
            visited = new boolean[K];
            for (int i = 0; i < K; i++) {
                numbers[i] = Integer.parseInt(st.nextToken());
            }

            dfs(0, 0);
            System.out.println();
        }
    }

    private static void dfs(int depth, int start) {
        if (depth == 6) {
            for (int number : selectedNumbers) {
                System.out.print(number + " ");
            }
            System.out.println();
            return;
        }

        for (int i = start; i < K; i++) {
            if (!visited[i]) {
                visited[i] = true;
                selectedNumbers[depth] = numbers[i];
                dfs(depth + 1, i + 1);
                visited[i] = false;
            }
        }
    }
}
