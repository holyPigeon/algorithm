package baekjoon.basic1.brute_force;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/*
theme: 리모컨으로 채널 이동을 하려는데 리모컨이 고장났다.

- 고장난 숫자 버튼을 토대로 해당 버튼을 사용하지 않고 몇 번 버튼을 눌러야 N에 도달할 수 있는지 알아낸다.
 */

public class Problem_1107 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int initialChannel = 100;
        int count = 0;
        int n;

        n = Integer.parseInt(br.readLine()); // n 입력
        List<Integer> availableButtons = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            availableButtons.add(i);
        }

        int brokenButtonCount = Integer.parseInt(br.readLine());
        String[] brokenButtons = br.readLine().split(" ");

        for (int i = 0; i < brokenButtonCount; i++) {
            availableButtons.remove(Integer.valueOf(Integer.parseInt(brokenButtons[i])));
        }

        if (n != initialChannel) {
            count = (n - findClosestNumber(availableButtons, n)) + String.valueOf(n).length();
        }

        System.out.println(count);
        br.close();
    }

    public static int findClosestNumber(List<Integer> availableButtons, int targetNumber) {
        int closestNumber = 0;
        int minDifference = Integer.MAX_VALUE;

        // 0부터 9까지 사용 가능한 숫자로 만들 수 있는 경우의 수 계산
        for (int i = 0; i < (1 << availableButtons.size()); i++) {
            int currentNumber = getNumberFromSubset(availableButtons, i);
            int difference = Math.abs(targetNumber - currentNumber);

            if (difference < minDifference) {
                minDifference = difference;
                closestNumber = currentNumber;
            }
        }

        return closestNumber;
    }

    public static int getNumberFromSubset(List<Integer> availableDigits, int subset) {
        int number = 0;
        for (int i = 0; i < availableDigits.size(); i++) {
            if ((subset & (1 << i)) != 0) {
                number = number * 10 + availableDigits.get(i);
            }
        }
        return number;
    }
}
