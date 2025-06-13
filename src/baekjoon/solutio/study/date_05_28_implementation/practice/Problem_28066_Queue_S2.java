package baekjoon.solutio.study.date_05_28_implementation.practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * 1. 첫 번쨰 규칙 -> 1번쨰 청설모부터 K 마리의 청설모를 선택한다. 손을 튕기면 1 ~ K 까지의 청설모 중 2 ~ K 까지의 청설모가 제거된다.
 * 2. 두 번쨰 규칙 -> 남아있는 전체 청설모가 K 마리보다 적은 경우, 첫 번쨰 청설모를 제외하고 모두 제거한다.
 * 3. 세 번쨰 규칙 -> 제거한 후 남아있는 청설모가 2마리 이상이라면, 첫 번째 청설모 "오른쪽"의 청설모가 첫 번째 청설모가 된다.
 */

public class Problem_28066_Queue_S2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        // 초기 청설모 세팅
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 1; i < N + 1; i++) {
            queue.offer(i);
        }

        // 청설모 제거
        while (queue.size() != 1) {
            if (queue.size() < K) {
                deleteExceptFirst(queue);
            } else {
                deleteK(queue, K);
            }
        }

        System.out.println(queue.peek());
    }

    private static void deleteK(Queue<Integer> queue, int k) {
        Integer firstElement = queue.poll();
        for (int i = 0; i < k - 1; i++) {
            queue.remove();
        }
        queue.offer(firstElement);
    }

    private static void deleteExceptFirst(Queue<Integer> queue) {
        Integer firstElement = queue.poll();

        while (!queue.isEmpty()) {
            queue.remove();
        }
        queue.offer(firstElement);
    }
}
