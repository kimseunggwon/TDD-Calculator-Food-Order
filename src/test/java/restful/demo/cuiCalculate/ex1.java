package restful.demo.cuiCalculate;

public class ex1 {

    public static void main(String[] args) {

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

    }
}
