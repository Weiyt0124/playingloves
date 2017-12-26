package com.weiyt.mapper;

import com.github.abel533.mapper.Mapper;
import com.weiyt.pojo.MessageBoard;

import java.util.List;
import java.util.Map;

/**
 * @author 艾泽拉斯国家地理
 * @create 2017/12/25
 */
public interface MessageBoardMapper extends Mapper<MessageBoard> {
    List<Map<String,Object>> findReplyList();
}
