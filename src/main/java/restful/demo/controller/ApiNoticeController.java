package restful.demo.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import restful.demo.Model.NoticeModel;
import restful.demo.service.TestService;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class ApiNoticeController {

    private TestService testService;



   /* @GetMapping("/api/notice")
    public NoticeModel noticeString() {

        NoticeModel noticeModel = new NoticeModel();
        noticeModel.setId(1);
        noticeModel.setTitle("공지사항입니다");
        noticeModel.setContent("공지사항 내용입니다");
        noticeModel.setLocalDate(LocalDate.of(2023,03,03));

        return noticeModel;
    }*/

    /**
     * Builder 적용
     * 객체(Class).builder()....build() 형식
     */
    @GetMapping("/api/notice")
    public List<NoticeModel> notice() {
        List<NoticeModel> noticeModelList = new ArrayList<>();

        noticeModelList.add(NoticeModel.builder()
                .id(1)
                .title("공지사항 입니다")
                .content("공지사항 내용 입니다")
                .localDate(LocalDate.of(2023,03,03))
                .build());

        noticeModelList.add(NoticeModel.builder()
                .id(2)
                .title("두번째 공지사항 입니다")
                .content("두번째 공지사항 내용 입니다")
                .localDate(LocalDate.of(2023,03,03))
                .build());

        return noticeModelList;
    }

    @GetMapping
    public List<NoticeModel> notice1() {

        List<NoticeModel> noticeList = new ArrayList<>();

        return noticeList;
    }

    @GetMapping("/api/notice/count")
    public int noticeCount() {
        return 10;
    }

    /*@PostMapping("/api/notice")
    public NoticeModel addNotice(@RequestParam String title,@RequestParam String content) {
        return NoticeModel.builder()
                .id(1)
                .title(title)
                .content(content)
                .localDate(LocalDate.of(2023,03,03))
                .build();
    }*/

   /* @PostMapping("/api/notice")
    public NoticeModel addNotice(NoticeModel noticeModel) {
        noticeModel.setId(2);
        noticeModel.setLocalDate(LocalDate.now());
        return noticeModel;
    }*/

    @PostMapping("/api/notice")
    public NoticeModel addNotice(@RequestBody NoticeModel noticeModel) {
        noticeModel.setId(3);
        noticeModel.setLocalDate(LocalDate.now());
        return noticeModel;
    }

    @GetMapping("/user")
    public List<NoticeModel> getUserList() throws Exception{
        return testService.getUserList();
    }


}
