package restful.demo.service;

import restful.demo.Model.NoticeModel;

import java.util.List;

public interface TestService {

    List<NoticeModel> getUserList() throws Exception;
}
