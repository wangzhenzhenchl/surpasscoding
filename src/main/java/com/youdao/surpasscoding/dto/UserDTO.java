package com.youdao.surpasscoding.dto;

import com.sun.istack.internal.NotNull;
import com.youdao.surpasscoding.dtoConvert.DTOConvert;
import com.youdao.surpasscoding.entity.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;
import org.hibernate.validator.constraints.Length;
import org.springframework.beans.BeanUtils;

import javax.validation.constraints.NotBlank;

/**
 * @Description
 * @Author wzz
 * @Date 2019/10/12 15:33
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
public class UserDTO {
    @NotBlank(message = "用户名不能为空")
    @Length(min=2,message ="用户名长度最小为1" )
    private String username;
    @NotNull
    private Integer age;

    public User convertToUser(){
        UserDTOConvert userDTOConvert = new UserDTOConvert();
        User convert = userDTOConvert.doForward(this);
        return convert;
    }

    public UserDTO convertFor(User user){
        UserDTOConvert userDTOConvert = new UserDTOConvert();
        UserDTO convert = userDTOConvert.doBackward(user);
        return convert;
    }

    private static class UserDTOConvert implements DTOConvert<UserDTO,User> {
        @Override
        public User doForward(UserDTO userDTO) {
            User user = new User();
            BeanUtils.copyProperties(userDTO,user);
            return user;
        }

        @Override
        public UserDTO doBackward(User user) {
//            throw new AssertionError("不支持逆向转化方法!");
            UserDTO userDTO = new UserDTO();
            BeanUtils.copyProperties(user,userDTO);
            return userDTO;
        }
    }
}
