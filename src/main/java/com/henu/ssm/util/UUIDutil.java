package com.henu.ssm.util;

import java.util.UUID;

/**
 * @author shkstart
 * @create 2019-09-24 15:56
 */
public class UUIDutil {
    public static String getUUID(){
        String uuid = UUID.randomUUID().toString();
        String result =  uuid.replace("-","");
        return result;

    }

    public static void main(String[] args) {
        System.out.println(UUIDutil.getUUID());
    }
}

