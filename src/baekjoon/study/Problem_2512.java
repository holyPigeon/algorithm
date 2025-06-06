package baekjoon.study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Problem_2512 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = readNumberCount(br);
        List<Integer> budgets = readBudgets(br, n);
        int givenBudget = readTotalBudget(br);

        int totalBudgetRequest = budgets.stream().mapToInt(Integer::intValue).sum();
        int averageBudget = givenBudget / n;
        int lack = totalBudgetRequest - givenBudget;

        if (lack >= 0) {
            int exceededBudgetCount = (int) budgets.stream()
                    .filter(budget -> budget > averageBudget)
                    .count();

            int exceededBudgetSum = budgets.stream()
                    .filter(budget -> budget > averageBudget)
                    .mapToInt(Integer::intValue)
                    .sum();

            int maximumBudget = (exceededBudgetSum - lack) / exceededBudgetCount;

            System.out.println(maximumBudget);
        } else {
            int maximumBudget = budgets.stream().max(Integer::compareTo).orElse(0);
            System.out.println(maximumBudget);
        }
    }

    private static int readNumberCount(BufferedReader br) throws IOException {
        return Integer.parseInt(br.readLine());
    }

    private static List<Integer> readBudgets(BufferedReader br, int n) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        List<Integer> budgets = new ArrayList<>(n);
        for (int i = 0; i < n; i++) {
            budgets.add(Integer.parseInt(st.nextToken()));
        }

        return budgets;
    }

    private static int readTotalBudget(BufferedReader br) throws IOException {
        return Integer.parseInt(br.readLine());
    }
}
