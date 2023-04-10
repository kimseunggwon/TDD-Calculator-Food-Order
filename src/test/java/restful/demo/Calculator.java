package restful.demo;

import restful.demo.calculate.*;

import java.util.List;

public class Calculator {

    // 인터페이스 만들고 refactory
    private static final List<NewArithmeticOperator> arithmeticOperators = List.of(new AdditionOperator(),new SubtractionOperator(),
            new MultiplicationOperator(),new DivisionOperator());

    public static int calculate(int operand1, String operator, int operand2) {

       /* if ("+".equals(operator)) {
            return operand1 + operand2;
        } else if ("-".equals(operator)){
            return operand1 - operand2;
        } else if ("*".equals(operator)) {
            return operand1 * operand2;
        } else if ("/".equals(operator)) {
            return operand1 / operand2;
        }*/

        // ArithmeticOperator에게 테스트 위임
        return arithmeticOperators.stream()
                .filter(arithmeticOperators -> arithmeticOperators.supports(operator))
                .map(arithmeticOperators -> arithmeticOperators.calculate(operand1,operand2))
                .findFirst()
                .orElseThrow(()-> new IllegalArgumentException("올바른 사칙연산이 아닙니다."));
    }
}
