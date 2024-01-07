package baekjoon.basic1.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
theme: 괄호를 씌워서 최솟값으로 만들 수 있는 상황을 만들자.

- "-"가 등장하고 나서부터 + 연산들을 모두 더한 값을 max로 지정, 그 중 가장 큰 값을 괄호를 씌우는 영역으로 지정한다.
- "-"를 기준으로 Tokenizer를 통해 나눈 다음, 해당 토큰들 중 합이 가장 큰 것을 고른다.
    각 토큰들의 합을 구할 때는, "+"를 기준으로 Tokenizer를 통해 나눠서 구한다.
 */

public class Problem_1541 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    }
}
