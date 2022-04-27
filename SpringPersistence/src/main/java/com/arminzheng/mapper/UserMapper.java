package com.arminzheng.mapper;

import com.arminzheng.domain.User;

/**
 * @author armin
 * @description 针对表【base_user】的数据库操作Mapper
 * @createDate 2022-04-27 14:48:49 @Entity com.arminzheng.domain.BaseUser
 */
public interface UserMapper {
    int save(User user);
}
