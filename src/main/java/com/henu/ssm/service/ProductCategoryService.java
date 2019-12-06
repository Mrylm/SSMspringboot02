package com.henu.ssm.service;

import com.henu.ssm.bean.ProductCategory;

import java.util.List;

/**
 * @author shkstart
 * @create 2019-09-23 15:27
 */
public interface ProductCategoryService {
    //查询全部类别
    public List<ProductCategory> selectCategories();

    //根据id查询
    public ProductCategory selectByPrimaryKey(Integer categoryId);

}
