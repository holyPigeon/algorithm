package baekjoon.basic1.greedy;

/*
theme: 각 주유소마다 기름 가격이 다른데, 제일 저렴하게 맨 왼쪽에서 오른쪽까지 갈 수 있는 비용을 구하자.

- 알고보면 존1나 간단한 원리
    - 그냥 앞으로 갈 길에 현재 주유소보다 싼 주유소가 있으면, 거기 갈 만큼의 기름만 채우고 거기로 감.
    - 그러다가 맨 오른쪽까지 오면 기름값 계산 끝

- 여태까지 제일 싼 곳으로 픽한 주유소의 기름 값을 저장해서 이동한 거리와 곱한다.
- 만약 더 싼 주유소가 나온다면 그곳의 기름값을 대입한다.
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Problem_13305 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    }
}
