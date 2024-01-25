package baekjoon.basic1.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Problem_1459 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        long cx = 0;
        long cy = 0;
        long x = Integer.parseInt(st.nextToken());
        long y = Integer.parseInt(st.nextToken());
        long w = Integer.parseInt(st.nextToken());
        long s = Integer.parseInt(st.nextToken());
        boolean possible = false;

        if (2 * w > s) {
            possible = true;
        }


        long result = 0;
        if (possible) { // 대각선 이동이 더 빠르다면
            result += Math.min(x, y) * s;
            long abs = Math.abs(y - x);
            if (abs % 2 != 0 && w > s) {
                result += abs * Math.min(w, s) + Math.abs(w - s);
            } else {
                result += abs * Math.min(w, s);
            }


        } else { // 대각선 이동보다 그냥 가로 세로로 가는 게 더 빠르다면
            result += (x + y) * w;
        }

        System.out.println(result);
    }
}
