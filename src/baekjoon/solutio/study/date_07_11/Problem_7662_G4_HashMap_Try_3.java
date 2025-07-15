package baekjoon.solutio.study.date_07_11;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Problem_7662_G4_HashMap_Try_3 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            int K = Integer.parseInt(br.readLine());

            TreeMap<Integer, Integer> numbers = new TreeMap<>();
            for (int j = 0; j < K; j++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                String command = st.nextToken();
                int number = Integer.parseInt(st.nextToken());

                if (command.equals("I")) {
                    numbers.put(number, numbers.getOrDefault(number, 0) + 1);
                } else {
                    int removeNum;
                    if (numbers.isEmpty()) {
                        continue;
                    } else if (number < 0) {
                        removeNum = numbers.firstKey();
                    } else {
                        removeNum = numbers.lastKey();
                    }

                    if (numbers.put(removeNum, numbers.get(removeNum) - 1) == 1) {
                        numbers.remove(removeNum);
                    }
                }
            }

            if (numbers.isEmpty()) {
                System.out.println("EMPTY");
            } else {
                System.out.println(numbers.lastKey() + " " + numbers.firstKey());
            }
        }
    }
}
