package baekjoon.solutio.study.date_06_18;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Problem_10799_S2_Stack {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();

        int depth = 0; //
        int piece = 0; // 총 조각 개수

        for (int i = 0; i < input.length(); i++) {
            char ch = input.charAt(i);
            if (ch == '(') {
                if (input.charAt(i + 1) == ')') { // 레이저가 있다면, depth 만큼 조각 개수를 늘리며, 다음 반복은 스킵한다.
                    piece += depth;
                    i++;
                } else { // 레이저가 없다면 depth 를 늘린다.
                    depth++;
                }
            } else if (ch == ')') { // 닫는 괄호가 나오면 depth 를 줄이고, 조각을 추가로 늘린다.
                depth--;
                piece++;
            }
        }

        System.out.println(piece);
    }
}
