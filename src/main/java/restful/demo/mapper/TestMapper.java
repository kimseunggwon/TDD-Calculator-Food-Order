package restful.demo.mapper;

import org.apache.ibatis.annotations.Mapper;
import restful.demo.Model.NoticeModel;

import java.util.List;

@Mapper
public interface TestMapper {

    List<NoticeModel> getUserList() throws Exception;
}
