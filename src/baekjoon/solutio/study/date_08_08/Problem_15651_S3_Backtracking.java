package baekjoon.solutio.study.date_08_08;

import java.io.*;
import java.util.StringTokenizer;

public class Problem_15651_S3_Backtracking {
    static int[] numbers;
    static boolean[] visit;
    static StringBuilder sb;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        numbers = new int[M];
        visit = new boolean[N];

        dfs(N, M, 0);
        bw.write(sb.toString());

        br.close();
        bw.close();
    }

    private static void dfs(int N, int M, int depth) {
        if (depth == M) {
            for (int number : numbers) {
                sb.append(number).append(" ");
            }
            sb.append("\n");

            return;
        }

        for (int i = 0; i < N; i++) {
            if (!visit[i]) {
                numbers[depth] = i + 1;
                dfs(N, M, depth + 1);
            }
        }
    }
}
