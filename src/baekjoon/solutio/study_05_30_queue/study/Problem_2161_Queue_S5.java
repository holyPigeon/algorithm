package baekjoon.solutio.study_05_30_queue.study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Problem_2161_Queue_S5 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 1; i < N + 1; i++) {
            queue.offer(i);
        }

        while (queue.size() != 1) {
            System.out.print(queue.poll() + " ");
            queue.offer(queue.poll());
        }
        System.out.println(queue.poll());
    }
}
