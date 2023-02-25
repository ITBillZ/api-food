package cn.itbill.web;

import cn.itbill.service.FoodService;
import cn.itbill.utils.Result;
import com.alibaba.fastjson2.JSON;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;

@WebServlet("/food/*")
public class FoodServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String[] split = req.getRequestURI().split("/", 3);
        FoodService foodService = new FoodService();
        String jsonString = "";
        if ("list".equals(split[2])) {
            jsonString = foodService.selectAllForList();
        } else if ("detail".equals(split[2])) {
            jsonString = foodService.selectById(req.getParameter("food_id"));
        } else if ("search".equals(split[2])) {
            jsonString = foodService.selectTitleByKeyWord(req.getParameter("query"));
        } else {
            jsonString = Result.getFailMsg();
        }
        resp.setContentType("text/json;charset=utf-8");
        resp.getWriter().write(jsonString);
    }
}
