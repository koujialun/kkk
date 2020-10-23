package com.jk.kjl.mapper;

import com.jk.kjl.entity.storerank;
import org.apache.ibatis.annotations.Mapper;


import java.util.List;
@Mapper
public interface storerankMapper {
    int deleteByPrimaryKey(Long id);

    int insert(storerank record);

    int insertSelective(storerank record);

    storerank selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(storerank record);

    int updateByPrimaryKey(storerank record);


    List<storerank> find();
}