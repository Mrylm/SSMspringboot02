package com.henu.ssm.controller;

import com.henu.ssm.bean.SellerInfo;
import com.henu.ssm.bean.SellerInfoExample;
import com.henu.ssm.service.SellerInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

/**
 * @author shkstart
 * @create 2019-09-23 20:35
 */
@Controller
public class SellerInfoController {
    //注入业务层
    @Autowired
    public SellerInfoService service;

    //根据id查询
    @RequestMapping("/selectByPrimaryKey")
    @ResponseBody
    public SellerInfo selectByPrimaryKey(@RequestParam("id") String id){
        return service.selectByPrimaryKey(id);
    }

    //查询全部
    @RequestMapping("/selectSeller")
    @ResponseBody
    public Map<String,Object> selectByExample(Integer page,Integer rows){
        Map<String,Object> map = service.selectByExample(new SellerInfoExample(),page,rows);
        return  map;
    }

    //加空跳转
    @RequestMapping("/sellerList")
    public String turn(){
        //System.out.println("seller");
        return "productinfo";
    }

    //根据id删除
    @ResponseBody
    @RequestMapping("/delSeller")
    public Map<String,Boolean> deleteByPrimaryKey(String id){
        Map<String,Boolean> map = new HashMap<>();
        int  i = service.deleteByPrimaryKey(id);
        if(i<1){
            map.put("success",false);
            return map;
        }
        map.put("success",true);
        return map;
    }

    //插入数据
    @ResponseBody
    @RequestMapping("/insertSeller")
    public  boolean inset(SellerInfo sellerInfo){
        int i =service.insert(sellerInfo);
        if(i<1){
            return false;
        }
        return  true;
    }

    //更新
    @RequestMapping("/updateSeller")
    @ResponseBody
    public Boolean updateByPrimaryKeySelective(SellerInfo sellerInfo){
        int i = service.updateByPrimaryKeySelective(sellerInfo);
        if(i<1){
            return false;
        }
              return  true;
    }
}

