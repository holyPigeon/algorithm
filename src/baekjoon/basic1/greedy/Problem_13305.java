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
import java.math.BigInteger;

public class Problem_13305 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // init
        int N = Integer.parseInt(br.readLine());

        String[] tokens1 = br.readLine().split(" ");
        BigInteger[] distances = new BigInteger[N - 1];
        for (int i = 0; i < N - 1; i++) {
            distances[i] = new BigInteger(tokens1[i]);
        }

        String[] tokens2 = br.readLine().split(" ");
        BigInteger[] prices = new BigInteger[N];
        for (int i = 0; i < N; i++) {
            prices[i] = new BigInteger(tokens2[i]);
        }

        // logic
        BigInteger cheapPrice = prices[0];
        BigInteger totalPrice = BigInteger.valueOf(0);
        for (int i = 0; i < prices.length; i++) {
            if (i != prices.length - 1) { // 맨 마지막 주유소가 아니라면
                totalPrice = totalPrice.add(cheapPrice.multiply(distances[i])); // 현재까지의 가장 싼 기름값과 이동한 거리를 곱함 -> 총 사용한 기름값
                if (prices[i + 1].compareTo(cheapPrice) < 0) { // 다음 주유소가 지금 주유소보다 싸다면
                    cheapPrice = prices[i + 1];
                }
            }
        }

        System.out.println(totalPrice);
    }
}
