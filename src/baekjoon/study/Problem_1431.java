package baekjoon.study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Problem_1431 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        String[] serialNumbers = new String[n];

        for (int i = 0; i < n; i++) {
            serialNumbers[i] = br.readLine();
        }

        List<String> result = Arrays.stream(serialNumbers)
                .sorted(Comparator.comparingInt(String::length)
                        .thenComparing(s -> sumOfDigits(s))
                        .thenComparing(Comparator.naturalOrder())
                ).collect(Collectors.toList());

        for (int i = 0; i < n; i++) {
            System.out.println(result.get(i));
        }
    }

    public static int sumOfDigits(String serialNumber) {
        int sum = 0;

        for (int i = 0; i < serialNumber.length(); i++) {
            char c = serialNumber.charAt(i);
            if (Character.isDigit(c)) {
                sum += Character.getNumericValue(c);
            }
        }

        return sum;
    }
}
