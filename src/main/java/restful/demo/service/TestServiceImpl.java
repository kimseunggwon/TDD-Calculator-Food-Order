package restful.demo.service;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import restful.demo.Model.NoticeModel;
import restful.demo.mapper.TestMapper;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TestServiceImpl implements TestService{


    private TestMapper testMapper;

    @Override
    public List<NoticeModel> getUserList() throws Exception{
        return testMapper.getUserList();
    }
}
