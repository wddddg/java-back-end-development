package cn.wddxhz.mapper;


import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface SystemMapper {

    Integer getTextNumber();
    Integer getUserNumber();
    Integer getIsadminNumber();
    Integer getDelTextNumber();

}
