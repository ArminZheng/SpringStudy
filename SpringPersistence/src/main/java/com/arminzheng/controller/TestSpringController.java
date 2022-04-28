package com.arminzheng.controller;

import com.arminzheng.domain.User;
import com.arminzheng.mapper.UserMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * TestSpringController
 *
 * @author zy
 * @version 2022/4/28
 */
@Slf4j
public class TestSpringController {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context =
                new ClassPathXmlApplicationContext("/applicationContextMybatis.xml");
        UserMapper userMapper = context.getBean("userMapper", UserMapper.class);
        log.info(userMapper.count() + "");
        User zhangshan = userMapper.queryById("zhangshan");
        log.info("zhangshan = " + zhangshan);
    }
}
