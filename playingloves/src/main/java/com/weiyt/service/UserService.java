package com.weiyt.service;


import com.weiyt.pojo.UserInfo;

import java.util.Map;

/**
 * @author weiyt
 */
public interface UserService {
    /**
     * 修改密码
     *
     * @param param
     * @return boolean
     * @Author Wyt
     */
    Boolean changePassword(Map<String, String> param);

    /**
     * 保存头像
     *
     * @param param
     * @return boolean
     * @Author Wyt
     */
    Boolean saveAvatar(Map<String, Object> param);

    /**
     * 查找用户详情
     *
     * @param id
     * @return UserInfo
     * @Author Wyt
     */
    UserInfo findUserInfo(String id);

    /**
     * 登陆
     *
     * @param param
     * @return map
     * @Author Wyt
     */
    Map<String, Object> login(Map<String, Object> param);
}
