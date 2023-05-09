package study.demo.ex_study;

import java.util.Scanner;

/**
 *  제어문 이해 2
 */
public class ex2 {

    public static void main(String[] args) {

        /**  ex1
         */
        for (int i = 0; i < 10; i++) {
            System.out.println("break before : " + i);

            if (i > 3) {
                System.out.println("break!");
                break; // 반복문 , switch 내에서 사용
            }
            System.out.println("break after : " + i);

        }

        for (int i = 0; i < 10; i++) {
            System.out.println("continue before : " + i);

            if (i > 3) {
                System.out.println("continue!");
                continue; // 반복문 내에서만 사용가능
            }

            System.out.println("continue after : " + i);
        }


        /**  ex2
         */
        boolean A;
        boolean B;
        boolean notA;
        boolean notB;

        boolean andAB1;
        boolean andAB2;

        boolean orAB;

        for (int i = 0; i < 4; i++) {
            if (i == 0) {
                A = false;
                B = false;
            } else if (i == 1) {
                A = false;
                B = true;
            } else if (i == 2) {
                A = true;
                B = false;
            } else {
                A = true;
                B = true;
            }

            notA = !A;
            andAB1 = notA && B;
            notB = !B;
            andAB2 = notB && A;
            orAB = andAB1 || andAB2;

            System.out.println((A?"1,":"0,") + (B ? "1 : ":"0 : ")  + orAB);
        }


        /**  ex3 간단 구구단
         */
        // TODO Auto-generated method stub

        for(int dan = 1; dan <= 19; dan++) {
            System.out.println("======================================");
            System.out.println("["+dan+" Times Table]");
            for(int gob = 1; gob <=9; gob++) {
                System.out.println(dan + "*" + gob + "=" + dan * gob);
            }
        }


        /** ex4 최대값 최소값 구하기
         * 요구사항 : 값이 입력 될 때마다, 기존 값과 비교하여 최대값,최소값 구할 것.
         *       : 999를 입력하면 프로그램 종료.
         *       : 종료시, 그동안 입련된 값 중에 최대값과 최소값을 출력할 것.
         *       : 0~300까지 입력되는 값. 그 외에는 noise data
         */
        final int MAX = 300;
        final int MIN = 0;

        Scanner sc = new Scanner(System.in);  // Scanner = 화면으로부터 데이터를 입력받는 기능 제공 클래스.
                                              // System.in = 값을 입력받는 클래스
        int data;
        int max = MIN; // max는 가장 큰 값을 찾는거 즉, 입려된 값이 초기값으로 가장 작은값을 줘야 처음에 어떤 값을 주든 그게 max가 된다.
        int min = MAX; // min는 다음으로 들어오는 값과 비교해서 작은값을 찾아야하기에

        while(true) {
            System.out.println("input : ");
            data = sc.nextInt(); // data = Scanner 입력

            if(data <= MAX && data >= MIN) {
                System.out.println("ok : "+data);

                if(data > max) { // max는 지금 최소값인 0이기 때문에 data에 1만 넣어도 max값이 변한다.
                    max = data; // 최소값이 였던 max가 값을받고 max값으로 교체
                    System.out.println("found new max : " + max);
                }

                if(data < min) { // 지금 min에는 max값이 들어가 있다.
                    min = data; // 어떤값이든 min보다 작기 때문에 최소값을 찾았다.
                    System.out.println("found new min : "+ min);
                }

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
