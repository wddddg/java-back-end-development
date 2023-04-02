package cn.wddxhz.model;

import lombok.Data;

@Data
public class UpdataPassword {
    private String newPassword;
    private String oldPassword;
    private Integer userId;
}
