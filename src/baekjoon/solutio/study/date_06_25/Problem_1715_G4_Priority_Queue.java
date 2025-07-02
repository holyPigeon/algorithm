package baekjoon.solutio.study.date_06_25;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Problem_1715_G4_Priority_Queue {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        PriorityQueue<Integer> queue = new PriorityQueue<>();
        for (int i = 0; i < N; i++) {
            int x = Integer.parseInt(br.readLine());
            queue.offer(x);
        }

        // 10 20 40 -> 30 40 -> 70
        if (N == 1) {
            System.out.println(0);
        } else {
            int result = 0;
            int previousSum;
            while (queue.size() != 1) {
                    previousSum = queue.poll() + queue.poll();
                    int count = previousSum;
                    queue.offer(count);
                    result += count;
            }

            System.out.println(result);
        }
    }
}
