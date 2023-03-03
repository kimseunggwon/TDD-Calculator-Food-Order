package restful.demo.Model;

// 입력 받는 객체에는 입력 받지 않는 id와 regdate 필드는 필요 없다

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class NoticeInput {

    private String title;
    private String content;
}
