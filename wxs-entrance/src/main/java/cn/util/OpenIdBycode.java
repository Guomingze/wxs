package cn.util;

import com.alibaba.fastjson.JSON;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.conn.ssl.AllowAllHostnameVerifier;
import org.apache.http.conn.ssl.SSLSocketFactory;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class OpenIdBycode {

    public String getOpenid(String code) {
        SSLSocketFactory.getSocketFactory().setHostnameVerifier(new AllowAllHostnameVerifier());
        HttpClient hc = new DefaultHttpClient();
        //小程序登录凭证检验 请求地址
        HttpGet hg = new HttpGet("https://api.weixin.qq.com/sns/jscode2session?appid=wxce1b29b2285f207a&secret=886ba38dbfb1b9fbe596d8d3b9352b5d&js_code=" + code + "&grant_type=authorization_code");
        HttpResponse resp = null;
        String openid = "";
        try {
            resp = hc.execute(hg);
        } catch (IOException e) {
            e.printStackTrace();
        }
        if (resp.getStatusLine().getStatusCode() == 200) {
            HttpEntity resEntity = resp.getEntity();
            try {
                //请求得到的响应内容 用户唯一标识
                openid = EntityUtils.toString(resEntity, "utf-8");
                Openid openid1 = JSON.parseObject(openid, Openid.class);
                openid = openid1.getOpenid();
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("请求失败");
        }
        return openid;
    }
}
