package baekjoon.study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Problem_2936 {
    public static void main(String[] args) throws IOException {
        int total = 250 * 250 / 2;

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        double x1 = Double.parseDouble(st.nextToken());
        double y1 = Double.parseDouble(st.nextToken());

        // 이등변 중 하나에 위치함
        double x2 = 0.0;
        double y2 = 0.0;

        if (x1 == 0) {
            if (y1 >= 125) {
                y2 = (total * 2) / (250 - y1);
            } else {
                x2 = total / y1;
            }
        }

        System.out.println(x2 + " " + y2);

//        if (y1 == 0) {
//
//        }
//
//        if (x1 * y1 != 0) {
//
//        }
    }

}
