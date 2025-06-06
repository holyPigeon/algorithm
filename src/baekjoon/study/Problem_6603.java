package baekjoon.study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Problem_6603 {

    static int [] selected;
    static int count;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        List<int[]> list = new ArrayList<>();

        // input
        int n = -1;
        do {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            n = Integer.parseInt(st.nextToken());
            int[] numbers = new int[n];
            for (int i = 0; i < n; i++) {
                String s = st.nextToken();
                numbers[i] = Integer.parseInt(s);
            }
            list.add(numbers);
        } while (n != 0);

        // logic
        // n개의 숫자가 있다면 -> n-6개의 숫자를 차례대로 빼고, 나머지를 순서대로 나열
        for (int i = 0; i < list.size(); i++) {
            int[] numbers = list.get(i);
            int length = numbers.length;
            selected = new int[6];
            makeCombination(numbers, 6, 0, 0);
            for (int j = 0; j < count; j++) {
                for (int k = 0; k < 6; k++) {
                    System.out.print(selected[k] + " ");
                }
                System.out.println();
            }
            System.out.println();
        }
    }

    static void makeCombination(int[] arr, int R, int cnt, int start) {
        if(cnt==R) {
            count++;
            System.out.println(Arrays.toString(selected));
        }else {
            for(int i=start;i<arr.length;i++) {
                selected[cnt]=arr[i];
                makeCombination(arr, R, cnt+1, i+1); //i+1이 핵심
            }
        }
    }
}
