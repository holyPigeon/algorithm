package baekjoon.basic1.data_structure_1;

import java.io.*;
import java.util.Stack;

/*
title: 주어진 문자열에 따라 레이저로 잘린 쇠막대기의 조각 개수를 구하라

- () ((( () () )( () ) () ))( () )
- 왼쪽 괄호가 늘어난다면 막대가 추가되는 것
    - 여기서 레이저 커팅이 들어가면 괄호가 끝나기 전, 최소 막대 개수 * (통과한 레이저 + 1) 개의 조각이 나온다.
    - 더 이상 레이저가 추가되지 않고 괄호가 닫힌 경우, 해당 막대의 조각은 늘어나지 않는다.
- 레이저와 막대를 구분하는 방법
    - 연속된 () 쌍이 나온 경우, 레이저로 구분한다.
    - (가 두등등장한 경우, 다음 나올 괄호는 ( 또는 ) 이다.
        - (가 등장한 경우, 레이저가 아니므로 그 다음에 )가 나올 가능성만 열어둔다.
        - )가 등장한 경우, 이것은 레이저다. 그 다음에 )가 나오면 막대 - 1을 하고, (가 나오면 막대 또는 레이저 2개의 가능성을 가짐
 */

public class Problem_10799 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        String input = br.readLine();
        Stack<String> stack = new Stack<>();
        boolean isReadyForLaser = false; // 레이저가 될 가능성이 있는지
        int stickCount = 0; // 중첩된 막대기 수
        int laserCount = 0; // 중첩된 레이저 개수
        int splitCount = 0;

        for (int i = 0; i < input.length(); i++) {
            char bracket = input.charAt(i);

            if (bracket == '(') { // (가 나온 경우, 막대기 개수를 추가하며 다음 문자가 레이저일 경우를 대비하여 isReadyForLaser -> true 로 한다.
                stickCount++;
                isReadyForLaser = true;
            }

            if (bracket == ')') {
                if (isReadyForLaser) { // 레이저 개수를 추가한다.
                    stickCount--;
                    laserCount++;
                    isReadyForLaser = false;
                    splitCount += stickCount * laserCount;
                    laserCount--;
                } else if (!isReadyForLaser) { // 괄호가 닫히면서 레이저에 쪼개질 막대가 하나 사라진다.
                    stickCount--;
                    splitCount++;
                }
            }
        }

        bw.write(String.valueOf(splitCount));
        bw.close();
        br.close();
    }
}
