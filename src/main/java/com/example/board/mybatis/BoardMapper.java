package com.example.board.mybatis;

import com.example.board.dto.Board;
import org.apache.ibatis.annotations.Mapper;

import java.util.HashMap;
import java.util.List;

@Mapper
public interface BoardMapper {
    int insert(Board board);
    List<Board> list(HashMap<String, Object> map);
    int count();

}
