package restful.demo.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import restful.demo.model.BoardDto;
import restful.demo.model.BookInfoVO;
import restful.demo.model.Item;
import restful.demo.mapper.TestRepository;
import restful.demo.model.NoticeModel;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TestServiceImpl implements TestService {

    private final TestRepository testRepository;

    /*@Override
    public List<NoticeModel> getUserList(Object req) throws Exception{
        return testMapper.getUserList(req);
    }*/

    @Override
    public List<Item> getItem() {
        return testRepository.getItem();
    }

    @Override
    public List<BookInfoVO> getBook() {
        return testRepository.getBook();
    }

    @Override
    public List<NoticeModel> getNotice() {
        return testRepository.getNotice();
    }

    @Override
    public NoticeModel selectById(int id) {
        return testRepository.selectById(id);
    }

    @Override
    public void insert(NoticeModel noticeModel) {
         testRepository.insert(noticeModel);
    }

    @Override
    public void update(NoticeModel noticeModel,int id) {
        testRepository.update(noticeModel);
    }

    @Override
    public void delete(int id) {
        testRepository.delete(id);
    }

    @Override
    public List<BoardDto> selectBoardList() throws Exception {
        return testRepository.selectBoardList();
    }

    @Override
    public void insertBoard(BoardDto boardDto) throws Exception {
        testRepository.insertBoard(boardDto);
    }
}
