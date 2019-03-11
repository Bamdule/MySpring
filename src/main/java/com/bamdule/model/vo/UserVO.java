/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bamdule.model.vo;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import org.hibernate.validator.constraints.NotBlank;

/**
 *
 * @author MW
 */
public class UserVO {

    @NotNull
    private Integer no;

    @NotBlank(message = "name is not Blank")
    private String name;

    @NotBlank(message = "email is not Blank")
//    @Email
    private String email;

    @NotBlank(message = "pwd is not Blank")
    @Pattern(regexp = "(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[!@#$%^&+=])(?=\\S+$).{8,}")
    private String pwd;

    @NotBlank(message = "gender is not Blank")
    private String gender;

    @NotBlank(message = "regDate is not Blank")
    private String regDate;

    public Integer getNo() {
        return no;
    }

    public void setNo(Integer no) {
        this.no = no;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getRegDate() {
        return regDate;
    }

    public void setRegDate(String regDate) {
        this.regDate = regDate;
    }

    @Override
    public String toString() {
        return "UserVO{" + "no=" + no + ", name=" + name + ", email=" + email + ", pwd=" + pwd + ", gender=" + gender + ", regDate=" + regDate + '}';
    }

}
