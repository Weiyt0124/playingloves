package com.weiyt.mapper;

import com.github.abel533.mapper.Mapper;
import com.weiyt.pojo.UserInfo;
import org.apache.ibatis.annotations.Update;

import java.util.Map;

/**
 * @author Wyt
 */
public interface UserMapper extends Mapper<UserInfo> {

    int changePassword(Map<String, String> param);

    @Update("UPDATE user SET avatar =#{avatar} where id = #{id}")
    int saveAvatar(Map<String, Object> param);

    /***
     * 根据id查询用户
     */
    UserInfo findUserById(Map<String, Object> param);
}
