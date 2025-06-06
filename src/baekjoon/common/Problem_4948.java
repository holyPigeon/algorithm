package baekjoon.common;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Problem_4948 {

    static boolean[] isPrime = new boolean[123456 * 2 + 1];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        Arrays.fill(isPrime, true);
        getPrimeNumbers();

        while (true) {
            int n = Integer.parseInt(br.readLine());

            if (n == 0) {
                break;
            }

            int count = 0;
            for (int i = n + 1; i <= n * 2; i++) {
                if (isPrime[i]) {
                    count++;
                }
            }

            System.out.println(count);
        }

    }

    static void getPrimeNumbers() {
        isPrime[0] = isPrime[1] = false; // 0과 1은 소수가 아니니깐 false

        for(int i = 2; i <= Math.sqrt(isPrime.length); i++){ // 2부터 n의 제곱근까지의 모든 수를 확인
            if(isPrime[i]){ // 해당수가 소수라면, 해당수를 제외한 배수들을 모두 false 처리하기
                for(int j = i*i; j<= isPrime.length; j += i){//그 이하의 수는 모두 검사했으므로 i*i부터 시작
                    isPrime[j] = false;
                }
            }
        }
    }
}
