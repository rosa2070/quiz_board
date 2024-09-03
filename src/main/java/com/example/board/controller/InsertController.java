package com.example.board.controller;

import com.example.board.dto.Board;
import com.example.board.mybatis.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class InsertController {

    @Autowired
    BoardService service;

    @GetMapping("/board/insert")
    public String insertForm() {
        return "board/insert";
    }

    @PostMapping("/board/insert")
    public String insert(@ModelAttribute Board dto, Model model) {
        try {
            service.insert(dto);
            model.addAttribute("result", "게시물등록성공!");
        } catch (Exception e) {
            System.out.println(e.getMessage());
            model.addAttribute("result", "게시물등록실패");
        }
        return "board/result";
    }
}
