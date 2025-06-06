package baekjoon.solutio.study_05_30_queue.study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Problem_28066_Queue_S2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        Queue<Integer> queue = new LinkedList<>();
        for (int i = 1; i < N + 1; i++) {
            queue.offer(i);
        }

        while (queue.size() != 1) {
            if (queue.size() < K) {
                Integer firstOne = queue.poll();
                queue.clear();
                queue.offer(firstOne);
            } else {
                Integer firstOne = queue.poll();
                for (int i = 0; i < K - 1; i++) {
                    queue.poll();
                }
                queue.offer(firstOne);
            }
        }

        System.out.println(queue.peek());
    }
}
