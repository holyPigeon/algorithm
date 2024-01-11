package baekjoon.basic1.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

    /*
    theme: 최대한 많이 때려박을 수 있는 회의의 개수를 알아보자

    - 회의가 최대한 많이 들어가려면 회의 진행 시간 자체가 짧아야 한다.
    - 겹치지 않게 들어가는 방법
        - 앞 회의의 뒷 시간 <= 뒷 회의의 앞 시간
     */

public class Problem_1931 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[][] timeTable = new int[N][2];

        // init
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            timeTable[i][0] = Integer.parseInt(st.nextToken());
            timeTable[i][1] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(timeTable, Comparator.comparingInt((int[] array) -> array[1]).thenComparingInt(array -> array[0]));

        // logic
        int count = 1;
        int latest = 0;
        for (int i = 1; i < N; i++) {
            if (timeTable[latest][1] <= (timeTable[i][0])) { // 회의 시간이 겹치지 않는지
                latest = i;
                count++;
            }
        }

        System.out.println(count);
    }
}
