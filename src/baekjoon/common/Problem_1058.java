package baekjoon.common;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Problem_1058 {

    static String[][] isFriend;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // init
        int n = Integer.parseInt(br.readLine());
        isFriend = new String[n][n];

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), "");
            for (int j = 0; j < n; j++) {
                isFriend[i][j] = st.nextToken();
            }
        }

        // logic
        // 1번 사람의 경우
        // 1, 2와 1, 3이 Y인 경우, 2, 3도 Y인지 확인

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (isFriend[i][j] == "Y") {
                    //
                }
            }
        }

    }
}
