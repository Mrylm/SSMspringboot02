package com.henu.ssm.serviceimpl;

import com.henu.ssm.bean.OrderDetail;
import com.henu.ssm.bean.OrderDetailExample;
import com.henu.ssm.bean.OrderMaster;
import com.henu.ssm.dao.OrderDetailMapper;
import com.henu.ssm.dto.CartFormDTO;
import com.henu.ssm.dto.OrderFormDTO;
import com.henu.ssm.service.OrderDetailService;
import com.henu.ssm.service.OrderMasterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author shkstart
 * @create 2019-09-29 10:19
 */
@Service
public class OrderDetailServiceImpl implements OrderDetailService {
    @Autowired
    //注入商品的所属订单(业务层)
    public OrderMasterService orderMasterService;

    @Autowired
    //注入商品接口
    public OrderDetailMapper orderDetailMapper;


    //查询商品的详情及其所属的订单
    @Override
    public List<CartFormDTO> selectDetails() {
        //查询所有商品及其所属订单
        List<CartFormDTO> cartFormDTOList = new ArrayList<>();
        //查看所有订单
        List<OrderMaster> orderMasterList = new ArrayList<>();
        //遍历订单,向CartFormDTO添加订单信息
        for (OrderMaster masterService : orderMasterList) {
            CartFormDTO cartFormDTO = new CartFormDTO();
            cartFormDTO.setBuyerName(masterService.getBuyerName());
            cartFormDTO.setBuyerAddress(masterService.getBuyerAddress());
            cartFormDTO.setBuyerOpenid(masterService.getBuyerOpenid());
            //获取order_id
            String orderId = masterService.getOrderId();
            //根据订单号查询订单中的商品信息
            OrderDetailExample orderDetailExample = new OrderDetailExample();
            OrderDetailExample.Criteria criteria = orderDetailExample.createCriteria();
            criteria.andOrderIdEqualTo(orderId);
            //商品查询
            List<OrderDetail> orderDetails = orderDetailMapper.selectByExample(orderDetailExample);
            //封装CartFormDTO集合
            List<CartFormDTO> list = new ArrayList<>();
            //将商品加入到CartFormDTO中
            for (CartFormDTO formDTO : list) {
                OrderDetail orderDetail = new OrderDetail();
                formDTO.setItems(orderDetail.getProductId() + "," + orderDetail.getProductQuantity());
                //把当前类下的商品封装到一个list对象中
                cartFormDTOList.add(cartFormDTO);
            }
            OrderFormDTO orderFormDTO = new OrderFormDTO();
            //orderFormDTO.setItems(cartFormDTOList);
           //封装CartFormDTO
        }

        return null;
    }

    //添加商品的详情及其所属的订单
    @Override
    public int insertDetails(OrderDetail orderDetail) {

        return orderDetailMapper.insert(orderDetail);
    }

    //更新商品
    @Override
    public int updateOrderDetail(OrderDetail orderDetail) {
        return orderDetailMapper.updateByPrimaryKey(orderDetail);
    }

    //添加商品详情
    @Override
    public int insertDetail(OrderDetail orderDetail) {
        return orderDetailMapper.insert(orderDetail);
    }

    //根据id查询商品详情
    @Override
    public OrderDetail selectDetailById(String detailId) {
        return orderDetailMapper.selectByPrimaryKey(detailId);
    }


}

