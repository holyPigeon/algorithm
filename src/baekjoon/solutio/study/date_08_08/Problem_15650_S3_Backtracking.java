package baekjoon.solutio.study.date_08_08;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Problem_15650_S3_Backtracking {
    static int[] numbers;
    static boolean[] visit;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        numbers = new int[M];
        visit = new boolean[N];

        dfs(N, M, 0, 0);
    }

    private static void dfs(int N, int M, int depth, int startAt) {
        if (depth == M) {
            for (int number : numbers) {
                System.out.print(number + " ");
            }
            System.out.println();

            return;
        }

        for (int i = startAt; i < N; i++) {
            if (!visit[i]) {
                visit[i] = true;
                numbers[depth] = i + 1;
                dfs(N, M, depth + 1, i + 1);
                visit[i] = false;
            }
        }
    }
}
