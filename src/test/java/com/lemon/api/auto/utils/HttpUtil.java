package com.lemon.api.auto.utils;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.apache.log4j.Logger;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class HttpUtil {
    private static Logger logger = Logger.getLogger(HttpUtil.class);
    public static String doPost(String url, Map<String, String> params){
        logger.info("设置接口请求方式");
        HttpPost httpPost = new HttpPost(url);
        logger.info("准备测试数据");
        List<BasicNameValuePair> parameters = new ArrayList<BasicNameValuePair>();
        Set<String> keys = params.keySet();
        for (String key:keys) {
            String value = params.get(key);
            parameters.add(new BasicNameValuePair(key,value));
        }
        String result = "";
        try {
            logger.info("把测试数据放入请求体中");
            httpPost.setEntity(new UrlEncodedFormEntity(parameters,"utf-8"));
            logger.info("创建客户端");
            HttpClient httpClient = HttpClients.createDefault();
            logger.info("发送请求");
            HttpResponse httpResponse = httpClient.execute(httpPost);
            int code = httpResponse.getStatusLine().getStatusCode();
            logger.info("获取到的code【"+code+"】");
            result = EntityUtils.toString(httpResponse.getEntity());

        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }
}
