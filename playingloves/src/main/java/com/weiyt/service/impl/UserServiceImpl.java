package com.weiyt.service.impl;

import com.weiyt.mapper.UserMapper;
import com.weiyt.pojo.UserInfo;
import com.weiyt.base.BaseService;
import com.weiyt.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

/**
 *  @author  Wyt
 */
@Service("UserServiceImpl")
public class UserServiceImpl extends BaseService<UserInfo> implements UserService {
    @Autowired
    UserMapper userMapper;

    @Override
    public Boolean changePassword(Map<String, String> param) {
        Integer i = userMapper.changePassword(param);
        if(i<1){
            return false;
        }
        return true;
    }

    @Override
    public Boolean saveAvatar(Map<String, Object> param) {

            int i = userMapper.saveAvatar(param);
            if(i<1){
                return false;
            }
            return true;
    }

    @Override
    public UserInfo findUserInfo(String id) {
        UserInfo param = new UserInfo();
        param.setId(id);
        UserInfo userInfo = super.queryOne(param);
        return userInfo;
    }


    @Override
    public Map<String, Object> login(Map<String, Object> param) {
        Map<String, Object> result = new HashMap<>(16);

        UserInfo userInfo = userMapper.findUserById(param);
        if(userInfo == null){
            result.put("message","用户名或密码错误!");
            result.put("flag",false);
            return result;
        }
        result.put("id",userInfo.getId());
        result.put("name",userInfo.getName());
        result.put("nickname",userInfo.getNickname());
        result.put("flag",true);
        return result;
    }

}
