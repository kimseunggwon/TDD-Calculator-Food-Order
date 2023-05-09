package study.demo.controller;

import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import study.demo.model.BoardDto;
import study.demo.model.BookInfoVO;
import study.demo.model.Item;
import study.demo.model.NoticeModel;
import study.demo.service.TestService;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequiredArgsConstructor
@Slf4j
public class ApiNoticeController {

    private final TestService testService;



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
     * 빌더 패턴 장점 : 필요한 데이터만 설정, 유연성, 기독성, 변경 가능성 최소화
     */
    @GetMapping("/api/notice")
    public List<NoticeModel> notice() {
        List<NoticeModel> noticeModelList = new ArrayList<>();

        noticeModelList.add(NoticeModel.builder()
                .id(1)
                .title("공지사항 입니다")
                .content("공지사항 내용 입니다")
                //.localDate(LocalDate.of(2023,03,03))
                .build());

        noticeModelList.add(NoticeModel.builder()
                .id(2)
                .title("두번째 공지사항 입니다")
                .content("두번째 공지사항 내용 입니다")
                //.localDate(LocalDate.of(2023,03,03))
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

    @PostMapping("/api/notice1")
    public NoticeModel addNotice(@RequestBody NoticeModel noticeModel) {
        noticeModel.setId(3);
        //noticeModel.setLocalDate(LocalDate.now());
        return noticeModel;
    }

   /* @GetMapping("/user")
    public List<NoticeModel> getUserList(Object req) throws Exception{
        log.info("컨트롤러 진입");

        return testService.getUserList(req);
    }*/

    @GetMapping("/userAll")
    public List<Item> getItem(Item item) {
        log.info("컨트롤러 진입");

        return testService.getItem();
    }

    @GetMapping("/book")
    public List<BookInfoVO> getBook(BookInfoVO bookInfoVO) {
        log.info("북 컨트롤러 진입");
        return testService.getBook();
    }

    @ApiOperation(value = "조회 기능", notes = "조회 기능")
    @GetMapping("/notice")
    public List<NoticeModel> getNotice(NoticeModel noticeModel) {
        log.info("모델 컨트롤러 진입");
        return testService.getNotice();
    }

    @ApiOperation(value = "아이디로 조회 기능", notes = "아이디로 조회 기능")
    @GetMapping("/notice/{id}")
    public NoticeModel selectById(@PathVariable int id) {
        log.info("모델1 컨트롤러 진입");
        return testService.selectById(id);
    }

    @ApiOperation(value = "추가 기능", notes = "추가 기능")
    @PostMapping("/notice/new1")
    public List<NoticeModel> insert(@RequestBody NoticeModel noticeModel) {
        testService.insert(noticeModel);
        return testService.getNotice();
    }

    @ApiOperation(value = "수정 기능", notes = "수정 기능")
    @PutMapping("/noticeUp/{id}")
    public List<NoticeModel> update(@PathVariable int id,@RequestBody NoticeModel noticeModel) {
        testService.update(noticeModel,id);
        return testService.getNotice();
    }

    @ApiOperation(value = "삭제 기능", notes = "삭제 기능")
    @DeleteMapping("/noticeDe/{id}")
    public List<NoticeModel> delete(@PathVariable int id) {
        testService.delete(id);

        return testService.getNotice();
    }

    @GetMapping("/board/openBoardList.do")
    public List<BoardDto> openBoardList(BoardDto boardDto) throws Exception{

        return testService.selectBoardList();
    }


    @PostMapping("/board/openBoardWrite.do")
    @ResponseBody
    public List<BoardDto> insertBoard(BoardDto boardDto) throws Exception{
        testService.insertBoard(boardDto);

        return testService.selectBoardList();
    }



}
