package restful.demo;

public class Calculator {
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
        return ArithmeticOperator.calculate(operand1,operator,operand2);
    }
}
