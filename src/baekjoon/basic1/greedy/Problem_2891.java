package baekjoon.basic1.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
- theme: 카약을 빌려줄 수 있는 팀들이 인접 팀에 빌려준다 쳤을 때, 출발을 못하는 팀은 최소 몇 팀인지 구하자.

- 카약이 손상된 팀들을 순회하면서 각 팀의 번호 +1 or -1이 여분 카약 팀 리스트에 포함되어 있는지 확인한다.
    - 포함되어 있다면, 카약을 준다
        - 다만 카약 개수가 2면 주고, 2보다 적으면 못 준다.
 */

public class Problem_2891 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int S = Integer.parseInt(st.nextToken());
        int R = Integer.parseInt(st.nextToken());
        int[] kayakCounts = new int[N];
        for (int i = 0; i < N; i++) {
            kayakCounts[i] = 1;
        }

        // 카약이 부서진 팀은 카약 개수가 0
        StringTokenizer st2 = new StringTokenizer(br.readLine());
        for (int i = 0; i < S; i++) {
            kayakCounts[Integer.parseInt(st2.nextToken()) - 1]--;
        }

        // 여분 카약이 있는 팀은 카약 개수가 2
        StringTokenizer st3 = new StringTokenizer(br.readLine());
        for (int i = 0; i < R; i++) {
            kayakCounts[Integer.parseInt(st3.nextToken()) - 1]++;
        }

        // logic
        for (int i = 0; i < N; i++) {
            if (kayakCounts[i] == 0) {
                if (i != 0) {
                    if (kayakCounts[i - 1] == 2) { // 앞 팀이 여분이 있다면 받기 (내가 맨 앞이면 제외)
                        kayakCounts[i - 1]--;
                        kayakCounts[i]++;
                    }
                }
                if (i != N - 1) {
                    if (kayakCounts[i + 1] == 2) { // 뒷 팀이 여분이 있다면 받기 (내가 맨 뒤면 제외)
                        kayakCounts[i + 1]--;
                        kayakCounts[i]++;
                    }
                }
            }
        }

        // result
        int count = 0;
        for (int i = 0; i < N; i++) {
            if (kayakCounts[i] == 0) {
                count++;
            }
        }

        System.out.println(count);
    }
}
