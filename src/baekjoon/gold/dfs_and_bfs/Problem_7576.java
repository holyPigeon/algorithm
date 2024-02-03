package baekjoon.gold.dfs_and_bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/*
theme: 상자 안의 토마토가 모두 익는 최소 일수를 구하시오.

- 솔직히 첫인상: 그냥 전 토마토 문제 하위호환 같음. 똑같이 bfs 쓰면 되는 거 아닌가? -> 일단 풀어보고 안되면 다른 방법 찾기
    - 예상 풀이방법 -> map 배열을 만들고 전 좌표 + 1씩 해서 일 수를 구함 (0인 곳만 가기)
 */

public class Problem_7576 {

    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};
    static int n;
    static int m;
    static int[][] map;
    static Queue<int[]> queue = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    }
}
