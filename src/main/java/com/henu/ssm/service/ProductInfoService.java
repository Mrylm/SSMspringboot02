package com.henu.ssm.service;
import com.henu.ssm.bean.ProductInfo;
import com.henu.ssm.bean.ProductInfoExample;
import com.henu.ssm.bean.SellerInfoExample;
import com.henu.ssm.dto.CategoryDTO;

import java.util.List;
import java.util.Map;

/**
 * @author shkstart
 * @create 2019-09-23 15:28
 */
public interface ProductInfoService {
    //查询所有商品和类目，并转换成CategoryDTO对象，再封装成list对象
    public List<CategoryDTO> selectProducts();
    //查询所有商品
    public Map<String,Object> selectProductInfo(ProductInfoExample example, Integer pageNum, Integer pageSize);
    //根据主键删除
    public int deleteByPrimaryKey(String productId);
    //条件更新操作
    public int updateByPrimaryKeySelective(ProductInfo productInfo);
    //添加
    public int insert(ProductInfo productInfo);
    //根据id查询
    public ProductInfo selectByPrimaryKey(String productId);
}
