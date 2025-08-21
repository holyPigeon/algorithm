package baekjoon.solutio.home_practice.date_08_22;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Problem_10819_S2_Backtracking {
    static int N;
    static int max = Integer.MIN_VALUE;
    static int[] numbers;
    static int[] selectedNumbers;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        numbers = new int[N];
        selectedNumbers = new int[N];
        visited = new boolean[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            numbers[i] = Integer.parseInt(st.nextToken());
        }

        dfs(0);

        System.out.println(max);
    }

    private static void dfs(int depth) {
        if (depth == N) {
            max = Math.max(max, sum(selectedNumbers));
            return;
        }

        for (int i = 0; i < N; i++) {
            if (!visited[i]) {
                visited[i] = true;
                selectedNumbers[depth] = numbers[i];
                dfs(depth + 1);
                visited[i] = false;
            }
        }
    }

    private static int sum(int[] selectedNumbers) {
        int sum = 0;
        for (int i = 0; i < N - 1; i++) {
            sum += Math.abs(selectedNumbers[i] - selectedNumbers[i + 1]);
        }

        return sum;
    }
}
