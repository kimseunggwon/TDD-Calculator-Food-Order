package restful.demo.mapper;

import org.apache.ibatis.annotations.Mapper;
import restful.demo.model.BookInfoVO;
import restful.demo.model.Item;
import restful.demo.model.NoticeModel;

import java.util.List;

@Mapper
public interface TestMapper {

    //List<NoticeModel> getUserList(Object req) throws Exception;

    List<Item> getItem();

    List<BookInfoVO> getBook();

    List<NoticeModel> getNotice();

    NoticeModel selectById(int id);

    void insert(NoticeModel noticeModel);

    //void update(NoticeModel noticeModel);

    //void delete(String id);

}
