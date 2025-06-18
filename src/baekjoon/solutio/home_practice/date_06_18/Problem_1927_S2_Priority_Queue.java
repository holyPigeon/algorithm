package baekjoon.solutio.home_practice.date_06_18;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Problem_1927_S2_Priority_Queue {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        PriorityQueue<Integer> priorityQueueLowest = new PriorityQueue<>();

        for (int i = 0; i < N; i++) {
            int x = Integer.parseInt(br.readLine());
            if (x > 0) {
                priorityQueueLowest.add(x);
            } else {
                if (priorityQueueLowest.isEmpty()) {
                    System.out.println(0);
                } else {
                    System.out.println(priorityQueueLowest.poll());
                }
            }
        }
    }
}
