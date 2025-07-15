package baekjoon.solutio.study.date_07_11;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Problem_7662_G4_HashMap_Try_1 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            int K = Integer.parseInt(br.readLine());

            Queue<Integer> queue = new PriorityQueue<>();
            for (int j = 0; j < K; j++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                String command = st.nextToken();
                int number = Integer.parseInt(st.nextToken());

                if (command.equals("I")) {
                    queue.offer(number);
                } else {
                    if (number < 0) {
                        queue = changeToNaturalOrder(queue);
                        queue.poll();
                    } else {
                        queue = changeToReverseOrder(queue);
                        queue.poll();
                    }
                }
            }

            if (queue.isEmpty()) {
                System.out.println("EMPTY");
            } else {
                queue = changeToReverseOrder(queue);
                System.out.print(queue.poll() + " ");
                queue = changeToNaturalOrder(queue);
                System.out.print(queue.poll());
            }
        }
    }

    private static Queue<Integer> changeToNaturalOrder(Queue<Integer> queue) {
        List<Integer> tempList = new ArrayList<>(queue);
        queue = new PriorityQueue<>();
        queue.addAll(tempList);

        return queue;
    }

    private static Queue<Integer> changeToReverseOrder(Queue<Integer> queue) {
        List<Integer> tempList = new ArrayList<>(queue);
        queue = new PriorityQueue<>(Comparator.reverseOrder());
        queue.addAll(tempList);

        return queue;
    }
}
