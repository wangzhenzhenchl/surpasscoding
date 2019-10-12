package com.youdao.surpasscoding.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @Description
 * @Author wzz
 * @Date 2019/10/12 15:37
 */
@NoArgsConstructor
@AllArgsConstructor
@Data
public class User {
    private String username;
    private Integer age;
    private String password;
    private String createTime;
    private String updateTime;
}
