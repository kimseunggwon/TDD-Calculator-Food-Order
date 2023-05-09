package study.demo.mapper;

import org.apache.ibatis.annotations.Mapper;
import study.demo.model.BoardDto;
import study.demo.model.BookInfoVO;
import study.demo.model.Item;
import study.demo.model.NoticeModel;

import java.util.List;

@Mapper
public interface TestMapper {

    //List<NoticeModel> getUserList(Object req) throws Exception;

    List<Item> getItem();

    List<BookInfoVO> getBook();

    List<NoticeModel> getNotice();

    NoticeModel selectById(int id);

    void insert(NoticeModel noticeModel);

    void update(NoticeModel noticeModel);

    void delete(int id);

    List<BoardDto> selectBoardList() throws Exception;

    void insertBoard(BoardDto boardDto) throws Exception;

}
