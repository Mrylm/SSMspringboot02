package com.henu.ssm.service;

import com.henu.ssm.bean.OrderDetail;
import com.henu.ssm.dto.CartFormDTO;
import com.henu.ssm.dto.CategoryDTO;

import java.util.List;

/**
 * @author shkstart
 * @create 2019-09-29 10:18
 */
public interface OrderDetailService {
    //添加商品详情
    public int insertDetail(OrderDetail orderDetail);
    //根据id查询商品详情
    public OrderDetail selectDetailById(String DetailId);
    //查询所有商品和类目，并转换成CartFormDTO对象，再封装成list对象
    public List<CartFormDTO> selectDetails();
    //添加商品和类目，并转换成CartFormDTO对象，再封装成list对象
    public int insertDetails(OrderDetail orderDetail);
    //更新商品
    public int updateOrderDetail(OrderDetail orderDetail);
}
