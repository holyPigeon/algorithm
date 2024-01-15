package baekjoon.basic1.union_find;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Problem_1717 {

    static int[] array;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        array = new int[n + 1];

        // init
        for (int i = 0; i < n + 1; i++) {
            array[i] = i;
        }

        for (int i = 0; i < m; i++) {
            StringTokenizer st2 = new StringTokenizer(br.readLine());

            int operator = Integer.parseInt(st2.nextToken());
            int a = Integer.parseInt(st2.nextToken());
            int b = Integer.parseInt(st2.nextToken());

            if (operator == 0) { // union
                union(a, b);
            }

            if (operator == 1) { // find
                System.out.println(find(a, b));
            }
        }
    }

    private static void union(int x, int y) {
        int a = findRoot(x);
        int b = findRoot(y);
        if(a != b) {
            array[b] = a;
        }
    }

    private static String find(int a, int b) {
        if (findRoot(a) == findRoot(b)) {
            return "YES";
        }
        return "No";
    }

    private static int findRoot(int a) {
        if (array[a] == a) {
            return a;
        } else {
            return array[a] = findRoot(array[a]); // 배열의 해당 인덱스값을 루트 노드로 바꾼다.
        }
    }
}
