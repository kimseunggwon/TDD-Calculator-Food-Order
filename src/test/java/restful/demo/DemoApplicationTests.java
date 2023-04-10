package restful.demo;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

/**
 * 요구사항
 * 간단한 사칙연산
 * 양수로만 계산
 * 나눗셈에서 0을 나누는 경우 예외
 * mvc패턴 기반
 */
@SpringBootTest
class DemoApplicationTests {

	// 1 + 2 ------> Calculator
	// 3     <------
	@DisplayName("덧셈 연산을 수행")
	@ParameterizedTest
	@MethodSource("formulaAndResult")
	void calculateTest(int operand1,String operator,int operand2, int result) {

		// Calculator에게 테스트 위임
		int calculateResult = Calculator.calculate(operand1,operator,operand2);

		assertThat(calculateResult).isEqualTo(result);
	}

	/*@DisplayName("뺄셈 연산을 수행")
	@Test
	void subtractionTest() {

		int result = Calculator.calculate(1,"-",2);

		assertThat(result).isEqualTo(-1);
	}*/

	private static Stream<Arguments> formulaAndResult() {
		return Stream.of(
				arguments(1,"+", 2, 3),
				arguments(1,"-", 2, -1),
				arguments(4,"*", 2, 8),
				arguments(4,"/", 2, 2)
		);
	}
}
