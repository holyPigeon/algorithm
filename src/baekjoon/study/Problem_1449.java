package baekjoon.study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Problem_1449 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // init
        StringTokenizer st1 = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st1.nextToken());
        int tapeLength = Integer.parseInt(st1.nextToken());

        boolean[] map = new boolean[1001];
        int[] spots = new int[n];
        StringTokenizer st2 = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            spots[i] = Integer.parseInt(st2.nextToken());
        }
        Arrays.sort(spots);

        // logic
        int count = 0;
        for (int spot : spots) {
            if (!map[spot]) {
                int end = spot + tapeLength;
                if (end > 1000) {
                    end = 1001;
                }
                for (int i = spot; i < end; i++) {
                    map[i] = true;
                }
                count++;
            }
        }

        // print
        System.out.println(count);
    }
}
