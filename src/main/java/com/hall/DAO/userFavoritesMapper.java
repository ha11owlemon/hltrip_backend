package com.hall.DAO;

import com.hall.Bean.userFavorites;
import com.hall.Bean.userFavoritesExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface userFavoritesMapper {
    long countByExample(userFavoritesExample example);

    int deleteByExample(userFavoritesExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(userFavorites record);

    int insertSelective(userFavorites record);

    List<userFavorites> selectByExample(userFavoritesExample example);

    userFavorites selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") userFavorites record, @Param("example") userFavoritesExample example);

    int updateByExample(@Param("record") userFavorites record, @Param("example") userFavoritesExample example);

    int updateByPrimaryKeySelective(userFavorites record);

    int updateByPrimaryKey(userFavorites record);

    List<Integer> getFavorids(int userid);
}