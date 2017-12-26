package com.weiyt.controller;

import com.weiyt.base.BaseController;
import com.weiyt.service.MessageBoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;

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
    public ResponseEntity< List<Map<String, Object>>> findReplyList() {

        try {
            List<Map<String,Object>> result = messageBoardService.findReplyList();
            return ResponseEntity.ok(result);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
    }
}
