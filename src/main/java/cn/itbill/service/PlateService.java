package cn.itbill.service;

import cn.itbill.mapper.PlateMapper;
import cn.itbill.pojo.Plate;
import cn.itbill.utils.Result;
import cn.itbill.utils.ResultCode;
import com.alibaba.fastjson.JSON;
import org.apache.ibatis.session.SqlSession;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class PlateService extends Service{

	public void updateByPlateId(Integer plate_id, ArrayList<Integer> foodList) {
		deleteById(plate_id);
		System.out.println(foodList);
		for (Integer food_id : foodList) {
			insert(plate_id, food_id, Timestamp.valueOf(LocalDateTime.now()));
		}
		System.out.print("updateByPlateId");
	}


	public void deleteById(int plate_id) {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		PlateMapper mapper = sqlSession.getMapper(PlateMapper.class);
		mapper.deleteById(plate_id);
		sqlSession.commit();
		sqlSession.close();
	}

	public void insert(int plate_id, int food_id, Timestamp time){
		SqlSession sqlSession = sqlSessionFactory.openSession();
		PlateMapper mapper = sqlSession.getMapper(PlateMapper.class);
		mapper.insert(plate_id, food_id, time);
		sqlSession.commit();
		sqlSession.close();
	}

	public String selectById(int plate_id){
		SqlSession sqlSession = sqlSessionFactory.openSession();
		PlateMapper mapper = sqlSession.getMapper(PlateMapper.class);
		List<Plate> plates = mapper.selectById(plate_id);
		Result result = new Result(ResultCode.SUCCESS.getStatus(), plates);
		sqlSession.close();
		return JSON.toJSONString(result);
	}
}
