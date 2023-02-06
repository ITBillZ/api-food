package cn.itbill;

import cn.itbill.mapper.FoodMapper;
import cn.itbill.pojo.Food;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class UnitTest {
    @Test
    public void testSelectAll() throws IOException {
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        SqlSession sqlSession = sqlSessionFactory.openSession();

        FoodMapper foodMapper = sqlSession.getMapper(FoodMapper.class);
        List<Food> foods = foodMapper.selectAll();
        System.out.println(foods);

        sqlSession.close();
    }
}
