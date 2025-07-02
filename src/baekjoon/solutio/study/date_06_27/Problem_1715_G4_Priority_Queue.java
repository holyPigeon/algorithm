package baekjoon.solutio.study.date_06_27;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Problem_1715_G4_Priority_Queue {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Integer N = Integer.parseInt(br.readLine());

        PriorityQueue<Integer> queue = new PriorityQueue<>();
        for (int i = 0; i < N; i++) {
            queue.offer(Integer.parseInt(br.readLine()));
        }

        int result = 0;
        while(queue.size() != 1) {
            int sum = queue.poll() + queue.poll(); // 우선순위 큐에서 가장 작은 숫자 둘을 뽑는다.
            queue.offer(sum); // sum 을 다시 큐에 넣는다.
            result += sum; // 총 비교 횟수에 sum 을 추가한다.
        }

        System.out.println(result);
    }
}
