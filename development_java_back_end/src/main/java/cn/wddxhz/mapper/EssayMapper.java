package cn.wddxhz.mapper;


import cn.wddxhz.model.Essay;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface EssayMapper {

    List<Essay> getEssayList();

    List<Essay> getEssayListByUserId(Integer userId);

    Integer addEssay(Essay essay);

    Integer updataEssay(Essay essay);

    Integer delEssayById(Integer id);
}
