package baekjoon.solutio.home_practice.date_06_23;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Problem_2075_S3_Priority_Queue {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[][] numbers = new int[N][N];

        PriorityQueue<Integer> result = new PriorityQueue<>(Comparator.reverseOrder());
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                result.offer(Integer.parseInt(st.nextToken()));
            }
        }
        
        // logic
        for (int i = 0; i < N - 1; i++) {
            result.poll();
        }

        System.out.println(result.poll());
    }
}
