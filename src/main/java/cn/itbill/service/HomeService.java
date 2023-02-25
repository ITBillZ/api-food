package cn.itbill.service;

import cn.itbill.mapper.FoodMapper;
import cn.itbill.mapper.HomeSwiperMapper;
import cn.itbill.pojo.Food;
import cn.itbill.pojo.HomeSwiper;
import cn.itbill.utils.Result;
import cn.itbill.utils.ResultCode;
import com.alibaba.fastjson2.JSON;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

public class HomeService extends Service{
    public String selectAll() {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        HomeSwiperMapper mapper = sqlSession.getMapper(HomeSwiperMapper.class);
        List<HomeSwiper> swiperList = mapper.selectAll();
        Result result = new Result(ResultCode.SUCCESS.getStatus(), swiperList);
        sqlSession.close();
        return JSON.toJSONString(result);
    }
}
