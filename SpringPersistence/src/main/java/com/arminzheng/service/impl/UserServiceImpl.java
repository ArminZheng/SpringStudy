package com.arminzheng.service.impl;

import com.arminzheng.domain.User;
import com.arminzheng.mapper.UserMapper;
import com.arminzheng.service.UserService;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.io.InputStream;

/**
 * @author armin
 * @description 针对表【base_user】的数据库操作Service实现
 * @createDate 2022-04-27 14:48:49
 */
@Service
public class UserServiceImpl implements UserService {
    public static void main(String[] args) throws IOException {
        InputStream resourceAsStream = Resources.getResourceAsStream("mybatis-config.xml");
        SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);

        SqlSession sqlSession = sessionFactory.openSession();

        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        mapper.save(new User());
    }
}
