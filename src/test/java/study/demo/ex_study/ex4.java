package study.demo.ex_study;

/** 변수 -> 배열 -> 구조체 -> 클래스
 *  클래스 = 필스(속성,변수) + 메서드
 *  필드 : 속성 / 메서드 : 행동 / 생성자 : 객체가 생성될떄(인스턴스화, 한 번 호출되는 메서드)
 */

/**
 *  간단한 계산기 class
 */
public class ex4 {

    int sumResult = 0;
    int subResult = 0;
    int mulResult = 0;
    float avrResult = 0.0f;

    int sum(int a, int b) {
        int c = a + b;
        sumResult = c;

        print('+', a, b, c);
        return c;

    }

    int sub(int a, int b) {
        int c = a - b;
        subResult = c;
        print('-', a, b, c);
        return c;
    }

    int mul(int a, int b) {
        int c = a * b;
        mulResult = c;
        print('*', a, b, c);
        return c;
    }

    float avr(int[] arry) {
        int sum = 0;
        float avr = 0.0f;
        for (int i = 0; i < arry.length; i++) {
            sum += arry[i];
        }
        avr = (float) sum / (float) arry.length;
        avrResult = avr;
        print(arry,avr);
        return avrResult;
    }

    void print(char op, int a, int b, int result) {
        System.out.println(a + "" + op + b + "=" + result);
    }

    void print(int[] arry, float result) {

        System.out.print("arry[ ");
        for (int i = 0; i < arry.length; i++) {
            System.out.print(arry[i] + " ");
        }
        System.out.println("]");
        System.out.println("avr! : " + result);
    }

    void printAll() {
        System.out.println("sum : " + sumResult);
        System.out.println("sub : " + subResult);
        System.out.println("mul : " + mulResult);
        System.out.println("avr : " + avrResult);
    }
}
