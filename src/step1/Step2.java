package step1;

import java.util.Scanner;

public class Step2 {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    System.out.println("첫 번째 숫자 입력");
    int x1 = scanner.nextInt();
    System.out.println("두 번째 숫자 입력");
    int x2 = scanner.nextInt();

    System.out.println(x1 + x2);
  }
}