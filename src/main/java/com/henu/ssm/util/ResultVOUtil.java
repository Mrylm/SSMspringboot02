package com.henu.ssm.util;/**
 * Created by Administrator on 2019/9/24 0024.
 */

import com.henu.ssm.vo.ResultVO;

/**
 * 该类是一个公共功能，用于把结果封装，转换成json
 * @author Administrator
 * @date 2019/9/24 0024 19:06
 * @description
 */
public class ResultVOUtil {
    /**返回成功信息*/
    public static ResultVO success(Object object){
        ResultVO result=new ResultVO();
        result.setCode(0);
        result.setMsg("成功");
        result.setData(object);
        return result;
    }
    /**返回成功信息*/
    public static ResultVO message(){
        ResultVO result=new ResultVO();
        result.setCode(0);
        result.setMsg("成功");
        return result;
    }
}
