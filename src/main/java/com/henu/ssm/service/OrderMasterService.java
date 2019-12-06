package com.henu.ssm.service;

import com.henu.ssm.bean.OrderMaster;

import java.util.List;

/**
 * @author shkstart
 * @create 2019-09-29 10:17
 */
public interface OrderMasterService {
    //添加订单
    public int insertMaster(OrderMaster orderMaster);
    //根据id查询订单
    public OrderMaster selectMasterById(String orderId);
    //查询所有订单
    public List<OrderMaster> selectAllMaster();
    //更新订单
    public int updateMaster(OrderMaster orderMaster);
}

