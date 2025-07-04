package baekjoon.solutio.study.date_07_02;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Problem_10816_S4_Binary_Search {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        int[] numbers = new int[N];

        StringTokenizer st1 = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            numbers[i] = Integer.parseInt(st1.nextToken());
        }
        Arrays.sort(numbers);

        int M = Integer.parseInt(br.readLine());
        StringTokenizer st2 = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            int key = Integer.parseInt(st2.nextToken());
            int count = upperBound(numbers, key) - lowerBound(numbers, key);
            sb.append(count).append(" ");
        }

        bw.write(sb.toString());

        br.close();
        bw.close();
    }

    private static int lowerBound(int[] arr, int key) {
        int low = 0;
        int high = arr.length;
        int mid;

        while(low < high) {
            mid = (low + high) / 2;

            if (arr[mid] < key) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }

        return high;
    }

    private static int upperBound(int[] arr, int key) {
        int low = 0;
        int high = arr.length;
        int mid;

        while(low < high) {
            mid = (low + high) / 2;

            if (arr[mid] <= key) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }

        return high;
    }
}
