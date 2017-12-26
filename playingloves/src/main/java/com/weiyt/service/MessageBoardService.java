package com.weiyt.service;

import java.util.List;
import java.util.Map;

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
    List<Map<String,Object>> findReplyList();
}
