package study.demo.ex_study;

import java.util.Scanner;

/** 배열의 이해
 *  입력되는 값의 최근 5개의 평균을 구하기
 *  평균 = 자료 값의 합 % 자료의 수
 */
public class ex3_1 {

    public static void main(String[] args) {

        Scanner sc1 = new Scanner(System.in);

        int ARRAY_MAX1 = 5;

        int[] dataArray1 = new int[ARRAY_MAX1];

        int data1 = 0;
        int arrayAddr1 = 0;
        int count1 = 0;
        int sum = 0;
        float avr = 0.0f;

        while (true) {

            System.out.println("input : ");
            data1 = sc1.nextInt();

            if (data1 != -1) {        //무한루프 방지
                sum = 0; // sum 초기화
                avr = 0;

                // count 5보다 작으면 계속 증가
                if (count1 < ARRAY_MAX1) {
                    count1++;
                }

                dataArray1[arrayAddr1++] = data1;

                // 5보다 커지면 0으로
                if (arrayAddr1 >= ARRAY_MAX1) {
                    arrayAddr1 = 0;
                }

                for (int i = 0; i < count1; i++) {
                    sum += dataArray1[i];
                }
                //평균 구하기
                avr = (float) sum / (float) count1;

                System.out.println(avr);
            } else {
                break;
            }

        }
    }
}
