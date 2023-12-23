package baekjoon.basic1.dynamic_programming_practice;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/*
title: 분할을 구현하는데 1,2,3으로만 분할한다.

- 먼저 처음의 수에서 3 or 2 or 1을 뺀다.
- 이후 뺀 수를 다시 1,2,3으로만 분할한다.
- 따라서 처음 과정을 거치고, 다음부터는 재귀적으로 처리할 수 있다.
- 이 때, 각 수에 대한 분할 경우의 수는 모두 공통적이기 때문에 저장한 값을 활용할 수 있다. -> DP
 */

public class Problem_15988 {

    static int count = 0;

    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();


    }

    public static void division(int number, int piece) {
        int restNumber = number - piece;
        piece--;
        count++;
    }
}
