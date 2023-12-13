package baekjoon.basic1.data_structure_1;

import java.io.*;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

/*
- 큐의 기능을 구현한다.
- 그냥 큐 자료형을 사용하면 편할 듯
 */

public class Problem_10845 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        Deque<Integer> deque = new LinkedList<>();
        int count = Integer.parseInt(br.readLine());

        for (int i = 0; i < count; i++) {
            String[] tokens = br.readLine().split(" ");
            String command = tokens[0];
            if (command.equals("push")) {
                int number = Integer.parseInt(tokens[1]);
                deque.offerLast(number);
            }
            if (command.equals("pop")) {
                if (deque.isEmpty()) {
                    bw.write("-1\n");
                }
                if (!deque.isEmpty()) {
                    bw.write(deque.pollFirst() + "\n");
                }
            }
            if (command.equals("size")) {
                bw.write(deque.size() + "\n");
            }
            if (command.equals("empty")) {
                if (deque.isEmpty()) {
                    bw.write("1\n");
                }
                if (!deque.isEmpty()) {
                    bw.write("0\n");
                }
            }
            if (command.equals("front")) {
                if (deque.isEmpty()) {
                    bw.write("-1\n");
                }
                if (!deque.isEmpty()) {
                    bw.write(deque.peekFirst() + "\n");
                }
            }
            if (command.equals("back")) {
                if (deque.isEmpty()) {
                    bw.write("-1\n");
                }
                if (!deque.isEmpty()) {
                    bw.write(deque.peekLast() + "\n");
                }
            }
        }

        bw.close();
        br.close();
    }
}
