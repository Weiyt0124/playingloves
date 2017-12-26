package com.weiyt.service.impl;

import com.weiyt.base.BaseService;
import com.weiyt.mapper.MessageBoardMapper;
import com.weiyt.pojo.MessageBoard;
import com.weiyt.service.MessageBoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @author 艾泽拉斯国家地理
 * @create 2017/12/25
 */
@Service("MessageBoardServiceImpl")
public class MessageBoardServiceImpl extends BaseService<MessageBoard> implements MessageBoardService {
    @Autowired
    MessageBoardMapper messageBoardMapper;

    @Override
    public List<Map<String, Object>> findReplyList() {

        return messageBoardMapper.findReplyList();
    }
}
