package com.example.board.mybatis;

import com.example.board.dto.Board;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

@Service
public class BoardService {
    @Autowired
    private BoardMapper mapper;

    public int insert(Board board) {
        return mapper.insert(board);
    }

    public int count() {
        return mapper.count();
    }

    public List<Board> list(HashMap<String, Object> map) {
        return mapper.list(map);
    }




}
