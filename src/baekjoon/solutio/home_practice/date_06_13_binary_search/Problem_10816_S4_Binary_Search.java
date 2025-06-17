package baekjoon.solutio.home_practice.date_06_13_binary_search;

import java.io.*;
import java.util.*;

public class Problem_10816_S4_Binary_Search {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int M = Integer.parseInt(br.readLine());
        int[] givenCards = new int[M];

        StringTokenizer st1 = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            int number = Integer.parseInt(st1.nextToken());
            givenCards[i] = number;
        }

        Arrays.sort(givenCards);

        int N = Integer.parseInt(br.readLine());
        int[] myCards = new int[N];
        StringTokenizer st2 = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            myCards[i] = Integer.parseInt(st2.nextToken());
            int result = findUpperBound(givenCards, myCards[i]) - findLowerBound(givenCards, myCards[i]);
            sb.append(result).append(" ");
        }

        bw.write(sb.toString());

        br.close();
        bw.close();
    }

    private static int findLowerBound(int[] array, int key) {
        int low = 0;
        int high = array.length;
        int mid;

        while (low < high) {
            mid = (low + high) / 2;

            if (array[mid] >= key) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }

        return low;
    }

    private static int findUpperBound(int[] array, int key) {
        int low = 0;
        int high = array.length;
        int mid;

        while (low < high) {
            mid = (low + high) / 2;

            if (array[mid] > key) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }

        return low;
    }
}
