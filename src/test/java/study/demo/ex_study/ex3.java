package study.demo.ex_study;

import java.util.Arrays;
import java.util.Scanner;

/** 배열 / 제어문 이해
 *  최대값 최소값 구하기  => 배열 사용하고 리펙토링 해보기
 */
public class ex3 {
    public static void main(String[] args) {

        final int MAX = 300;
        final int MIN = 0;
        final int ARRAY_MAX = 5;

        Scanner sc = new Scanner(System.in);  // Scanner = 화면으로부터 데이터를 입력받는 기능 제공 클래스.
                                             // System.in = 값을 입력받는 클래스
        int data;
        int max = MIN; // max는 가장 큰 값을 찾는거 즉, 입려된 값이 초기값으로 가장 작은값을 줘야 처음에 어떤 값을 주든 그게 max가 된다.
        int min = MAX; // min는 다음으로 들어오는 값과 비교해서 작은값을 찾아야하기에

        int[] dataArray = new int[ARRAY_MAX];

        int arrayAddr = 0;
        int count = 0;

        while(true) {
            System.out.println("input : ");
            data = sc.nextInt(); // 입력을 받는다

            if(data <= MAX && data >= MIN) {

                 max = MIN;  //  초기화
                 min = MAX;

                if (count < ARRAY_MAX){
                    count++;  // 최대 5가되면 더이상 증가X
                }

                dataArray[arrayAddr++] = data;

                // 배열 에러 방지
                if (arrayAddr >= ARRAY_MAX){
                    arrayAddr = 0;
                }

                for (int i=0; i < count; i++) {

                    System.out.print("["+dataArray[i]+"]");

                    if (dataArray[i] > max){
                        max = dataArray[i];
                    }

                    if (dataArray[i] > min){
                        min = dataArray[i];
                    }
                }

                System.out.println();

                System.out.println("max :" + max);
                System.out.println("min :" + min);

            }else if(data == 999) {
                System.out.println("Bye");
                break; // while -> break
            }else {
                System.out.println("noise data : "+ data);
            }


        }

        System.out.println("final min : " + min);
        System.out.println("final max : " + max);
        sc.close();

    }
}
