package baekjoon.study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Problem_15649 {

    static int[] arr;
    static boolean[] visited;
    static int m, n;


    public static void main(String[] args) throws IOException {
        // init
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        arr = new int[n + 1];
        visited = new boolean[n + 1];
        for (int i = 1; i < n + 1; i++) {
            arr[i] = i;
        }

        dfs(0);
    }

    private static void dfs(int k) {
        if (k == m) {
            for (int i = 1; i < k + 1; i++) {
                System.out.print(arr[i] + " ");
            }
            System.out.println();
            return;
        }
        for (int i = 1; i < n + 1; i++) {
            if (!visited[i]) {
                visited[i] = true;
                arr[k + 1] = i;
                dfs(k + 1);

                visited[i] = false;
            }
        }
    }
}
