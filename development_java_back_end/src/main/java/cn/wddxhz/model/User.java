package cn.wddxhz.model;


import lombok.Data;

@Data
public class User {

    private Integer id;
    private String username;
    private String password;
    private String icon;
    private String isadmin;
}
