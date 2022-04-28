package com.arminzheng.mapper;

import com.arminzheng.domain.User;

/**
 * 针对表 base_user 的数据库操作Mapper
 *
 * @author armin
 */
public interface UserMapper {
    int save(User user);

    User queryById(String loginId);

    long count();
}
