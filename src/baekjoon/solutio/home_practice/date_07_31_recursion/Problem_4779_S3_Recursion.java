package baekjoon.solutio.home_practice.date_07_31_recursion;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Problem_4779_S3_Recursion {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input;

        while ((input = br.readLine()) != null) {
            int N = Integer.parseInt(input);
            String line = "-".repeat((int)Math.pow(3, N));

            System.out.println(makeBlank(line, N));
        }
    }

    private static String makeBlank(String input, int n) {
        if (input.length() == 1) {
           return input;
        }
        String first = input.substring(0, input.length() / 3);
        String second = " ".repeat((int)Math.pow(3, n - 1.0));
        String third = input.substring(2 * input.length() / 3);


        String s = makeBlank(first, n - 1) + second + makeBlank(third, n - 1);
        return s;
    }
}
