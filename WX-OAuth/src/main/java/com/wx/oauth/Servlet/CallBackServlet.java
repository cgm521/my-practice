/**
 * Choicesoft.com.cn Inc.
 * Copyright (c) 2004-2018 All Rights Reserved.
 */
package com.wx.oauth.Servlet;

import com.wx.oauth.utils.OAuthUtils;
import net.sf.json.JSONObject;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author cgm
 * @version $Id: CallBackServlet.java, v 0.1 2018-03-22 19:22 cgm Exp $$
 */
@WebServlet("/CallBack")
public class CallBackServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String code = req.getParameter("code");
        String url = "https://api.weixin.qq.com/sns/oauth2/access_token?"
                + "appid=" + OAuthUtils.APP_ID
                + "&secret="+OAuthUtils.APP_SECRET
                + "&code="+code
                + "&grant_type=authorization_code";
        JSONObject jsonObject = OAuthUtils.doGetJson(url);

        super.doGet(req, resp);
    }
}
