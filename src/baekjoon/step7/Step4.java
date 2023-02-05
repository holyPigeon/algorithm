package baekjoon.step7;

import java.io.*;
import java.util.StringTokenizer;

public class Step4 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    String str = br.readLine();
    StringTokenizer st = new StringTokenizer(str, " ");
    int a = Integer.parseInt(st.nextToken());
    int b = Integer.parseInt(st.nextToken());
    int v = Integer.parseInt(st.nextToken());
    int day;

//     처리 시간 비효율적
//        while(sum > 0) {
//      day++;
//      sum -= a;
//      if (sum == 0) {
//        break;
//      }
//      sum += b;
//    }

    // 2 1 5 의 경우 2 1 3 2 4 3 5 -> 1씩(a-b) 3번 오르고 2만큼(a) 남은 시점 한 번을 더해서 4번째에 올라옴

    day = (int)Math.ceil((double)(v - a) / (a - b)) + 1; // 1 / 4 + 1 -> 1

//    if ((v - a) < (a - b)) {
//      if (v < a + (a - b)) {
//        extra = 1;
//      }
//      day += extra;
//    }

    bw.write(String.valueOf(day));

    bw.flush();
  }


}
