package com.tongji.controller;

import com.tongji.VO.ResultVO;
import com.tongji.domain.UserInfo;
import com.tongji.service.MailService;
import com.tongji.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.Random;

@RestController
@RequestMapping(value = "/user")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    TemplateEngine templateEngine;

    @Autowired
    MailService mailService;


    @RequestMapping(value = "/login",method = RequestMethod.POST)
    public ResultVO lonIn(@RequestParam("account") String account, @RequestParam("password") String password,HttpServletRequest httpServletRequest){
        UserInfo user=userService.find(account);
        ResultVO resultVO=new ResultVO();
        if (user==null){
            resultVO.setState(0);
            resultVO.setMsg("账号不存在");
            resultVO.setData(null);
        }
        else if(user.getPassword().equals(password)){
            resultVO.setState(1);
            resultVO.setMsg("登录成功");
            resultVO.setData(user);
            HttpSession session=httpServletRequest.getSession(true);
            session.setAttribute("account",account);
        }
        else{
            resultVO.setState(0);
            resultVO.setMsg("密码错误");
            resultVO.setData(null);
        }
        return resultVO;
    }

    @RequestMapping(value = "/logup",method = RequestMethod.PUT)
    public ResultVO logUp(@RequestParam("account") String account,@RequestParam("password") String password,@RequestParam("username") String username,HttpServletRequest httpServletRequest){
        ResultVO resultVO=new ResultVO();
        UserInfo user=userService.find(account);
        if (user!=null){
            resultVO.setData(null);
            resultVO.setMsg("账号已被注册");
            resultVO.setState(0);
        }
        else{
            user=new UserInfo();
            user.setPassword(password);
            user.setAccount(account);
            user.setUsername(username);
            userService.add(user);
            resultVO.setState(1);
            resultVO.setMsg("注册成功");
            resultVO.setData(user);
            HttpSession session=httpServletRequest.getSession(true);
            session.setAttribute("account",account);
        }
        return resultVO;
    }

    @RequestMapping(value = "/update", method = RequestMethod.PATCH)
    public ResultVO updateInfo(@RequestParam("company") String company,
                               @RequestParam("company_size") String company_size,
                               @RequestParam("job") String job,
                               @RequestParam("username") String username,
                               HttpServletRequest request) {

        String account = (String)request.getSession(false).getAttribute("account");

        ResultVO resultVO = new ResultVO();
        UserInfo user = userService.find(account);
        user.setCompany(company);
        user.setCompany_size(company_size);
        user.setJob(job);
        user.setUsername(username);
        userService.update(user);
        resultVO.setState(1);
        resultVO.setMsg("修改成功");
        resultVO.setData(user);
        return resultVO;
    }

    @RequestMapping(value = "/out", method = RequestMethod.GET)
    public ResultVO LogOut(HttpServletRequest request) {
        HttpSession session=request.getSession(false);
        session.removeAttribute("account");
        ResultVO resultVO = new ResultVO();
        resultVO.setState(1);
        resultVO.setMsg("成功");
        resultVO.setData(null);
        return resultVO;
    }

    @RequestMapping(value = "/verification", method = RequestMethod.GET)
    public ResultVO verification(HttpServletRequest request) {

        String account = (String)request.getSession(false).getAttribute("account");
        System.out.println(account);
        ResultVO resultVO = new ResultVO();
        String str = "01234567890qwertyuiopasdfghjklzxcvbnm";
        StringBuilder stringBuilder = new StringBuilder();
        int index;
        Random random = new Random();
        for (int i = 0; i < 6; ++i) {
            index = random.nextInt(36);
            stringBuilder.append(str.charAt(index));
        }
        System.out.println(stringBuilder.toString());
        UserInfo user = userService.find(account);
        System.out.println(user);
        Context context = new Context();
        context.setVariable("token", stringBuilder.toString());
        context.setVariable("username", user.getUsername());
        String emailContent = templateEngine.process("email.html",context);
        System.out.println(emailContent);
        System.out.println(context.getVariable("username"));
        if (mailService.sendSimpleMail(account,"您正在修改APM网站密码",emailContent)) {
            resultVO.setState(1);
            resultVO.setMsg("成功");
            resultVO.setData(stringBuilder.toString());
        }
        else {
            resultVO.setState(0);
            resultVO.setMsg("失败");
            resultVO.setData(null);
        }
        return resultVO;
    }

    @RequestMapping(value = "/update/password", method = RequestMethod.PATCH)
    public ResultVO updatePassword(@RequestParam("password") String password,
                                   HttpServletRequest request) {

        String account =(String)request.getSession(false).getAttribute("account");

        ResultVO resultVO = new ResultVO();
        UserInfo user = userService.find(account);
        user.setPassword(password);
        userService.updatePassword(user);
        resultVO.setState(1);
        resultVO.setMsg("修改成功");
        resultVO.setData(user);
        return resultVO;
    }
}
