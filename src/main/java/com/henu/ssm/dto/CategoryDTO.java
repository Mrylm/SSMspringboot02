package com.henu.ssm.dto;/**
 * Created by Administrator on 2019/9/24 0024.
 */

import java.util.List;

/**
 * 该类用于封装部分类目信息，转换成json，对应：
 "name": "今日特价",
 "type": 1,
 "foods":
 * @author Administrator
 * @date 2019/9/24 0024 16:45
 * @description
 */
public class CategoryDTO {
    public String name;
    public Integer type;
    public List<ProductDTO> foods;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public List<ProductDTO> getFoods() {
        return foods;
    }

    public void setFoods(List<ProductDTO> foods) {
        this.foods = foods;
    }

    @Override
    public String toString() {
        return "CategoryDTO{" +
                "name='" + name + '\'' +
                ", type=" + type +
                ", foods=" + foods +
                '}';
    }
}
