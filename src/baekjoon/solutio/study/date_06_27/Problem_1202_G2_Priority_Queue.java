package baekjoon.solutio.study.date_06_27;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Problem_1202_G2_Priority_Queue {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st1 = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st1.nextToken());
        int K = Integer.parseInt(st1.nextToken());

        List<Gem> gems = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            StringTokenizer st2 = new StringTokenizer(br.readLine());
            int weight = Integer.parseInt(st2.nextToken());
            int price = Integer.parseInt(st2.nextToken());

            gems.add(new Gem(weight, price));
        }
        gems.sort((a, b) -> {
            if (a.weight == b.weight) { // 서로 무게가 같다면 비싼 보석 뽑기
                return b.price - a.price;
            } else { // 서로 무게가 다르다면 가벼운 보석 뽑기
                return a.weight - b.weight;
            }
        });

        // 가벼운 가방부터 뽑는다.
        List<Bag> bags = new ArrayList<>();
        for (int i = 0; i < K; i++) {
            int availableWeight = Integer.parseInt(br.readLine());

            bags.add(new Bag(availableWeight));
        }
        bags.sort(Comparator.comparingInt(a -> a.availableWeight));

        long sum = 0;
        int gemIndex = 0;
        PriorityQueue<Gem> candidates = new PriorityQueue<>((a, b) -> b.price - a.price);
        for (int i = 0; i < K; i++) {
            Bag bag = bags.get(i);
            while (gemIndex < N && gems.get(gemIndex).weight <= bag.availableWeight) {
                candidates.offer(gems.get(gemIndex));
                gemIndex++;
            }
            if (!candidates.isEmpty()) {
                sum += candidates.poll().price;
            }
        }

        System.out.println(sum);
    }

    private static class Gem {
        int weight;
        int price;

        public Gem(int weight, int price) {
            this.weight = weight;
            this.price = price;
        }
    }

    private static class Bag {
        int availableWeight;

        public Bag(int availableWeight) {
            this.availableWeight = availableWeight;
        }
    }
}
