package com.sdyb.mp.util;

import com.sun.javafx.collections.MappingChange;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import java.net.URI;
import java.util.HashMap;
import java.util.Map;

import org.apache.http.client.utils.URIBuilder;

public class WebUtils {

    /**
     * 使用httpclient模拟get请求 - 带一个参数的get请求
     */
    public static String sendGetByUrlAndStr(String url,String data) {
        String response = null;
        try {
            CloseableHttpClient httpclient = null;
            CloseableHttpResponse httpresponse = null;
            try {
                // 获得一个httpclient对象
                httpclient = HttpClients.createDefault();

                // 定义请求的参数(需要设置param和value)
                URI uri = new URIBuilder(url).setParameter("name", data).build();

                // 创建一个get请求
                HttpGet httpget = new HttpGet(uri);

                // 响应内容
                httpresponse = httpclient.execute(httpget);

                response = EntityUtils.toString(httpresponse.getEntity());
            } finally {
                if (httpclient != null) {
                    httpclient.close();
                }
                if (httpresponse != null) {
                    httpresponse.close();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return response;
    }

    public static String sendGetByUrlAndMap(String url, Map<String,Object> map) {
        String response = null;
        try {
            CloseableHttpClient httpclient = null;
            CloseableHttpResponse httpresponse = null;
            try {
                // 获得一个httpclient对象
                httpclient = HttpClients.createDefault();

                // 定义请求的参数(需要设置param和value)
                URIBuilder ub = new URIBuilder(url);
                map.forEach( (k,v) -> ub.setParameter(k,v.toString()));
                URI uri = ub.build();

                // 创建一个get请求
                HttpGet httpget = new HttpGet(uri);

                // 响应内容
                httpresponse = httpclient.execute(httpget);

                response = EntityUtils.toString(httpresponse.getEntity());
            } finally {
                if (httpclient != null) {
                    httpclient.close();
                }
                if (httpresponse != null) {
                    httpresponse.close();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return response;
    }

}
