package com.henu.ssm.controller;/**
 * Created by Administrator on 2019/9/24 0024.
 */


import com.henu.ssm.bean.ProductInfo;
import com.henu.ssm.bean.ProductInfoExample;
import com.henu.ssm.dto.CategoryDTO;
import com.henu.ssm.service.ProductInfoService;
import com.henu.ssm.util.ResultVOUtil;
import com.henu.ssm.vo.ResultVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 商品控制器
 * @author Administrator
 * @date 2019/9/24 0024 16:34
 * @description
 */
@Controller
public class ProductController {
    //注入商品业务层对象
    @Autowired
    public ProductInfoService productService;
    @ResponseBody
    @RequestMapping("/selectProducts")
    public ResultVO selectProducts(){
        //查询类目及其所属商品信息
        List<CategoryDTO> categoryDTOS = productService.selectProducts();
        return ResultVOUtil.success(categoryDTOS);
    }

    //查询全部商品
    @RequestMapping("/selectProduct")
    @ResponseBody
    public Map<String,Object> selectAllproduct(Integer page,Integer rows){
        Map<String,Object> map =productService.selectProductInfo(new ProductInfoExample(),page,rows);
        return  map;

    }



    //将数据库中的状态码取反
    @RequestMapping("/updateStatus")
    @ResponseBody
    public int selectstatus(String productId) throws SQLException{
        //将前端输入的id用后台进行接收
        ProductInfo productInfo = productService.selectByPrimaryKey(productId);
        //先根据前端输入的id查询获得一条数据，然后获得该条数据的状态码
      int i =  productService.selectByPrimaryKey(productId).getProductStatus();
        //将状态码取反
        if (i==0){
            productInfo.setProductStatus(1);
        }else {
            productInfo.setProductStatus(0);
        }
        //然后进行更新
        productService.updateByPrimaryKeySelective(productInfo);

        return i;
    }


    //加空跳转
    @RequestMapping("/productList")
    public String turn(){
        System.out.println("product");
        return "productinfo";
    }

    //根据id删除商品
    @ResponseBody
    @RequestMapping("/delProduct")
    public Map<String,Boolean> deleteByPrimaryKey(String productId){
        Map<String,Boolean> map = new HashMap<>();
        int  i = productService.deleteByPrimaryKey(productId);
        if(i<1){
            System.out.println("失败");
            map.put("success",false);
            return map;
        }
        System.out.println("成功");
        map.put("success",true);
        return map;
    }

    //插入数据
    @ResponseBody
    @RequestMapping("/insertProduct")
    public  boolean inset(ProductInfo productInfo){
        int i =productService.insert(productInfo);
        if(i<1){
            return false;
        }
        return  true;
    }

    //更新
    @RequestMapping("/updateProduct")
    @ResponseBody
    public Boolean updateByPrimaryKeySelective(ProductInfo productInfo ){
        int i = productService.updateByPrimaryKeySelective(productInfo );
        if(i<1){
            return false;
        }
        return  true;
    }


}


