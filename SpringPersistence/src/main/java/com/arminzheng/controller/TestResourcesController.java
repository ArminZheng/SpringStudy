package com.arminzheng.controller;

import com.arminzheng.domain.User;
import com.arminzheng.mapper.UserMapper;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

/**
 * TestController
 *
 * @author zy
 * @version 2022/4/27
 */
@Slf4j
public class TestResourcesController {
    public static void main(String[] args) throws IOException {
        InputStream resourceAsStream = Resources.getResourceAsStream("mybatis-config.xml");
        SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);

        SqlSession sqlSession = sessionFactory.openSession();

        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        // insert(sqlSession, mapper);
        User select = select(mapper);
        log.info(" "+select);
        System.out.println("mapper.count() = " + mapper.count());
    }

    private static User select(UserMapper mapper) {
        User zhangshan = mapper.queryById("zhangshan");
        System.out.println("zhangshan = " + zhangshan);
        return zhangshan;
    }

    private static void insert(SqlSession sqlSession, UserMapper mapper) {
        int save = mapper.save(User.getInstance());
        System.out.println("save = " + save);
        sqlSession.commit();
    }
}
