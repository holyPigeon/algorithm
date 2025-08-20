package baekjoon.solutio.study.date_08_06;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class Problem_6603_S2_Recursion {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int K = Integer.parseInt(st.nextToken());
            if (K == 0) {
                break;
            }

            TreeSet<Integer> numbers = new TreeSet<>();
            for (int i = 0; i < K; i++) {
                numbers.add(Integer.parseInt(st.nextToken()));
            }

            System.out.println(numbers);
        }
    }
}
