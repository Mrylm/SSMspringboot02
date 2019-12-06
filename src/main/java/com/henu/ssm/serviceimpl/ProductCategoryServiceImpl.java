package com.henu.ssm.serviceimpl;

import com.henu.ssm.bean.ProductCategory;
import com.henu.ssm.bean.ProductCategoryExample;
import com.henu.ssm.dao.ProductCategoryMapper;
import com.henu.ssm.service.ProductCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author shkstart
 * @create 2019-09-23 15:35
 */
@Service
public class ProductCategoryServiceImpl implements ProductCategoryService {

    @Autowired
    public ProductCategoryMapper productCategoryMapper;
    @Override
    public List<ProductCategory> selectCategories() {
        List<ProductCategory> productCategories = productCategoryMapper.selectByExample(new ProductCategoryExample());
        return productCategories;
    }

    @Override
    public ProductCategory selectByPrimaryKey(Integer categoryId) {
        ProductCategory productCategory = productCategoryMapper.selectByPrimaryKey(categoryId);
        return productCategory;
    }


}

