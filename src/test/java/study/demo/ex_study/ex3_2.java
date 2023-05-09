package study.demo.ex_study;

import java.util.Scanner;

/** 배열의 이해
 *  가장 작은 값부터 순서대로 정렬하기
 *  키보드로 10000미만의 10개 숫자를 입력받아, 가장 작은 숫자부터 정렬하여 출력하기
 */
public class ex3_2 {
    final static int ARRAY_MAX = 10;
    final static int CHECK = 10000;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int inputData = 0;

        int[] dataArray = new int[ARRAY_MAX];
        int[] sortArray = new int[ARRAY_MAX];
        int count = 0;

        while (true) {
            System.out.print("input : ");
            inputData = sc.nextInt();
            dataArray[count++] = inputData;

            if (count >= ARRAY_MAX) {
                System.out.println("End of input.");
                break;
            }

        }

        sc.close();

        int min = CHECK;

        for (int i = 0; i < ARRAY_MAX; i++) {

            int check = -1;

            for (int j = 0; j < ARRAY_MAX; j++) {
                if (dataArray[j] < min && dataArray[j] != CHECK) {
                    min = dataArray[j];
                    check = j;

                }
            }
            sortArray[i] = min;
            dataArray[check] = CHECK;
            min = CHECK;
        }

        for (int result : sortArray) {
            System.out.print("[" + result + "]");

        }
        System.out.println();

    }
}
