package com.hall.DAO;

import com.hall.Bean.Comments;
import com.hall.Bean.CommentsExample;
import com.hall.Bean.CommentsWithBLOBs;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CommentsMapper {
    long countByExample(CommentsExample example);

    int deleteByExample(CommentsExample example);

    int deleteByPrimaryKey(Integer commentid);

    int insert(CommentsWithBLOBs record);

    int insertSelective(CommentsWithBLOBs record);

    List<CommentsWithBLOBs> selectByExampleWithBLOBs(CommentsExample example);

    List<Comments> selectByExample(CommentsExample example);

    CommentsWithBLOBs selectByPrimaryKey(Integer commentid);

    int updateByExampleSelective(@Param("record") CommentsWithBLOBs record, @Param("example") CommentsExample example);

    int updateByExampleWithBLOBs(@Param("record") CommentsWithBLOBs record, @Param("example") CommentsExample example);

    int updateByExample(@Param("record") Comments record, @Param("example") CommentsExample example);

    int updateByPrimaryKeySelective(CommentsWithBLOBs record);

    int updateByPrimaryKeyWithBLOBs(CommentsWithBLOBs record);

    int updateByPrimaryKey(Comments record);

    CommentsWithBLOBs selectLatestCommentByHouseid(int houseid);

    List<CommentsWithBLOBs>  selectCommentByHouseid(int houseid);

    List<Integer> selectImageCommentId(int houseid);


    List<CommentsWithBLOBs> queryNeedToReply(int id);

    List<Double> selectRatings(int hid);

    List<Integer> getAllCid();
}