package cn.itbill.mapper;

import cn.itbill.pojo.Food;

import java.util.List;

public interface FoodMapper {
    List<Food> selectAllForList();

    Food selectById(int id);

    List<Food> selectTitleByKeyWord(String title);
}
