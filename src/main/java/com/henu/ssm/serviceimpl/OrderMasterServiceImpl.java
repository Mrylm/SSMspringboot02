package com.henu.ssm.serviceimpl;

import com.henu.ssm.bean.OrderMaster;
import com.henu.ssm.bean.OrderMasterExample;
import com.henu.ssm.dao.OrderMasterMapper;
import com.henu.ssm.service.OrderMasterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author shkstart
 * @create 2019-09-29 10:17
 */
@Service
public class OrderMasterServiceImpl implements OrderMasterService {
    @Autowired
    public OrderMasterMapper orderMasterMapper;

    //添加订单
    @Override
    public int insertMaster(OrderMaster orderMaster) {
        return orderMasterMapper.insert(orderMaster);
    }

    //根据id查询订单
    @Override
    public OrderMaster selectMasterById(String orderId) {
        return orderMasterMapper.selectByPrimaryKey(orderId);
    }

    //查询全部订单
    @Override
    public List<OrderMaster> selectAllMaster() {
        return orderMasterMapper.selectByExample(new OrderMasterExample());
    }

    //更新订单
    @Override
    public int updateMaster(OrderMaster orderMaster) {
        return orderMasterMapper.updateByPrimaryKey(orderMaster);
    }
}

