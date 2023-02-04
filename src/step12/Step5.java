package step12;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// n은 10000 이하의 숫자
// 적어도 6이 연속 3개 들어가야 함 -> 666, 6666...
// 경우의 수는 다음과 같음 -> 6661, 6662, 6663 / 666, 16661, 26662 / 1666, 2666, 3666

// 연속된 6의 집합이 앞 쪽에 오는 경우

// 연속된 6의 집합이 가운데에 오는 경우

// 연속된 6의 집합이 뒤 쪽에 오는 경우

// 위의 유형 중 2개 이상이 합쳐진 경우

public class Step5 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int sequence = Integer.parseInt(br.readLine());

    String resultNum;


  }
}
