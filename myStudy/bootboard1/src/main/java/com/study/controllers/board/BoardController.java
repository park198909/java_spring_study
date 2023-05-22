package com.study.controllers.board;

import com.study.models.board.*;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.*;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/board")
public class BoardController {

    @Autowired
    private BoardSaveService saveService;
    @Autowired
    private BoardListService listService;
    @Autowired
    private BoardViewService viewService;
    @Autowired
    private BoardRemoveService removeService;
    @Autowired
    private BoardDao boardDao;

    @GetMapping("/write")
    public String write(@ModelAttribute BoardForm boardForm) {

        return "board/write";
    }

    @PostMapping("/save")
    public String save(@Valid BoardForm boardForm, Errors errors) {
        if (errors.hasErrors()) {
            return "board/write";
        }

        // 저장하기
        saveService.save(boardForm);

        return "redirect:/board/list";
    }

    @GetMapping("/delete/{id}")
    public String remove(@PathVariable Long id) {
        Board board = boardDao.get(id);

        // 삭제하기
        removeService.remove(board.getId());

        return "redirect:/board/list";
    }

    @GetMapping("/list")
    public String list(Model model) {
        List<Board> items = listService.gets();
        model.addAttribute("items", items);

        return "board/list";
    }
    @GetMapping("/view/{id}")
    public String view(@PathVariable Long id, Model model) {
        Board view = viewService.get(id);
        model.addAttribute("view", view);
        return "board/view";
    }

}
