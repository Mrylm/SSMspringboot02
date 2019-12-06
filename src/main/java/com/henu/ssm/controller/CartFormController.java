package com.henu.ssm.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;
import com.henu.ssm.bean.OrderDetail;
import com.henu.ssm.bean.OrderMaster;
import com.henu.ssm.bean.ProductInfo;
import com.henu.ssm.dto.CartFormDTO;
import com.henu.ssm.dto.OrderFormDTO;
import com.henu.ssm.service.OrderDetailService;
import com.henu.ssm.service.OrderMasterService;
import com.henu.ssm.service.ProductInfoService;
import com.henu.ssm.util.UUIDutil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;

/**
 * @author shkstart
 * @create 2019-09-29 10:15
 */
@Controller
public class CartFormController {
    @Autowired
    //注入菜品业务层
    public ProductInfoService productInfoService;
    @Autowired
    //注入订单中菜品业务层
    public OrderDetailService orderDetailService;
    @Autowired
    //注入订单业务层
    public OrderMasterService orderMasterService;


    @RequestMapping("/orderCreate")
    @ResponseBody
    public String crateOrder(CartFormDTO cartFormDTO) throws IOException {
        System.out.println(cartFormDTO);
        String items = cartFormDTO.getItems();
        OrderMaster orderMaster = new OrderMaster();
        orderMaster.setOrderId(UUIDutil.getUUID());
        orderMaster.setBuyerName(cartFormDTO.getBuyerName());
        orderMaster.setBuyerPhone(cartFormDTO.getBuyerPhone());
        orderMaster.setBuyerAddress(cartFormDTO.getBuyerAddress());
        orderMaster.setBuyerOpenid(cartFormDTO.getBuyerOpenid());
        orderMaster.setOrderAmount(new BigDecimal(100));
        orderMaster.setOrderStatus((byte) 0);
        orderMaster.setPayStatus((byte) 0);
        orderMaster.setCreateTime(new Date());
        orderMaster.setUpdateTime(new Date());
        orderMasterService.insertMaster(orderMaster);
        //fastjson
        ArrayList<OrderFormDTO> userList =
                JSON.parseObject(items, new TypeReference<ArrayList<OrderFormDTO>>() {
                });
        for (OrderFormDTO orderFormDTO : userList) {
            System.out.println(orderFormDTO);
            //根据订单中的productid找到菜品
           ProductInfo productInfo= productInfoService.selectByPrimaryKey(orderFormDTO.getProductId());
            OrderDetail orderDetail = new OrderDetail();
            orderDetail.setDetailId(UUIDutil.getUUID());
            orderDetail.setOrderId(orderMaster.getOrderId());
            orderDetail.setProductId(productInfo.getProductId());
            orderDetail.setProductName(productInfo.getProductName());
            orderDetail.setProductPrice(productInfo.getProductPrice());
            orderDetail.setProductQuantity(Integer.parseInt(orderFormDTO.getProductQuantity()));
            orderDetail.setProductIcon(productInfo.getProductIcon());
            orderDetail.setCreateTime(new Date());
            orderDetail.setUpdateTime(new Date());
            orderDetailService.insertDetail(orderDetail);
        }
        return "成功";
    }

}

