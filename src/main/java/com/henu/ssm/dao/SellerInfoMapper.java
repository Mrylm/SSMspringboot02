package com.henu.ssm.dao;

import com.henu.ssm.bean.SellerInfo;
import com.henu.ssm.bean.SellerInfoExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface SellerInfoMapper {
    int countByExample(SellerInfoExample example);

    int deleteByExample(SellerInfoExample example);

    int deleteByPrimaryKey(String id);

    int insert(SellerInfo record);

    int insertSelective(SellerInfo record);

    List<SellerInfo> selectByExample(SellerInfoExample example);

    SellerInfo selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") SellerInfo record, @Param("example") SellerInfoExample example);

    //根据条件更新完全
    int updateByExample(@Param("record") SellerInfo record, @Param("example") SellerInfoExample example);

    //根据id可更新一部分(非空属性)
    int updateByPrimaryKeySelective(SellerInfo record);

    //根据id更新全部
    int updateByPrimaryKey(SellerInfo record);
}