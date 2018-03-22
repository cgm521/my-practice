/**
 * Choicesoft.com.cn Inc.
 * Copyright (c) 2004-2018 All Rights Reserved.
 */
package com.wx.oauth.utils;

import net.sf.json.JSONObject;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;

import java.io.IOException;

/**
 * @author cgm
 * @version $Id: OAuthUtils.java, v 0.1 2018-03-22 17:42 cgm Exp $$
 */
public class OAuthUtils {
    public static final String APP_ID="wx89f041f0c9e1ffa6";
    public static final String APP_SECRET="wx89f041f0c9e1ffa6";
    public static JSONObject doGetJson(String url) throws IOException {
        JSONObject jsonObject =null;
        DefaultHttpClient client = new DefaultHttpClient();
        HttpGet httpGet = new HttpGet(url);
        CloseableHttpResponse response = client.execute(httpGet);
        HttpEntity entity = response.getEntity();
        if (entity != null) {
            String result = EntityUtils.toString(entity);
            jsonObject = JSONObject.fromObject(result);
        }
        httpGet.releaseConnection();
        return jsonObject;
    }
}
