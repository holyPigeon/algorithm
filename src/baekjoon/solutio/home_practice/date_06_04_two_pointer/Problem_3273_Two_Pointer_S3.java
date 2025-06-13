package baekjoon.solutio.home_practice.date_06_04_two_pointer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Problem_3273_Two_Pointer_S3 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int X = Integer.parseInt(br.readLine());

        List<Integer> numbers = new ArrayList<>();
        while(st.hasMoreTokens()) {
            int number = Integer.parseInt(st.nextToken());
            numbers.add(number);
        }

        Collections.sort(numbers);

        int left = 0;
        int right = numbers.size() - 1;
        int count = 0;

        while (left < right) {
            int sum = numbers.get(left) + numbers.get(right);

            if (sum == X) {
                left++;
                right--;
                count++;
            }
            if (sum < X) {
                left++;
            }
            if (sum > X) {
                right--;
            }
        }

        System.out.println(count);
    }
}

// 1 2 3 5 7 9 10 11 12
