package baekjoon.basic1.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
- theme: 카약을 빌려줄 수 있는 팀들이 인접 팀에 빌려준다 쳤을 때, 출발을 못하는 팀은 최소 몇 팀인지 구하자.

- 카약이 손상된 팀들을 순회하면서 각 팀의 번호 +1 or -1이 여분 카약 팀 리스트에 포함되어 있는지 확인한다.
    - 포함되어 있다면, 카약을 준다
        - 다만 카약 개수가 2면 주고, 2보다 적으면 못 준다.
 */

public class Problem_2891 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    }
}
