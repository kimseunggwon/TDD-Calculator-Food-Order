package restful.demo.service;

import restful.demo.model.BookInfoVO;
import restful.demo.model.Item;
import restful.demo.model.NoticeModel;

import java.util.List;

public interface TestService {

    //List<NoticeModel> getUserList(Object req) throws Exception;

    List<Item> getItem();

    List<BookInfoVO> getBook();

    List<NoticeModel> getNotice();

    NoticeModel selectById(int id);

    void insert(NoticeModel noticeModel);
}
