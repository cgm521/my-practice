/**
 * Choicesoft.com.cn Inc.
 * Copyright (c) 2004-2018 All Rights Reserved.
 */
package com.wx.oauth.Servlet;

import com.wx.oauth.utils.OAuthUtils;
import net.sf.json.JSONObject;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URLEncoder;

/**
 * @author cgm
 * @version $Id: Servlet.java, v 0.1 2018-03-22 19:12 cgm Exp $$
 */
@RestController
@RequestMapping("/login")
public class LoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        String backUrl = "/wxAuth/callBack";
        String url = "https://open.weixin.qq.com/connect/oauth2/authorize?"
                + "appid=" + OAuthUtils.APP_ID
                + "&redirect_uri=" + URLEncoder.encode(backUrl,"UTF-8")
                + "&response_type=code"
                + "&scope=snsapi_base"
                + "&state=STATE#wechat_redirect";
        JSONObject jsonObject = OAuthUtils.doGetJson(url);
    }
}
