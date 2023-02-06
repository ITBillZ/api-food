package cn.itbill.mapper;

import cn.itbill.pojo.Food;

import java.util.List;

public interface FoodMapper {
    List<Food> selectAll();

    Food selectById(int id);
}
