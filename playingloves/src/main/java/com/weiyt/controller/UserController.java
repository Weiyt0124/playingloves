package com.weiyt.controller;

import com.weiyt.base.BaseController;
import com.weiyt.pojo.UserInfo;
import com.weiyt.service.UserService;
import com.weiyt.util.DateUtil;
import com.weiyt.util.FileInfo;
import com.weiyt.util.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author weiyt
 */
@Controller
@RequestMapping("user")
public class UserController extends BaseController {
    @Autowired
    UserService userService;
    /**
     *
     * @return
     */
    @RequestMapping("/findUserName")
    public @ResponseBody Map<String, Object> findUserName(HttpServletRequest request) {
       Map<String, Object> result = new HashMap<>(16);
        String nickName = (String) request.getSession().getAttribute("user");
        result.put("nickName",nickName);
        return result;
    }
    /**
     * 查询用户详情
     * @return
     */
    @RequestMapping("/findUserInfo")
    public @ResponseBody Map<String, Object> findUserInfo(HttpServletRequest request) {
       Map<String, Object> result = new HashMap<>(16);
        String id = (String) request.getSession().getAttribute("id");
        UserInfo userInfo = userService.findUserInfo(id);
        result.put("userInfo",userInfo);
        return result;
    }
    /**
     *
     * @return
     */
    @RequestMapping("/changePassword")
    public @ResponseBody  Boolean changePassword(HttpServletRequest request,@RequestParam Map<String,String> param) {
        param.put("id",(String) request.getSession().getAttribute("id"));
        return userService.changePassword(param);

    }
    /**
     * 存上传图片
     *
     * @return
     */
    @RequestMapping(value = "/updArtImg", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> updateArImg(@RequestParam("files[]") MultipartFile file, HttpServletRequest request) {
        Map<String, Object> param = new HashMap(16);
        Map<String, Object> resultMap = new HashMap(16);
        if (file.isEmpty()) {
            throw new RuntimeException("图片为空!");
        }
        String formatDate = DateUtil.formatDate(new Date(), "yyyyMMdd");
        if (!file.isEmpty()) {
            Calendar now = Calendar.getInstance();
            String imgPath = imagePath + now.get(Calendar.YEAR) + "/" + (now.get(Calendar.MONTH) + 1) + "/" + now.get(Calendar.DAY_OF_MONTH) + "/" + formatDate + "/";
            FileInfo fileInfo = FileUtils.uploadFile(file, imgPath);
            imgPath = imgPath + fileInfo.getId();
            String id = (String) request.getSession().getAttribute("id");
            param.put("id",id);
            param.put("avatar",imgPath);
            userService.saveAvatar(param);
            resultMap.put("filePath", imgPath);
            request.setAttribute("img", imgPath);
        }
        return resultMap;

    }

}