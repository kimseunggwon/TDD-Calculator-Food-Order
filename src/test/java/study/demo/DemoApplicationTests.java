package study.demo;

import org.junit.jupiter.api.DisplayName;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.springframework.boot.test.context.SpringBootTest;
import study.demo.calculate.Calculator;
import study.demo.calculate.object.PositiveNumber;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

/**
 * 객체지향적 프로그래밍 테스트 만들기.
 * 요구사항
 * 간단한 사칙연산을 할 수 있다
 * 양수로만 계산할 수 있다
 * 나눗셈에서 0을 나누는 경우 IllegalArgumentException 예외를 발생시킨다
 * mvc패턴 기반으로 구성한다
 */
@SpringBootTest
class DemoApplicationTests {

	// 1 + 2 ------> Calculator
	// 3     <------
	@DisplayName("덧셈 연산을 수행")
	@ParameterizedTest
	@MethodSource("formulaAndResult")
	void calculateTest(int operand1,String operator,int operand2, int result) {

		// Calculator 한테 테스트 위임
		int calculateResult = Calculator.calculate(new PositiveNumber(operand1),operator,new PositiveNumber(operand2));

		assertThat(calculateResult).isEqualTo(result);
	}

	private static Stream<Arguments> formulaAndResult() {
		return Stream.of(
				arguments(1,"+", 2, 3),
				arguments(1,"-", 2, -1),
				arguments(4,"*", 2, 8),
				arguments(4,"/", 2, 2)
		);
	}


	/** 객체 지향으로 객체들을 잘 나눴으면 DivisionOperator에서만 "0을 나누는 경우 예외"를 처리하면 된다.
	 * PositiveNumber가 있기에 핅요가 없다
	 *//*
	@Test
	@DisplayName("나눗셈에서 0을 나누는 경우 예외")
	void calculateExceptionTest() {
		assertThatCode(()-> Calculator.calculate(new PositiveNumber(10),"/",new PositiveNumber(0)))
				.isInstanceOf(IllegalArgumentException.class)
				.hasMessage("0으로는 나눌 수 없습니다");
	}*/
}
