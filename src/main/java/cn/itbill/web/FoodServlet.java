package cn.itbill.web;

import cn.itbill.mapper.FoodMapper;
import cn.itbill.pojo.Food;
import com.alibaba.fastjson2.JSONArray;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;

@WebServlet("/detail")
public class FoodServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int foodId = Integer.parseInt(req.getParameter("food_id"));

        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        SqlSession sqlSession = sqlSessionFactory.openSession();

        FoodMapper foodMapper = sqlSession.getMapper(FoodMapper.class);
        Food food = foodMapper.selectById(foodId);

        String jsonString = JSONArray.toJSONString(food);

        resp.setContentType("text/json;charset=utf-8");
        resp.getWriter().write(jsonString);

        sqlSession.close();
    }
}
