package com.youdao.surpasscoding.service.serviceImp;

import com.youdao.surpasscoding.entity.User;
import com.youdao.surpasscoding.service.UserService;
import com.youdao.surpasscoding.utils.DateUtils;
import org.springframework.stereotype.Service;

/**
 * @Description
 * @Author wzz
 * @Date 2019/10/12 15:30
 */
@Service
public class UserServiceImp implements UserService {
    @Override
    public User addUser(User user) {
        user.setCreateTime(DateUtils.getCurrentDateAndTimeFormat());
        user.setUpdateTime(DateUtils.getCurrentDateAndTimeFormat());
        user.setPassword("123456");
        return user;
    }
}
