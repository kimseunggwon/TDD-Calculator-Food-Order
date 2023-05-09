package study.demo.service;

import study.demo.model.BoardDto;
import study.demo.model.BookInfoVO;
import study.demo.model.Item;
import study.demo.model.NoticeModel;

import java.util.List;

public interface TestService {

    //List<NoticeModel> getUserList(Object req) throws Exception;

    List<Item> getItem();

    List<BookInfoVO> getBook();

    List<NoticeModel> getNotice();

    NoticeModel selectById(int id);

    void insert(NoticeModel noticeModel);

    void update(NoticeModel noticeModel,int id);

    void delete(int id);

    // BoardDto

    List<BoardDto> selectBoardList() throws Exception;

    void insertBoard(BoardDto boardDto) throws Exception;
}
