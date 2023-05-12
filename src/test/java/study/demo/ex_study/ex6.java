package study.demo.ex_study;

import java.util.Arrays;

/**
 *  람다식
 */
public class ex6 {

    /**
     *  람다식을 통해 병렬처리를 쉽게 하자
     *  람다식은 함수형 프로그래밍 기법을 지원하는 자바의 문법 요소
     *  메소드 사용시 = 클래스 객체 생성 필요
     *
     *  함수형 인터페이스
     *  : 단 하나의 추상 메서드만을 포함하고 있는 인터페이스
     *  람다식 : 함수형 인터페이스의 호출하는 방법,기능을 구현하는 방법을 정의한 문법
     */

    public static void main(String[] args) {

        Runnable r = new Runnable() {
            public void run() {
                System.out.println("run!");
            }
        };
        r.run();

        // array
        int [] nums = {80,30,20,30,40,20,30,100,200};

        // 기존
        for (int num : nums){
            if (num < 50){
                System.out.println(num + "이 50보다 작습니다");
            }
        }
        // 람다
        Arrays.stream(nums)
                .filter(num->num<50)
                .forEach(num->System.out.println(num+"이 50보다 작습니다"));
    }



    /** 함수형 인터페이스 : 단 하나의 추상 메서드만을 포함하는 인터페이스
     */
    interface TestFunctionalInterface{
        public abstract int sum(int returnVal);
    }
}
