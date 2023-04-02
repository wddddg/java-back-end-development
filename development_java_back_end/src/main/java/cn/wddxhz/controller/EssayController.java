package cn.wddxhz.controller;


import cn.wddxhz.mapper.EssayMapper;
import cn.wddxhz.model.DelText;
import cn.wddxhz.model.Essay;
import cn.wddxhz.util.ResultJson;
import cn.wddxhz.util.Upload;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
public class EssayController {

    @Autowired
    private EssayMapper essayMapper;

    @GetMapping("/queryText")
    public List<Essay> queryEssayList(Integer userId){
        if(userId!=null){
            return essayMapper.getEssayListByUserId(userId);
        }
        return essayMapper.getEssayList();
    }

    @PostMapping("/addText")
    public ResultJson addEssay(
            @RequestBody MultipartFile avatar,
            String content,
            Integer userId,
            String title,
            String username,
            String contentHTML,
            HttpServletRequest req
            ){
        String filePath = new Upload().upload(avatar, req);
        Essay essay = new Essay();
        essay.setContent(content);
        essay.setContentHTML(contentHTML);
        essay.setImg(filePath);
        essay.setTitle(title);
        essay.setUsername(username);
        essay.setUserId(userId);
        return new ResultJson(200,"新增成功",essayMapper.addEssay(essay));
    }

    @PostMapping("/updataText")
    public ResultJson updataEssay(
            @RequestBody MultipartFile avatar,
            String content,
            Integer userId,
            String title,
            Integer textId,
            String contentHTML,
            String img,
            HttpServletRequest req
    ){
        Essay essay = new Essay();
        if(avatar != null){
            String filePath = new Upload().upload(avatar, req);
            essay.setImg(filePath);
        }else{
            essay.setImg(img);
        }
        essay.setContent(content);
        essay.setContentHTML(contentHTML);
        essay.setTitle(title);
        essay.setId(textId);
        essay.setUserId(userId);
        return new ResultJson(200,"新增成功",essayMapper.updataEssay(essay));
    }

    @PostMapping("/delText")
    public ResultJson delEssay(
            @RequestBody DelText delText
    ){
        return new ResultJson(200,"删除成功",essayMapper.delEssayById(delText.getTextId()));
    }



}
