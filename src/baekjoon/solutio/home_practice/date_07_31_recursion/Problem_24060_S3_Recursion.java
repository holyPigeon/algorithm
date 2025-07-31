package baekjoon.solutio.home_practice.date_07_31_recursion;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Problem_24060_S3_Recursion {
    static int K;
    static int[] sorted;
    static int result = -1;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st1 = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st1.nextToken());
        K = Integer.parseInt(st1.nextToken());
        int[] arr = new int[N];
        sorted = new int[N];

        StringTokenizer st2 = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st2.nextToken());
        }

        merge_sort(arr, 0, N - 1);
        System.out.println(result);
    }

    private static void merge_sort(int[] arr, int left, int right) {
        if (left == right) return;
        int mid = (left + right) / 2;

        merge_sort(arr, left, mid);
        merge_sort(arr, mid + 1, right);
        merge(arr, left, mid, right);
    }

    private static void merge(int[] arr, int left, int mid, int right) {
        int l = left;
        int r = mid + 1;
        int index = left;

        while (l <= mid && r <= mid) {
            if (arr[l] < arr[r]) {
                sorted[index] = arr[l];
                index++;
                l++;
            } else {
                sorted[index] = arr[r];
                index++;
                r++;
            }
        }

        if (l > mid) {
            while(r <= right) {
                sorted[index] = arr[r];
                index++;
                r++;
            }
        } else {
            while(l <= mid) {
                sorted[index] = arr[l];
                index++;
                l++;
            }
        }

        for (int i = left; i <= right; i++) {
            arr[i] = sorted[i];
            if (i == K) {
                result = arr[i];
                break;
            }
        }
    }
}
