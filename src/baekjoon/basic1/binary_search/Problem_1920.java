package baekjoon.basic1.binary_search;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Problem_1920 {

    static int N;
    static int M;
    static int[] numbers;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // init
        N = Integer.parseInt(br.readLine());
        numbers = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            numbers[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(numbers);

        M = Integer.parseInt(br.readLine());

        // logic
        StringTokenizer st2 = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            int numberToCheck = Integer.parseInt(st2.nextToken());
            if (binary_search(numbers, numberToCheck)) {
                System.out.println(1);
            } else {
                System.out.println(0);
            }
        }
    }

    static private boolean binary_search(int[] numbers, int numberToCheck) {
        int low = 0;
        int high = numbers.length - 1;
        int mid;

        while (low <= high) {
            mid = (high + low) / 2;
            if (numberToCheck < numbers[mid]) {
                high = mid - 1;
            } else if (numberToCheck > numbers[mid]) {
                low = mid + 1;
            } else if (numberToCheck == numbers[mid]) {
                return true;
            }
        }

        return false;
    }
}
