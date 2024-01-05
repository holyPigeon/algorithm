package baekjoon.basic1.dfs_and_bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
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

public class Problem_1697 {

    static int n, k;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int time = 0;


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

        time--;
        System.out.println(time);
    }
}
