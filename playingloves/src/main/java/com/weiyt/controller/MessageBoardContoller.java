package com.weiyt.controller;

import com.weiyt.base.BaseController;
import com.weiyt.pojo.MessageBoard;
import com.weiyt.service.MessageBoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @author 艾泽拉斯国家地理
 * @create 2017/12/25
 */
@Controller
@RequestMapping("messageBoard")
public class MessageBoardContoller extends BaseController {
    @Autowired
    MessageBoardService messageBoardService;

    @RequestMapping(value = "replyList", method = RequestMethod.GET)
    @ResponseBody
    public List<MessageBoard> findReplyList() {
        List<MessageBoard> result = messageBoardService.queryAll(MessageBoard.class);
        return result;
    }
}
