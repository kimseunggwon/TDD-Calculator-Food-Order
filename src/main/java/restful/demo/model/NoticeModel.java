package restful.demo.model;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


import java.time.LocalDate;

@Data                   // getter,setter,toString
@NoArgsConstructor      //parameter가 없는 생성자
@AllArgsConstructor     // filed 전체를 받는 생성자
@Builder                // Builder 패턴, static한 클래스를 이용해서 편리하게 사용할 수 있게 도와줌
public class NoticeModel {

    private int id;
    private String title;
    private String content;


}
