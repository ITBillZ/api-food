package cn.itbill.web;

import com.alibaba.fastjson2.JSONArray;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/home/swiperdata")
public class SwiperDataServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/json;charset=utf-8");

        List<String> list = new ArrayList<>();
        list.add("https://cas.sustech.edu.cn/cas/images/sustech.png");
        list.add("https://cas.sustech.edu.cn/cas/images/sustech.png");
        list.add("https://cas.sustech.edu.cn/cas/images/sustech.png");

    }
}
