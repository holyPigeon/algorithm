package baekjoon.class3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * 요약: 규칙에 따라 계단을 올라갈 때, 가장 많은 점수를 얻을 수 있는 경우의 수를 찾아 그 최대 점수를 구하라.
 * 규칙:
 * 1, 2칸 올라가기 가능
 * 연속 3개는 못 밝음 -> count = 3은 안됨
 * 마지막 계단은 꼭! 밟아야 함
 */

public class Problem_2579 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[] stairs = new int[n];
        for (int i = 0; i < n; i++) {
            stairs[i] = Integer.parseInt(br.readLine());
        }

        List<Integer> visited = new ArrayList<>();
        int resultSum = 0; // 결과로 반환할 최대 합계 점수
        int expectedSum = 0; // 예상되는 합계 점수
        int count = 0; // 연속해서 밟은 계단의 수

        for (int i = 0; i < n; i++) {
            if (i != 0) { // 현재
                if (visited.contains(i)) { // 이전 계단을 밟았을 경우
                    count++;
                } else {
                    count = 0;
                }
            }
        }
    }

    public boolean isContinuous(int count) {
        return count == 3;
    }
}
