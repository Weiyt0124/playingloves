package com.weiyt.service;

import com.weiyt.pojo.MessageBoard;

import java.util.List;

/**
 * @author 艾泽拉斯国家地理
 * @create 2017/12/25
 */
public interface MessageBoardService {
    /**
     * 查询留言板
     * @param
     * @return
     * @Author Wyt
     */
    List<MessageBoard> queryAll(Class<MessageBoard> messageBoardClass);
}
