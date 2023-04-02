package cn.wddxhz.model;


import lombok.Data;

@Data
public class Essay {

    private Integer id;
    private String title;
    private String username;
    private Integer userId;
    private String contentHTML;
    private String content;
    private String img;
    private Integer isDel;
}
