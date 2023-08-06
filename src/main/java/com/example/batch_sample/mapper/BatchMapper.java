package com.example.batch_sample.mapper;

import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface BatchMapper {
    List<String> selectAllBoardContent();
}
