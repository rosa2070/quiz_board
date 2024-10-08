package com.example.board.controller;

import com.example.board.mybatis.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.HashMap;

@Controller
public class ListController {
    @Autowired private BoardService boardService;

    @GetMapping("/board/list")
    public String list(@RequestParam(name="page", defaultValue = "1")int page, Model model) {
        //한번에 3페이지씩 보이게 설정함 (1,2,3 -> 4,5,6 ..)
        int start = (page-1)*3 + 1;
        int end = start + 2;

        int startPage = (page-1)/3*3 + 1;
        int endPage = startPage + 2;
        int pageCount = (int)Math.ceil(boardService.count());
        if (endPage > pageCount) {
            endPage = pageCount;
        }
        HashMap<String, Object> map = new HashMap<>();
        map.put("startRow", start);
        map.put("endRow", end);

        model.addAttribute("startPage", startPage);
        model.addAttribute("endPage", endPage);
        model.addAttribute("pageCount", pageCount);
        model.addAttribute("list", boardService.list(map));
        model.addAttribute("page", page);

        return "board/list";


    }

}
