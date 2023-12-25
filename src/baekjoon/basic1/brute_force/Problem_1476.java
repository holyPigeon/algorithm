package baekjoon.basic1.brute_force;

import java.io.*;

public class Problem_1476 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int e, s, m;
        int x = 0, y = 0, z = 0;
        int year = 0;

        String input = br.readLine();
        String[] numbers = input.split(" ");
        e = Integer.parseInt(numbers[0]);
        s = Integer.parseInt(numbers[1]);
        m = Integer.parseInt(numbers[2]);

        while (true) {
            x++;
            if (x == 16) {
                x = 1;
            }
            y++;
            if (y == 29) {
                y = 1;
            }
            z++;
            if (z == 20) {
                z = 1;
            }
            year++;
            if (x == e && y == s && z == m) {
                break;
            }
        }

        System.out.println(year);
    }
}
