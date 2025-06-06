package baekjoon.study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 1. map을 101 크기로 만들어서 가운데서 시작
 * 2. 커맨드에 따라 움직일 때마다 최대 최소를 갱신해서 경계를 만듬
 * 3.
 */

public class Problem_1347 {

    static int direction = 1; // south 1 / west 2 / north 3 / east 4
    static String[][] map = new String[50][50];
    static int x = 0, y = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String[] commands = br.readLine().split("");
        for (int i = 0; i < n; i++) {
            System.out.print(commands[i] + " ");
        }

        for (int i = 0; i < n; i++) {
            if (commands[i].equals("F")) {
                moveForward();
            }
            if (commands[i].equals("R")) {
                turnRight();
            }
            if (commands[i].equals("L")) {
                turnLeft();
            }
        }

        for (int i = 0; i < 50; i++) {
            for (int j = 0; j < 50; j++) {
                System.out.print(map[i][j]);
            }
            System.out.println();
        }
    }

    public static void moveForward() {
        if (direction == 1) {
            // south
            y--;
        }
        if (direction == 2) {
            // west
            x--;
        }
        if (direction == 3) {
            // north
            y++;
        }
        if (direction == 4) {
            // east
            x++;
        }
        map[x][y] = "*";
    }

    public static void turnRight() {
        if (direction == 4) {
            direction = 1;
        } else {
            direction++;
        }
    }

    public static void turnLeft() {
        if (direction == 1) {
            direction = 4;
        } else {
            direction--;
        }
    }
}
