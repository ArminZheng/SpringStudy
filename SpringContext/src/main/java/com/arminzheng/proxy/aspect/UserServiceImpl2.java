package com.arminzheng.proxy.aspect;

import com.arminzheng.proxy.simple.User;
import com.arminzheng.proxy.simple.UserService;
import lombok.Getter;
import lombok.Setter;

/**
 * UserServiceImpl
 *
 * @author zy
 * @version 2022/4/20
 */
@Getter
@Setter
public class UserServiceImpl2 implements UserService {

    // @Autowired @Lazy // 真实环境使用左边👈
    UserServiceImpl2 userServiceImpl2;

    @Override
    public void register(User user) {
        System.out.println("UserServiceImpl2.register 业务运算 + dao 操作");
        // throw new RuntimeException("test exception!");
        userServiceImpl2.login("zhangshan", "wangwu");
    }

    @Override
    public boolean login(String name, String password) {
        System.out.println("UserServiceImpl2.login");
        return true;
    }
}
