package study.demo.calculate.object;

public class DivisionOperator implements NewArithmeticOperator {

    @Override
    public boolean supports(String operator) {
        return "/".equals(operator);
    }

    @Override
    public int calculate(PositiveNumber operand1, PositiveNumber operand2) {

        //PositiveNumber가 무조건 양수를 보장하기 때문에 if문을 사용할 필요가 없다

       /* if (operand2.toInt() == 0){
            throw new IllegalStateException("0으로는 나눌 수 없습니다");
        }*/
        return operand1.toInt() / operand2.toInt();
    }
}
