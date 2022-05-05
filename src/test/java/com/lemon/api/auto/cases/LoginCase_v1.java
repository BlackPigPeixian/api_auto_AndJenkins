package com.lemon.api.auto.cases;

import com.lemon.api.auto.utils.HttpUtil;
import org.apache.log4j.Logger;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

public class LoginCase_v1 {
    private static Logger logger =Logger.getLogger(LoginCase_v1.class);
    @Test
    public void test(){
        String url = "http://192.168.202.1:8082/HRRX_war_exploded/user/login";
        Map<String,String> params = new HashMap<String, String>();
        params.put("userName","admin");
        params.put("passWord","123456");
        logger.info("开始调用doPost方法，完成接口调用");
        String result = HttpUtil.doPost(url,params);
        logger.info("调用结束，获取到的响应报文result【"+result+"】");
    }
}
