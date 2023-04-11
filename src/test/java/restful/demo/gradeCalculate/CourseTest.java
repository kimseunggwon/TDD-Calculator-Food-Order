package restful.demo.gradeCalculate;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatCode;

public class CourseTest {

    @DisplayName("과목(코스)를 생성한다.")
    @Test
    void createTest() {
        assertThatCode(()->new Course("OOP",3,"A"))
                .doesNotThrowAnyException(); // Course 정상 생성되면 어떠한 예외도 발생X
    }
}
