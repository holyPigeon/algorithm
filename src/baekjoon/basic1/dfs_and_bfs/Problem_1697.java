package baekjoon.basic1.dfs_and_bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/*
- theme: 수빈이가 동생을 따라잡을 수 있는 경우의 수중 최단 시간일 때의 시간을 구하라.

- 동생이 수빈보다 뒤에 있는 경우, 즉 k - n > 0 인 경우에는 반드시 순간이동을 사용해야 빠르게 뒤로 갈 수 있다.
    - 순간이동을 통해 뒤로 가다가 n * 2 > k인 시점이 온다면, k - n >= n 인지 확인한다.
        - 만약 2 * n - k < k - n 이라면, 남은 거리가 많으므로 순간이동을 통해 2배 작업을 한 번 더 한 후에 걷기로 -1씩 간다.
        - 만약 2 * n - k >= k - n 이라면, 남은 거리가 적으므로 그냥 걷기로 1씩 간다.
- 동생이 수빈보다 앞에 있는 경우, 즉 k - n < 0 인 경우에는 반드시 걷기를 사용해야 -1씩 앞으로 갈 수 있다.
- 이 모든 작업은 k == n 이 될 때까지 지속된다.
 */

/*
- 그냥 야매로 풀지 않았더니 답이 맞지 않는다.. 각 분기마다 가능한 선택을 모두 조사해봄으로써 최단 시간을 알아내고자 한다.
- 예를 들어 수빈이의 위치는 5, 동생의 위치는 17 이라 친다.
- 각 위치까지의 도달 방법을 전수 조사하고, 그 중에서 최단 시간 도달 방법을 찾는다.
    - 예를 들어 5에서 이동하는 경우의 수는 순간이동 -> 10, 걷기 -> 6, 4 으로 총 3가지이다.
    - 해당 3개의 분기에서 다시 3가지 이동을 적용하는 방식을 반복하여 n == k가 될 때까지 무한 반복한다.
    5 -> 10, 6, 4
    10 -> 20, 11, 9 + 6 -> 12, 7, 5 + 4 -> 8, 5, 3
    이 때 먼저 방문한 곳들은 visit 처리를 해서 항상 해당 숫자까지 도달하는 time 이 최소임을 보장한다.
 */

public class Problem_1697 {

    static int n, k;
    static int time = 0;
    static int[] shortestTime = new int[100_001];
    static boolean[] isVisited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        isVisited = new boolean[k + 1];

        // logic
        for (int i = n; i <= k; i++) {
            if (!isVisited[i]) {
                dfs(i);
            }
        }

        System.out.println(time);
    }

    private static void dfs(int n) {
        if (isVisited[n]) {
            return;
        }
        isVisited[n] = true;
        time++;
        int nextNumber1 = 2 * n; // 순간이동
        int nextNumber2 = n + 1; // 걷기 + 1
        int nextNumber3 = n - 1; // 걷기 - 1
        int[] nextNumber = new int[]{nextNumber1, nextNumber2, nextNumber3};

        for (int i = 0; i < 3; i++) {
            if (nextNumber[i] < 0 || nextNumber[i] > 100_000) {
                continue;
            }
            if (!isVisited[nextNumber[i]]) {
                dfs(nextNumber[i]);
            }
        }

    }

    private static void solution(int n, int k) {
        if (k - n > 0) { // 동생이 수빈보다 뒤
            if (n == 0) {
                if (k == 0) {
                    System.out.println(0);
                    return;
                }
                n++;
                time++;
            }
            while (n * 2 < k) { // 최대한 동생에게 가까워지도록 순간이동한다.
                n *= 2;
                time++;
            }
            if (2 * n - k < k - n) { // 동생보다 뒤로 간다음 -1씩 앞으로 간다. 2 * n - k < k - n
                n *= 2;
                time++;
                while (n != k) {
                    n--;
                    time++;
                }
            } else if (2 * n - k >= k - n) { // 동생보다 앞에서 +1씩 뒤로 간다.
                while (n != k) {
                    n++;
                    time++;
                }
            }
        } else { // 동생이 수빈보다 앞
            while (n != k) {
                n--;
                time++;
            }
        }
    }
}
