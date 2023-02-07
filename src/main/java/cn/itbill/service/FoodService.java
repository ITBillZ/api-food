package cn.itbill.service;

import cn.itbill.Util.Result;
import cn.itbill.Util.ResultCode;
import cn.itbill.mapper.FoodMapper;
import cn.itbill.pojo.Food;
import com.alibaba.fastjson2.JSON;
import com.alibaba.fastjson2.JSONArray;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class FoodService extends Service {

    public String selectById(String id) {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        FoodMapper mapper = sqlSession.getMapper(FoodMapper.class);
        Result result;
        if (id == null || id.equals("")) {
            List<Food> foods = mapper.selectAll();
            result = new Result(ResultCode.SUCCESS.getStatus(), foods);
        } else {
            Food food = mapper.selectById(Integer.parseInt(id));
            result = new Result(ResultCode.SUCCESS.getStatus(), food);
        }
        sqlSession.close();
        return JSON.toJSONString(result);
    }
}
