package com.henu.ssm.service;

import com.henu.ssm.bean.SellerInfo;
import com.henu.ssm.bean.SellerInfoExample;

import java.util.List;
import java.util.Map;

/**
 * @author shkstart
 * @create 2019-09-23 15:28
 */
public interface SellerInfoService {
    //根据主键查询
    public SellerInfo selectByPrimaryKey(String id);
    //按条件查询
    public Map<String,Object> selectByExample(SellerInfoExample example, Integer pageNum, Integer pageSize);
    //根据主键删除
    public int deleteByPrimaryKey(String id);
    //根据id进行更新
    public int updateByPrimaryKeySelective(SellerInfo sellerInfo);
    //添加
    public int insert(SellerInfo sellerInfo);
}
