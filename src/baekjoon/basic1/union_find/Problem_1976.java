package baekjoon.basic1.union_find;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Problem_1976 {

    static int[] array;
    static int[][] isConnected;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());
        array = new int[n + 1];
        isConnected = new int[n][n];

        // init
        for (int i = 0; i < n + 1; i++) {
            array[i] = i;
        }

        for (int i = 1; i < n + 1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 1; j < n + 1; j++) {
                int sign = Integer.parseInt(st.nextToken());

                if (sign == 1) {
                    union(i, j);
                }
            }
        }

        // logic
        String[] st2 = br.readLine().split(" ");
        boolean result = true;

        for (int i = 0; i < m - 1; i++) {
            if (!find(Integer.parseInt(st2[i]), Integer.parseInt(st2[i + 1]))) {
                result =  false;
            }
        }

        if (result) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }

    }

    private static void union(int x, int y) {
        int a = findRoot(x);
        int b = findRoot(y);
        if (a != b) {
            array[b] = a;
        }
    }

    private static boolean find(int x, int y) {
        if (findRoot(x) == findRoot(y)) {
            return true;
        }
        return false;
    }

    private static int findRoot(int a) {
        if (array[a] == a) {
            return a;
        } else {
            return array[a] = findRoot(array[a]);
        }
    }
}
