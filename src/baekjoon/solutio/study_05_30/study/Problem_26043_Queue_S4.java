package baekjoon.solutio.study_05_30.study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Problem_26043_Queue_S4 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Queue<int[]> queue = new LinkedList<>();

        List<Integer> A = new ArrayList<>();
        List<Integer> B = new ArrayList<>();
        List<Integer> C = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int menu = Integer.parseInt(st.nextToken());

            if (menu == 1) { // 정해진 학생이 식사를 하기 위해 줄을 선다.
                int studentNumber = Integer.parseInt(st.nextToken());
                int menuNumber = Integer.parseInt(st.nextToken());

                queue.offer(new int[]{studentNumber, menuNumber});
            }
            if (menu == 2) { // 식사를 시킨다
                int menuNumber = Integer.parseInt(st.nextToken());

                int[] student = queue.poll();
                int studentNumber = student[0];
                int studentMenuNumber = student[1];

                if (studentMenuNumber == menuNumber) {
                    A.add(studentNumber);
                } else {
                    B.add(studentNumber);
                }
            }
        }

        while (!queue.isEmpty()) {
            int[] student = queue.poll();
            int studentNumber = student[0];

            C.add(studentNumber);
        }

        printStudents(A);
        printStudents(B);
        printStudents(C);
    }

    private static void printStudents(List<Integer> students) {
        if (students.isEmpty()) {
            System.out.print("None");
        } else {
            Collections.sort(students);
            for (Integer i : students) {
                System.out.print(i + " ");
            }
        }
        System.out.println();
    }
}
