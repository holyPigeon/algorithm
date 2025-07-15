package baekjoon.solutio.study.date_07_11;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Problem_7662_G4_HashMap_Try_2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            int K = Integer.parseInt(br.readLine());

            List<Integer> numbers = new ArrayList<>();
            for (int j = 0; j < K; j++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                String command = st.nextToken();
                int number = Integer.parseInt(st.nextToken());

                if (command.equals("I")) {
                    numbers.add(number);
                } else {
                    if (numbers.isEmpty()) {
                        continue;
                    } else if (number < 0) {
                        numbers.remove(Integer.valueOf(min(numbers)));
                    } else {
                        numbers.remove(Integer.valueOf(max(numbers)));
                    }
                }
            }

            if (numbers.isEmpty()) {
                System.out.println("EMPTY");
            } else {
                System.out.print(max(numbers) + " " + min(numbers));
            }
        }
    }

    private static int max(List<Integer> numbers) {
        return numbers.stream()
                .mapToInt(Integer::intValue)
                .max()
                .orElse(numbers.get(0));
    }

    private static int min(List<Integer> numbers) {
        return numbers.stream()
                .mapToInt(Integer::intValue)
                .min()
                .orElse(numbers.get(0));
    }
}
