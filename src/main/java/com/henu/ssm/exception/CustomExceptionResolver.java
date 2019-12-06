package com.henu.ssm.exception;
/**
 * Created by Administrator on 2019/9/20 0020.
 */
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 全局异常处理器
 * @author Administrator
 * @date 2019/9/20 0020 15:05
 * @description
 */
public class CustomExceptionResolver implements HandlerExceptionResolver {

    public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) {
        System.out.println("异常:"+ex);
        ModelAndView modelAndView=new ModelAndView();
        modelAndView.setViewName("error");
        return modelAndView;
    }
}
