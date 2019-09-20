package com.cube.mallzuul.pre;

import com.alibaba.fastjson.JSON;
import com.cube.mallzuul.conf.UrlsEncryAndDecry;
import com.cube.security.RSAEncrypt;
import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import io.micrometer.core.instrument.util.JsonUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import sun.misc.BASE64Decoder;

import javax.servlet.http.HttpServletRequest;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.springframework.cloud.netflix.zuul.filters.support.FilterConstants.PRE_TYPE;

/**
 * 自定义拦截器，用于测试
 */
@Component
public class UrlsEncryAndDecryFilter extends ZuulFilter {

    @Autowired
    private UrlsEncryAndDecry urlsEncryAndDecry;

    @Override
    public String filterType() {
        return PRE_TYPE;
    }

    @Override
    public int filterOrder() {
        return 0;
    }

    @Override
    public boolean shouldFilter() {
        return true;
    }

    @Override
    public Object run() throws ZuulException {
        RequestContext ctx = RequestContext.getCurrentContext();
        InputStream stream = ctx.getResponseDataStream();
        HttpServletRequest request = ctx.getRequest();
        Object paramMaps = request.getParameter("data");
        String requestPath = request.getServletPath();
        System.out.println(requestPath);
        List<String> urls = urlsEncryAndDecry.getUrls();
        for (String url : urls) {
            if (!StringUtils.isEmpty(url) && requestPath.contains(url)) {
                System.out.println("进行加密解密:" + url);
                ctx.setSendZuulResponse(false);
                ctx.setResponseStatusCode(401);
                try {
                    ctx.getResponse().setContentType("text/html;charset=UTF-8");
                    ctx.getResponse().getWriter().write("进行url拦截");
                } catch (Exception e) {

                }
                return null;

            } else {
                System.out.println("放行：" + url);
                return null;
            }
        }

        // 私钥解密
        try {
            if (paramMaps != null && paramMaps.toString().length() > 0) {
                BASE64Decoder decoder = new BASE64Decoder();
                byte[] res = RSAEncrypt.decrypt(RSAEncrypt.loadPrivateKeyByStr(
                        "MIICdwIBADANBgkqhkiG9w0BAQEFAASCAmEwggJdAgEAAoGBAKc/2wnBAYCdj625vxVvqlR/DrXfMLpFKwM4Y0xccGwywDM8r0FAmxIWQY0f4WGg1LVGasZhgw0Vo6v25Ps/FGa2/ZmbLi84fKs/EwO24KmlzrxvbGy0KYu/6i4mH9JItf7iD8wutf9g3y0CbnWf21nyCkSz2FVsjqDljtcwsQF1AgMBAAECgYEAphx67YYfeuGC6XXZvm2oy8FiF+rz152JKeqgXSBWnHAPixQTsIh9PAqU0pi+XhvCB8VHmX8SDTXX2J0gMhYlqHxACzKnwtHfSJctNOeBplIPVrDgzuSaL2Q5dcoxo25kOoOaFuTPaFWxUbTcQQUMdPw0KBxtQswdG849W12xtUUCQQDrw/4XLRUa3V+u9qZCXJ8zD2YG19/W6ar8jJfbdfDNWtZIQK74yipfrW+RnkSjRgKhzGkOcryIsLp1sEFLNIJrAkEAtZp+e9bzXqM05kFPmLZoK/SfSAl7WmZYo1UNcSBPuPSTYJYKgYHrwaSduoJVxTihHuDowpwBPeJ4dlqyB1ZDnwJAB82HxkqWrTnwZcECBaY9GpqC3O0eGmXHY+5fREMmAhXki6WgZNmEB4Cc9avQR7sUcThrra+8b6Wxth1sO8n0GwJAWJVj3UScsi0qQKbbDMLtTYOlrp3xbcc+tW1ngSchvDaRLSwDM+kL9wk1ZyTscaeN8GIFJ+ixMl6mJBVZgfqyQQJBALjfc1EbR+4lsZpZXiN8seXUtAgSIeS+1bsz2bL5kcZNbLyRikYWheVpCx0m2J4b33gmKqF1kTioIMOgOQ3wzRo="),
                        decoder.decodeBuffer(paramMaps.toString()));
                // 解密后的字符串
                String restr = new String(res);
                //Map<String, Object> map = JsonUtils.jsonToObject(restr, HashMap.class);
                Map<String, Object> map = JSON.parseObject(restr, HashMap.class);
                // 传回请求体
                Map<String, List<String>> queryParams = new HashMap<>();
                List<String> keys = new ArrayList<String>(map.keySet());
                for (int i = 0; i < keys.size(); i++) {
                    String key = keys.get(i).toString();
                    String value = map.get(key).toString();
                    List<String> list = new ArrayList<String>();
                    list.add(value);
                    queryParams.put(key, list);
                }
                ctx.setRequestQueryParams(queryParams);
            }
        } catch (Exception e) {
            e.printStackTrace();
            ctx.setSendZuulResponse(false);
        }
        return null;
    }
}
