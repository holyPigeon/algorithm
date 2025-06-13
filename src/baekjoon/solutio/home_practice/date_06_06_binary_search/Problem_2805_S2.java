package baekjoon.solutio.home_practice.date_06_06_binary_search;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Problem_2805_S2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] numbers = new int[N];
        StringTokenizer st1 = new StringTokenizer(br.readLine());
        int max = 0;
        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = Integer.parseInt(st1.nextToken());
            if (numbers[i] > max) {
                max = numbers[i];
            }
        }

        int result = binarySearch(numbers, 0, max, M);

        System.out.println(result - 1);
    }

    private static int binarySearch(int[] numbers, int low, int high, int M) {
        int mid;
        while (low < high) {
            mid = (low + high) / 2;
            long sum = getSum(numbers, mid);

            if (sum < M) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }

        return low;
    }

    private static long getSum(int[] numbers, int height) {
        long sum = 0;
        for (int number : numbers) {
            int diff = number - height;
            if (diff > 0) {
                sum += diff;
            }
        }

        return sum;
    }
}
