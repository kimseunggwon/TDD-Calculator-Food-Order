package study.demo.mapper;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import study.demo.model.BoardDto;
import study.demo.model.BookInfoVO;
import study.demo.model.Item;
import study.demo.model.NoticeModel;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class TestRepository implements TestMapper{

    private final TestMapper testMapper;

    @Override
    public List<Item> getItem() {
        return testMapper.getItem();
    }

    @Override
    public List<BookInfoVO> getBook() {
        return testMapper.getBook();
    }

    @Override
    public List<NoticeModel> getNotice() {
        return testMapper.getNotice();
    }

    @Override
    public NoticeModel selectById(int id) {
        return testMapper.selectById(id);
    }

    @Override
    public void insert(NoticeModel noticeModel) {
        testMapper.insert(noticeModel);
    }

    @Override
    public void update(NoticeModel noticeModel) {
        testMapper.update(noticeModel);
    }

    @Override
    public void delete(int id) {
        testMapper.delete(id);
    }

    @Override
    public List<BoardDto> selectBoardList() throws Exception {
        return testMapper.selectBoardList();
    }

    @Override
    public void insertBoard(BoardDto boardDto) throws Exception {
        testMapper.insertBoard(boardDto);
    }
}
