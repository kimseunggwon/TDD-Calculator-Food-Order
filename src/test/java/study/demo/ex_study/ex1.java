package study.demo.ex_study;

/**
 *  제어문 이해 1
 */
public class ex1 {

    public static void main(String[] args) {

        /**   ex1
         */
        if (true) {
            System.out.println("run1");
            System.out.println("run1-1");
        }

        // if문 자바는 { } 없으면 자동으로 한줄까지 생성해준다. 그럼 무조건 run2가 출력이 된다.
        if (true)
        System.out.println("run2");
        System.out.println("run2-1");

        if (false)
        System.out.println("run3");
        System.out.println("run3-1");


        /**   ex2
         */
        boolean cond1 = true;
        boolean cond2 = false;

        // 초기화를 하지않으면 아무값이 없기 때문에 사용할 수 없다.
        //boolean cond3;
        boolean cond3 = true;

        if (cond1) {
            System.out.println("run1");
        }

        if (cond2) {
            System.out.println("run2");
        }

        if (cond3) {
            System.out.println("run3");
        }

        /**   ex3
         */
        int A = 10;
        int B = 20;

        boolean cond10 = true;
        boolean cond20 = false;

        if (A > B) {
            System.out.println("run1");
        }

        if (B > A) {
            System.out.println("run2");
        }

        if (A == B) {
            System.out.println("run3");
        }

        // && = AND = 양쪽 모두 true 이어야 true 결과로 얻는다
        if (cond1 && cond2) {
            System.out.println("run4");
        }

        // || = OR = 어느 한 쪽이 true이면 true 결과 얻는다
        if (cond1 || cond2) {
            System.out.println("run5");
        }

        if (!cond2) {
            System.out.println("run6");
        }

        /**   ex4
         */
        int score = 100;
        switch (score / 10) {
            // case 10 경우 실행될게 없기 때문에 case9가 실행되어 A 학점이 나온다.
            case 10:
            case 9:
                System.out.println("A");
                break;
            case 8:
                System.out.println("B");
                break;
            case 7:
                System.out.println("C");
                break;
            case 6:
                System.out.println("D");
                break;
            default:
                System.out.println("F");

        }


    }
}