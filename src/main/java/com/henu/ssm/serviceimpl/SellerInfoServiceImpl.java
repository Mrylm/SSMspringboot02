package com.henu.ssm.serviceimpl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.henu.ssm.bean.SellerInfo;
import com.henu.ssm.bean.SellerInfoExample;
import com.henu.ssm.dao.SellerInfoMapper;
import com.henu.ssm.service.SellerInfoService;
import com.henu.ssm.util.UUIDutil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author shkstart
 * @create 2019-09-23 15:36
 */
@Service
@Transactional
public class SellerInfoServiceImpl implements SellerInfoService {
    //注入dao层
    @Autowired
    public SellerInfoMapper sellerInfoMapper;

    //根据id查询
    @Override
    public SellerInfo selectByPrimaryKey(String id) {
        return sellerInfoMapper.selectByPrimaryKey(id);
    }

    //查询全部
    @Override
    public Map<String, Object> selectByExample(SellerInfoExample example, Integer pageNum, Integer pageSize) {
        //设置分页信息
        PageHelper.startPage(pageNum, pageSize);
        //设置排序id排序
        example.setOrderByClause("id asc");
        //执行查询
        List<SellerInfo> list = sellerInfoMapper.selectByExample(example);
        //获取分页信息
        PageInfo<SellerInfo> pageInfo = new PageInfo<SellerInfo>(list);
        Map<String, Object> map = new HashMap<>();
        //获取总记录数
        map.put("total", pageInfo.getTotal());
        map.put("rows", pageInfo.getList());
        return map;
    }


    //根据主键删除
    @Override
    public int deleteByPrimaryKey(String id) {
        return sellerInfoMapper.deleteByPrimaryKey(id);
    }

    //根据id查询
    @Override
    public int updateByPrimaryKeySelective(SellerInfo sellerInfo) {
        return sellerInfoMapper.updateByPrimaryKeySelective(sellerInfo);
    }

    //插入数据
    @Override
    public int insert(SellerInfo sellerInfo) {
        sellerInfo.setUpdateTime(new Date());
        sellerInfo.setCreateTime(new Date());
        sellerInfo.setId(UUIDutil.getUUID());
        return sellerInfoMapper.insert(sellerInfo);
    }
}

