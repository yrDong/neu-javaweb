package com.yrd.json;

import com.alibaba.fastjson.JSON;
import com.yrd.pojo.User;

public class testjson {
    public static void main(String[] args) {
        User user = new User();
        user.setId(99);
        user.setName("lisi");
        user.setrole("学生");
        user.setUsername("008");
        user.setpassword("123");
        String jsonstring = JSON.toJSONString(user);
        System.out.println(jsonstring);

        //2.toobject
        User u = JSON.parseObject("{\"id\":99,\"name\":\"lisi\",\"password\":\"123\",\"role\":\"学生\",\"username\":\"008\"}",User.class);
        System.out.println(u);
    }
}
