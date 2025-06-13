package baekjoon.solutio.study.date_05_28_implementation.practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Problem_26043_Queue_S4 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());

        List<Integer> A = new ArrayList<>();
        List<Integer> B = new ArrayList<>();
        List<Integer> C = new ArrayList<>();

        Queue<int[]> queue = new LinkedList<>();

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int type = Integer.parseInt(st.nextToken());

            if (type == 1) {
                int number = Integer.parseInt(st.nextToken());
                int menu = Integer.parseInt(st.nextToken());

                queue.offer(new int[]{number, menu});
            }
            if (type == 2) {
                int menu = Integer.parseInt(st.nextToken());

                int[] student = queue.poll();
                int number = student[0];
                int preferredMenu = student[1];

                if (menu == preferredMenu) {
                    A.add(number);
                } else {
                    B.add(number);
                }
            }
        }

        while (!queue.isEmpty()) {
            C.add(queue.poll()[0]);
        }

        if (A.isEmpty()) {
            sb.append("None");
        } else {
            Collections.sort(A);
            for (Integer integer : A) {
                sb.append(integer).append(" ");
            }
        }
        sb.append("\n");
        if (B.isEmpty()) {
            sb.append("None");
        } else {
            Collections.sort(B);
            for (Integer integer : B) {
                sb.append(integer).append(" ");
            }
        }
        sb.append("\n");
        if (C.isEmpty()) {
            sb.append("None");
        } else {
            Collections.sort(C);
            for (Integer integer : C) {
                sb.append(integer).append(" ");
            }
        }

        System.out.print(sb);
    }
}
