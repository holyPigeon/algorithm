package baekjoon.solutio.study.date_06_18;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Problem_13335_S1_Queue {
    static int N;
    static int W;
    static int L;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st1 = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st1.nextToken());
        W = Integer.parseInt(st1.nextToken());
        L = Integer.parseInt(st1.nextToken());

        StringTokenizer st2 = new StringTokenizer(br.readLine());
        Queue<Truck> trucks = new LinkedList<>();

        for (int i = 0; i < N; i++) {
            int load = Integer.parseInt(st2.nextToken());
            trucks.offer(new Truck(load));
        }

        int availableLoad = L;
        int time = 0;

        // 다리의 최대 하중을 넘지 않는 선에서 트럭들을 뽑는다.
        Queue<Truck> crossingTrucks = new LinkedList<>();
        while (!trucks.isEmpty() || !crossingTrucks.isEmpty()) {
            time++;

            // 다음 트럭이 다리에 들어올 수 있다면, 들여보낸다.
            if (!trucks.isEmpty() && isAvailableLoad(availableLoad, trucks.peek())) {
                Truck truck = trucks.poll();
                crossingTrucks.offer(truck);
                availableLoad -= truck.load;
            }

            // 트럭들을 한 칸씩 이동시킨다.
            crossingTrucks.forEach(Truck::move);

            // 다리를 건너는 트럭 중에서 다리 끝에 도달한 트럭이 있는지 검사한다.
            Truck firstTruck = crossingTrucks.peek();
            if (firstTruck.isEndOfBridge()) {
                Truck accrossedTruck = crossingTrucks.poll();

                // 트럭이 다리를 빠져나가면 해당 트럭의 무게만큼 최대하중을 다시 늘린다.
                availableLoad += accrossedTruck.load;
            }
        }

        System.out.println(++time);
    }

    private static boolean isAvailableLoad(int availableLoad, Truck truck) {
        return availableLoad - truck.load >= 0;
    }

    static class Truck {
        int load;
        int distance;

        public Truck(int load) {
            this.load = load;
            this.distance = 0;
        }

        public void move() {
            distance++;
        }

        public boolean isEndOfBridge() {
            return distance == W;
        }
    }
}
