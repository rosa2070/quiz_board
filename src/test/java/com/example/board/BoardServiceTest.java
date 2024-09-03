package com.example.board;

import com.example.board.dto.Board;
import com.example.board.mybatis.BoardService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;

@SpringBootTest
public class BoardServiceTest {

    @Autowired
    private BoardService service;

    @Test
    void insert(){
        int n = service.insert(new Board("John Doe", "Sample Title", "Sample Content", 0, new Date(System.currentTimeMillis())));
    }
}
