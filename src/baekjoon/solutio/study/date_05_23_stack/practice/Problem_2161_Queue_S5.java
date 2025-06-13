package baekjoon.solutio.study.date_05_23_stack.practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

/**
 * FIFO
 * 하나는 아예 버리고, 하나는 뽑아서 다시 뒤로 넣는다.
 */

public class Problem_2161_Queue_S5 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        Queue<Integer> queue = new LinkedList<>();
        for (int i = 1; i < N + 1; i++) {
            queue.add(i);
        }

        while(queue.size() > 1) {
            System.out.print(queue.poll() + " ");
            queue.add(queue.poll());
        }

        System.out.println(queue.poll());
    }
}
