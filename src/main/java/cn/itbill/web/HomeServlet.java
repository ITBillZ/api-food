package cn.itbill.web;

import cn.itbill.service.FoodService;
import cn.itbill.service.HomeService;
import cn.itbill.utils.Result;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;

@WebServlet("/home/*")
public class HomeServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String[] split = req.getRequestURI().split("/", 3);
        HomeService service = new HomeService();
        String jsonString;
        if ("swiper".equals(split[2])) {
            jsonString = service.selectAll();
        } else {
            jsonString = Result.getFailMsg();
        }
        resp.setContentType("text/json;charset=utf-8");
        resp.getWriter().write(jsonString);


    }
}
