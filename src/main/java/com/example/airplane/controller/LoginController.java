package com.example.airplane.controller;

import com.example.airplane.dto.UserDto;
import com.example.airplane.entity.User;
import com.example.airplane.repository.UserRepository;
import com.example.airplane.service.LoginService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;


@Controller
@RequiredArgsConstructor
public class LoginController {

    private final UserRepository userRepository;
    private final LoginService loginService;

    @GetMapping("/login")
    private String login(){
        return "index";
    }

    @PostMapping("/login")
    private String login(String id, String password, Model model, HttpServletRequest request){
        User user = loginService.login(id, password);
        if (user != null){
            HttpSession session = request.getSession();
            session.setAttribute("sessionUserName", user.getName());
            return "redirect:/main";
        }else {
            model.addAttribute("msg", "IDとかパスワードをご確認お願いします。");
            return "index";
        }
    }

    @GetMapping("/logout")
    private String logout(HttpServletRequest request, Model model){
        HttpSession session = request.getSession();
        session.invalidate();
        model.addAttribute("msg", "ログアウトされました。");
        return "index";
    }

    @GetMapping("/signup")
    private String signup(){
        return "signup";
    }

    @PostMapping("/signup")
    private String signup(UserDto userDto, Model model){
        boolean result = loginService.signup(userDto);
        if(!userDto.getPassword1().equals(userDto.getPassword2())){
            model.addAttribute("msg","パスワードが一致しません。");
            return "signup";
        }

        if(result){
            model.addAttribute("msg", "会員登録が完了になりました。");
            return "index";
        }else {
            model.addAttribute("msg", "もう一度確認お願いします。");
            return "signup";
        }
    }

    @GetMapping("/idcheck")
    private String moveIdCheck(){
        return "idcheck";
    }

    @PostMapping("/idcheck")
    private String idCheck(String id,Model model){
        boolean user = loginService.idCheck(id);
        if(user){
            model.addAttribute("msg", "使っているIDです");
        }else {
            model.addAttribute("msg", "使えるIDです");
        }
        return "idCheck";
    }

    @GetMapping("/emailcheck")
    private String moveEmailCheck(){
        return "emailcheck";
    }

    @PostMapping("/emailcheck")
    private String emailCheck(UserDto userDto, Model model){
        if (userRepository.existsByEmail(userDto.getEmail())){
            model.addAttribute("msg","使っているEmailです。");
        }else {
            model.addAttribute("msg","使えるEmailです。");
        }
        return "emailcheck";
    }
}
