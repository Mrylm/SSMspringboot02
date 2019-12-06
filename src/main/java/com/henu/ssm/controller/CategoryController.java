package com.henu.ssm.controller;

import com.henu.ssm.bean.ProductCategory;
import com.henu.ssm.service.ProductCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @author shkstart
 * @create 2019-09-28 16:48
 */
@Controller
public class CategoryController {
    @Autowired
    public ProductCategoryService productCategoryService;

    @RequestMapping("/selectAllCate")
    @ResponseBody
    public List<ProductCategory> selectAllCategory(){
        List<ProductCategory> result = productCategoryService.selectCategories();
        return  result;
    }

    @RequestMapping("/selectCategoryById")
    public ProductCategory selectCategoryById(Integer categoryId){
        ProductCategory productCategory = productCategoryService.selectByPrimaryKey(categoryId);
        return  productCategory;
    }
}

