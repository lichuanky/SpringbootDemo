package cn.welk.service.demo.proxy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.File;
import java.util.Map;

@Service
class BaseProxy {
    private static final String BASE_URL = "http://welk.cn/api/v1";

    @Autowired
    protected SfRestTemplate restTpl;

    protected <T> T restGet(String action, Class<T> responseType) {
        return restTpl.get(BASE_URL + action, responseType);
    }

    protected <T> T restPost(String action, Object src, Class<T> responseType) {
        return restTpl.post(BASE_URL + action, src, responseType);
    }

    protected <T> T restPostFile(String action, File file, Class<T> responseType, Map<String, ?> params) {
        return restTpl.postFile(BASE_URL + action, file, responseType, params);
    }

    protected void restDel(String action) {
        restTpl.delete(BASE_URL + action);
    }
}
