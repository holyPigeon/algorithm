package baekjoon.basic1.brute_force;

import java.io.*;

/*
theme: 주어진 규칙과 M,N에 따라서 <x, y>는 몇 번째 해인지 구하라.

- x,y가 M,N과 같은 값일 경우에는 다음 해에 x=1, y=1로 초기화된다.
- 그 이외의 경우에는 다음 해에 x,y가 항상 1씩 증가한다.

해가 찾아지는 조건
-> m과 n이 둘 다 짝수일 때 -> 무조건 x y의 차가 짝수
-> m과 n이 둘 다 홀수이지만 차는 짝수일 때 -> x와 y의 차가 무엇이든 상관 X
-> m과 n이 둘 다 홀 수이고 차도 홀수 -> x와 y의 차가 홀수

결론 -> 믹스되면 상관 X 하지만 짝짝짝이거나 홀홀홀인 경우는 제약 발생
 */

public class Problem_6064 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int count = Integer.parseInt(br.readLine());
        for (int i = 0; i < count; i++) {
            String[] numbers = br.readLine().split(" ");
            int m = Integer.parseInt(numbers[0]);
            int n = Integer.parseInt(numbers[1]);
            int targetX = Integer.parseInt(numbers[2]);
            int targetY = Integer.parseInt(numbers[3]);
            int x = 1;
            int y = 1;
            int countResult = 0;
            if (!isAvailable(m, n, targetX, targetY)) {
                System.out.print(-1);
                continue;
            }
            while (true) {
                if (x == targetX && y == targetY) {
                    break;
                }
                if (x == m) {
                    x = 1;
                } else {
                    x++;
                }
                if (y == n) {
                    y = 1;
                } else {
                    y++;
                }
                countResult++;
            }
            System.out.println(countResult + 1);
        }
    }

    public static boolean isAvailable(int m, int n, int targetX, int targetY) {
        if (m % 2 == 0 && n % 2 == 0 && Math.abs(targetX-targetY) % 2 != 0) {
            return false;
        }
        if (m % 2 != 0 && n % 2 != 0 && Math.abs(targetX-targetY) % 2 == 0) {
            return false;
        }
        return true;
    }
}
