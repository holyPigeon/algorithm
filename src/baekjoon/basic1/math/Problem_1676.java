package baekjoon.basic1.math;

import java.util.Scanner;

public class Problem_1676 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int num = in.nextInt();
        int count = 0;

        while (num >= 5) {
            count += num / 5;
            num /= 5;
        }
        System.out.println(count);
    }
}