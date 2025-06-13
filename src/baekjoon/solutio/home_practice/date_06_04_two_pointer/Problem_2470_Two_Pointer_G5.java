package baekjoon.solutio.home_practice.date_06_04_two_pointer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Problem_2470_Two_Pointer_G5 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        List<Integer> numbers = new ArrayList<>();
        while(st.hasMoreTokens()) {
            int number = Integer.parseInt(st.nextToken());
            numbers.add(number);
        }

        Collections.sort(numbers);

        int left = 0;
        int right = numbers.size() - 1;
        int min = Integer.MAX_VALUE; // 최대 합
        int resultLeft = left;
        int resultRight = right;

        while (left < right) {
            int sum = numbers.get(left) + numbers.get(right);
            int absSum = Math.abs(sum);

            if (absSum < min) {
                resultLeft = left;
                resultRight = right;
                min = absSum;

                if (sum == 0) {
                    break;
                }
            }

            if (sum < 0) {
                left++;
            }
            if (sum > 0) {
                right--;
            }
        }

        System.out.println(numbers.get(resultLeft) + " " + numbers.get(resultRight));
    }
}

// -2 4 -99 -1 98
// -99 -98 -2 -1 4 98 99 100