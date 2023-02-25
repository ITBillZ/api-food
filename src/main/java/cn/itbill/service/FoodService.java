package cn.itbill.service;

import cn.itbill.mapper.FoodMapper;
import cn.itbill.pojo.Food;
import cn.itbill.utils.Result;
import cn.itbill.utils.ResultCode;
import com.alibaba.fastjson2.JSON;
import org.apache.ibatis.session.SqlSession;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;

public class FoodService extends Service {

	public String selectAllForList() {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		FoodMapper mapper = sqlSession.getMapper(FoodMapper.class);
		List<Food> foods = mapper.selectAllForList();
		foods.forEach(food -> food.setImg(food.getImg() + "?x-oss-process=style/c320"));
		Result result = new Result(ResultCode.SUCCESS.getStatus(), foods);
		sqlSession.close();
		return JSON.toJSONString(result);
	}

	public String selectById(String id) {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		FoodMapper mapper = sqlSession.getMapper(FoodMapper.class);
		Result result;
		if (id == null || id.equals("")) {
			List<Food> foods = mapper.selectAllForList();
			result = new Result(ResultCode.SUCCESS.getStatus(), foods);
		} else {
			Food food = mapper.selectById(Integer.parseInt(id));
			result = new Result(ResultCode.SUCCESS.getStatus(), food);
		}
		sqlSession.close();
		return JSON.toJSONString(result);
	}





	public String selectTitleByKeyWord(String title) {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		FoodMapper mapper = sqlSession.getMapper(FoodMapper.class);
		title = "%" + title + "%";
		List<Food> foods = mapper.selectTitleByKeyWord(title);
		Result result = new Result(ResultCode.SUCCESS.getStatus(), foods);
		sqlSession.close();
		return JSON.toJSONString(result);
	}
}
