package com.cube.mallzuul.post;

import com.alibaba.fastjson.JSON;
import com.cube.mall.model.Message;
import com.cube.security.Base64;
import com.cube.security.RSAEncrypt;
import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.springframework.util.StreamUtils;

import javax.servlet.http.HttpServletRequest;
import java.io.InputStream;
import java.nio.charset.Charset;

import static org.springframework.cloud.netflix.zuul.filters.support.FilterConstants.POST_TYPE;

public class ResultFilter extends ZuulFilter {
    @Override
    public String filterType() {
        return POST_TYPE;
    }

    @Override
    public int filterOrder() {
        return 0;
    }

    @Override
    public boolean shouldFilter() {
        return false;
    }

    @Override
    public Object run() throws ZuulException {

        RequestContext ctx = RequestContext.getCurrentContext();
        InputStream stream = ctx.getResponseDataStream();
        HttpServletRequest request = ctx.getRequest();
        String url = request.getRequestURL().toString();
        try {
            String body = StreamUtils.copyToString(stream, Charset.forName("UTF-8"));
            body = Base64.encode(body.getBytes());
            if (body.contains("message")) {
                if (ctx.getResponse().getStatus() == 500) {
                    if (body.contains("Token") || body.contains("token")) {
                        ctx.setResponseStatusCode(401);
                        Message message = new Message();
                        message.setStatus("401");
                        message.setErrCode("401");
                        message.setErrMsg("token错误");
                        body = JSON.toJSONString(message);
                    }
                }
            }
            byte[] encrypt = RSAEncrypt.encrypt(RSAEncrypt.loadPublicKeyByStr(
                    "MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQCnP9sJwQGAnY+tub8Vb6pUfw613zC6RSsDOGNMXHBsMsAzPK9BQJsSFkGNH+FhoNS1RmrGYYMNFaOr9uT7PxRmtv2Zmy4vOHyrPxMDtuCppc68b2xstCmLv+ouJh/SSLX+4g/MLrX/YN8tAm51n9tZ8gpEs9hVbI6g5Y7XMLEBdQIDAQAB"),
                    body.getBytes("utf-8"));
            // 加密后结果
            // String cipher = Base64.encode(encrypt);
            String cipher = Base64.encode(encrypt);
            // 替换boby体
            ctx.setResponseBody(cipher);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        return ctx;
    }
}
