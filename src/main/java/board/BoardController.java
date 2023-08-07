package board;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/board")
public class BoardController {

    private BoardService boardService;

    public void setBoardService(BoardService boardService) {
        this.boardService = boardService;
    }

    @GetMapping
    public String board(Model model) {
        boardService.resetAutoIncrement();
        List<BoardDto> boards = boardService.listAll();
        model.addAttribute("boards", boards);
        return "/board/list";
    }

    @GetMapping("/detail")
    public String showDetail(@RequestParam long id, Model model) {
        BoardDto boardDetail = boardService.searchDetail(id);
        model.addAttribute("boardDetail", boardDetail);
        return "/board/detail";
    }

    @GetMapping("/write")
    public String write() {
        return "/board/write";
    }
}
