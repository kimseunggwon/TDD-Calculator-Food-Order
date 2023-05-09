package study.demo.customer;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import study.demo.customer.object.MenuItem;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatCode;

public class MenuItemTest {

    @DisplayName("메뉴항목을 생성한다.")
    @Test
    void createTest() {
        assertThatCode(()->new MenuItem("만두", 5000))
                .doesNotThrowAnyException();
    }
}
