package com.youdao.surpasscoding.controller;

import com.youdao.surpasscoding.dto.UserDTO;
import com.youdao.surpasscoding.entity.User;
import com.youdao.surpasscoding.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.Mapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

/**
 * @Description
 * @Author wzz
 * @Date 2019/10/12 15:29
 */
@RequestMapping("/api/user")
@RestController
public class UserApi {
    @Autowired
    private UserService userService;
    @RequestMapping("/addUser")
    public UserDTO addUser(@Valid UserDTO userDTO, BindingResult bindingResult){
        checkDTOParams(bindingResult);

        User user =  userDTO.convertToUser();
        User saveResultUser = userService.addUser(user);
        System.out.println(saveResultUser);
        UserDTO result = userDTO.convertFor(saveResultUser);
        return result;
    }

    private void checkDTOParams(BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            //throw new 带验证码的验证错误异常
            for (ObjectError error : bindingResult.getAllErrors()) {
                System.out.println(error.getDefaultMessage());
            }
        }
    }
}
