package baekjoon.solutio.home_practice.date_06_13_binary_search;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Problem_1920_S4 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        int[] myNumbers = new int[N];
        StringTokenizer st1 = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            myNumbers[i] = Integer.parseInt(st1.nextToken());
        }

        Arrays.sort(myNumbers);

        int M = Integer.parseInt(br.readLine());
        StringTokenizer st2 = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            System.out.println(binarySearch(myNumbers, Integer.parseInt(st2.nextToken())));
        }

        bw.write(sb.toString());

        br.close();
        bw.close();

    }

    private static int binarySearch(int[] arr, int key) {
        int low = 0;
        int high = arr.length - 1;
        int mid;

        while (low <= high) {
            mid = (low + high) / 2;

            if (arr[mid] == key) {
                return 1;
            } else if (arr[mid] > key) {
                high = mid;
            } else if (arr[mid] < key) {
                low = mid + 1;
            }
        }

        return 0;
    }
}
