package com.hall.DAO;

import com.hall.Bean.CommentImages;
import com.hall.Bean.CommentImagesExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CommentImagesMapper {
    long countByExample(CommentImagesExample example);

    int deleteByExample(CommentImagesExample example);

    int deleteByPrimaryKey(Integer imageid);

    int insert(CommentImages record);

    int insertSelective(CommentImages record);

    List<CommentImages> selectByExample(CommentImagesExample example);

    CommentImages selectByPrimaryKey(Integer imageid);

    int updateByExampleSelective(@Param("record") CommentImages record, @Param("example") CommentImagesExample example);

    int updateByExample(@Param("record") CommentImages record, @Param("example") CommentImagesExample example);

    int updateByPrimaryKeySelective(CommentImages record);

    int updateByPrimaryKey(CommentImages record);

    int deleteImages(@Param("ids") Integer[] ids);
}