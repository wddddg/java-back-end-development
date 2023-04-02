package cn.wddxhz.controller;

import cn.wddxhz.mapper.SystemMapper;
import cn.wddxhz.model.DataCount;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SystemController {

    @Autowired
    private SystemMapper systemMapper;

    @GetMapping("/queryAllLength")
    public DataCount queryAllLength(){
        DataCount dataCount = new DataCount();
        dataCount.setIsadminNumber(systemMapper.getIsadminNumber());
        dataCount.setTextNumber(systemMapper.getTextNumber());
        dataCount.setDelTextNumber(systemMapper.getDelTextNumber());
        dataCount.setUserNumber(systemMapper.getUserNumber());
        return dataCount;
    }

}
